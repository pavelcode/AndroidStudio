package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 接收SD卡状态改变
 * 可以在模拟器中setting--storeage setting--unmounted SDCard
 * Created by pavel on 16/5/31.
 */
public class BroadcastReceiver_SDCard extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if("android.intent.action.MEDIA_MOUNTED".equals(action)){
            Log.i("aaa","SD卡挂载");
        }else if("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
            Log.i("aaa","SD卡卸载");
        }else if("android.intent.action.MEDIA_REMOVED".equals(action)){
            Log.i("aaa","SD卡移除");

        }

    }
}
