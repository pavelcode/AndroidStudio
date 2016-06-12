package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
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


        Intent batteryIntent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        //获得剩余当前电量
        int level1 = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        //电量最大值
        int scale1 = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        Log.i("aaa","level="+level1);
        Log.i("aaa","scale="+scale1);

        Log.i("aaa","总电量为："+((level1*100)/scale1)+"%");


        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
            //获得剩余当前电量
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            //电量最大值
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            Log.i("aaa","level="+level);
            Log.i("aaa","scale="+scale);

            Log.i("aaa","总电量为："+((level*100)/scale)+"%");


        }
    }
}
