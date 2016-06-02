package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 监控当前电量广播
 *
 * <action android:name="android.intent.action.BATTERY_CHANGED"/>
 * android.permission.BATTERY_STATS
 *
 * 需要添加 <category android:name="android.intent.category.HOME"/>？
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver_Battery extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
            //获得当前电量
            int level = intent.getIntExtra("level", 0);
            //总电量刻度
            int scale = intent.getIntExtra("scale", 100);

            Log.i("aaa","总电量为："+((level*100)/scale)+"%");

            if(level<15){
                //做什么事情
            }
        }
    }
}
