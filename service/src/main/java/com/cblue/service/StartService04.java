package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pavel on 16/6/8.
 */
public class StartService04 extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    MyHandler myHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        myHandler = new MyHandler();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //得到下载的URL地址
        String url = intent.getStringExtra("url");
        Log.i("aaa","url="+url);
        new Thread(new MyRunnable(url)).start();
        return super.onStartCommand(intent, flags, startId);
    }

    class MyRunnable implements  Runnable{

        private String urlStr ;
        public MyRunnable(String url){
          this.urlStr = url;
       }

        @Override
        public void run() {
            try
            {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // TODO 不注释这行 responseCode=405
                //conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCode = conn.getResponseCode();
                Log.i("aaa","responsecoce="+responseCode);
                if (responseCode == 200)
                {
                    InputStream inStream = conn.getInputStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int len = -1;
                    byte[] buffer = new byte[1024];
                    while((len=inStream.read(buffer))!=-1)
                    {
                        outputStream.write(buffer, 0, len);
                    }

                    byte[] data = outputStream.toByteArray();
                    boolean flag =  writeSDCardFile("my.apk",data);
                    Log.i("aaa","flag="+flag);
                    if(flag){
                        myHandler.sendEmptyMessage(1);
                    }
                }

             }catch (Exception e){

            }
        }
    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1) {
                stopSelf();
                Toast.makeText(getApplicationContext(), "下载完成", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean writeSDCardFile(String fileName, byte[] data)
            throws Exception {
        boolean flag = false;
        // 判断SD卡的状态
        String state = Environment.getExternalStorageState();
        FileOutputStream mFileOutputStream;
        // SD卡是否挂载成功
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // 得到SD卡的根目录 /storage/sdcard
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            //File root = Environment.getExternalStorageDirectory().;
            Log.i("SDCardFileTools", root.toString());
            // 创建写入文件对象
            File file = new File(root, fileName);
            mFileOutputStream = new FileOutputStream(file);
            mFileOutputStream.write(data, 0, data.length);
            flag = true;
            if (mFileOutputStream != null) {
                mFileOutputStream.close();
            }
        }
        return flag;
    }


}
