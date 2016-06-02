package com.cblue.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pavel on 16/5/19.
 */
public class IntentService01 extends IntentService {

    //必须实现父类的构造方法
    public IntentService01(){
        super("IntentService01");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("aaa","onCreate");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("aaa","onHandlerIntent");

        for(int i=0;i<10;i++){
            Log.i("aaa","线程ID="+Thread.currentThread().getId()+"--"+i);
            try {
                Thread.sleep(7*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("aaa","onDestroy");
    }
}
