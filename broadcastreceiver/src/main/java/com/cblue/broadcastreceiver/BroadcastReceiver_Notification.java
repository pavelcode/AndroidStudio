package com.cblue.broadcastreceiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * 接收到广播提示Notification
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver_Notification extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        //TODO 少了这行代码一直出不来
        //错误：Ignoring notification with icon==0: Notification(pri=0 contentView=com.cblue.android/0x1090071 vibrate=null sound=null defaults=0x0 flags=0x0 kind=[null]
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("广播来了");
        builder.setContentTitle("广播标题");
        builder.setContentText("广播内容");
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1001, builder.build());
    }
}
