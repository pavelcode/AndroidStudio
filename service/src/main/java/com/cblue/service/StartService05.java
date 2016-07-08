package com.cblue.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
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
public class StartService05 extends Service{

    NotificationManager manager;
    NotificationCompat.Builder builder;
    MyHandler myHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //创建Notification
        builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText("下载图片");
        builder.setContentText("下载中...");
        myHandler = new MyHandler();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.i("aaa",""+msg.arg1);
            if(msg.arg1!=0){
                //更新Notification的进度
               //当最后一个参数  进度刻度的（false）,循环流动的（true）
                builder.setProgress(100,msg.arg1,false);
                manager.notify(0,builder.build());
            }

            if(msg.what==1) {
                stopSelf();
                //下载完成之后，更新完成信息
                builder.setContentText("下载完成");
                manager.notify(0,builder.build());
               // Toast.makeText(getApplicationContext(), "下载完成", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String urlStr = intent.getStringExtra("urlStr");

        Log.i("aaa","urlStr="+urlStr);
        new Thread(new MyRunnable(urlStr)).start();

        //显示Notification
        manager.notify(0,builder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    class MyRunnable implements  Runnable{

        private String urlStr;
        public MyRunnable(String urlStr){
            this.urlStr = urlStr;
        }
        @Override
        public void run() {

            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCode = conn.getResponseCode();
                Log.i("aaa","responsecoce="+responseCode);
                if (responseCode == 200) {
                    //得到文件的总大小
                    int contentLength = conn.getContentLength();
                    Log.i("aaa","cotentLength="+contentLength);
                    //下载文件的当前进度
                    int currentContentLength = 0;
                    InputStream inStream = conn.getInputStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int len = -1;
                    byte[] buffer = new byte[10];
                    while((len=inStream.read(buffer))!=-1)
                    {
                        outputStream.write(buffer, 0, len);
                        //把下载的文件的长度加入到当前进度中
                        currentContentLength+=len;
                        Log.i("aaa","currentContentLength="+currentContentLength);
                        //得到下载进度
                        int currentRate = (int)(currentContentLength/(float)contentLength*100);
                        Log.i("aaa","currentRate"+currentRate);
                        Message msg = Message.obtain();
                        msg.arg1= currentRate;
                        myHandler.sendMessage(msg);

                    }
                    byte[] data = outputStream.toByteArray();
                    boolean flag =  writeSDCardFile("my.png",data);
                    Log.i("aaa","flag="+flag);
                    if(flag){
                        myHandler.sendEmptyMessage(1);
                    }
                }
            }catch (Exception e){
                  e.printStackTrace();
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
