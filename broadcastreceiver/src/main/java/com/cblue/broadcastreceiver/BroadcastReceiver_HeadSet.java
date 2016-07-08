package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 检测耳机的状态
 * 必须是动态注册
 *<action android:name="android.intent.action.HEADSET_PLUG" android:enabled="true">
 *
 * state  0表示耳机拔出 1代表耳机插入
 * Created by pavel on 16/6/14.
 */
public class BroadcastReceiver_HeadSet extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.hasExtra("state")){
            if(intent.getIntExtra("state",-1)==0){
                Log.i("aaa","耳机拔出");
            }else if(intent.getIntExtra("state",-1)==1){
                Log.i("aaa","耳机插入");
            }
        }
    }
}
