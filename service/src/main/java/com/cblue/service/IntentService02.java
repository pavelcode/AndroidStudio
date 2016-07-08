package com.cblue.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pavel on 16/6/12.
 */
public class IntentService02 extends IntentService {

    MyHandler myHandler = null;
    public IntentService02() {
        super("IntentService02");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        myHandler = new MyHandler();

    }

    @Override
    protected void onHandleIntent(Intent intent) {
          String urlStr = intent.getStringExtra("urlStr");
          Log.i("aaa","urlStr="+urlStr);
          downloadPic(urlStr);
    }


    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1) {
                stopSelf();
                Toast.makeText(getApplicationContext(), "下载完成", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void downloadPic(String urlStr){
        try
        {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
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
