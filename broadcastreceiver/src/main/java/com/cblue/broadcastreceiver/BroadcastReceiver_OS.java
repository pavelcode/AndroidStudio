package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 系统启动广播
 * 清单文件中添加 <action android:name="android.intent.action.BOOT_COMPLETED"/>
 * 权限添加 android.permission.RECEIVE_BOOT_COMPLETED
 *
 * 系统关闭广播
 *   <action android:name="android.intent.action.ACTION_SHUTDOWN"/>
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver_OS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.i("aaa","系统启动了") ;
        //打开新的Activity
        Intent intent1 = new Intent(context,BroadcastReceiverActivity01.class);
        //当广播启动一个Activity，需要提供一个任务栈
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
        }else if(Intent.ACTION_SHUTDOWN.equals(intent.getAction())){
            Log.i("aaa","系统停止了") ;
        }

    }
}
