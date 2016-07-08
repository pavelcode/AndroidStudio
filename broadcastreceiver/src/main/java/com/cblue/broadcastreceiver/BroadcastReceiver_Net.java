package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 检测网络状态变化
 * <action android:name="android.net.conn.CONNECTIVITY_CHANGE"/>
   <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 *
 * Created by pavel on 16/6/14.
 */
public class BroadcastReceiver_Net extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //得到连接的网络信息
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
       if(networkInfo!=null){
           int netType = networkInfo.getType();
           if(ConnectivityManager.TYPE_WIFI==netType){
               Log.i("aaa","wifi连接"+networkInfo.getTypeName()+"--"+networkInfo.isConnected());
           }else if(ConnectivityManager.TYPE_MOBILE==netType){
               Log.i("aaa","手机网络连接"+networkInfo.getTypeName()+"--"+networkInfo.isConnected());
           }
       }


    }
}
