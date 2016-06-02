package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by pavel on 16/5/18.
 */
public class StartService02 extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private MyHanlder myHanlder;

    class MyHanlder extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                stopSelf();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myHanlder = new MyHanlder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //执行耗时操作
        /*
        for (int i=0;i<5;i++){
            try {
                Thread.sleep(7*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("aaa",Thread.currentThread().getId()+"");
                for (int i=0;i<5;i++){
                    try {
                        Thread.sleep(7*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                myHanlder.sendEmptyMessage(1);
            }
        }).start();

        //粘性Service和非粘性Service
   /*	int sticky = Service.START_STICKY;
		int notsticky = Service.START_NOT_STICKY;
		int redeliver = Service.START_REDELIVER_INTENT;*/


        return super.onStartCommand(intent, flags, startId);
    }
}
