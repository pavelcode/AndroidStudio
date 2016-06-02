package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * 监控应用的状态：安装，更新，卸载
 * Created by pavel on 16/5/31.
 */
public class BroadcastReceiver_Package extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        //得到卸载应用的包名
        Uri uri = intent.getData();
        if("android.intent.action.PACKAGE_ADDED".equals(action)){
            Log.i("aaa",uri.toString()+"被安装");

        }else if("android.intent.action.PACKAGE_REPLACED".equals(action)){
            Log.i("aaa",uri.toString()+"被更新");

        }else if("android.intent.action.PACKAGE_REMOVED".equals(action)){
            Log.i("aaa",uri.toString()+"被卸载");

        }
    }
}
