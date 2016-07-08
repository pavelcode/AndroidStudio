package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * 接收到系统短信
 * 添加权限RECEIVE_SMS
 * android.provider.Telephony.SMS_RECEIVED
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver_SMS extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        // intent 存放的有接收到的短信的内容
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        String format = intent.getStringExtra("format");
        for (Object pdu : pdus) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);
            //API level 23 以后应该用
            //SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu,format);
            // 获取短信的正文内容
            String content = message.getMessageBody();
            //获取短信的发送者
            String address = message.getOriginatingAddress();
            Log.i("aaa","信息内容:"+content);
            Log.i("aaa","发送者"+address);

            /**
             * 中断广播的传递
             * 这时候必须设置广播的优先级，广播的优先级在-1000到1000之间
             * 如果设定广播的优先级为1000的话，就会在短信接收到之前拿到这个广播
             * 不能中断无序广播
             */
            if("110".equals(address)){
                abortBroadcast();

            }
        }
    }
}

/**
 * 当在清单文件中去掉main的启动的话，就不会在应用中产生图标，可以在应用管理中已经下载中可以到应用。
 * 但是，在4.0之后，广播需要启动一次之后，才能够接收广播，所以首先启动一次，然后删除main，这是一次更新。
 * 并且，就算是广播的进程关闭，当有广播来的时候，依然能启动进程，接收广播。
 */
