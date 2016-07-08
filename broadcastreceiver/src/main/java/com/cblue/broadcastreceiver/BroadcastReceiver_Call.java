package com.cblue.broadcastreceiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * 接打电话接收的广播
 *
 *
 *<uses-permission android:name="android.permission.PROCESS_OUTGOING_CALLS"/>
 *<uses-permission android:name="android.permission.READ_PHONE_STATE" />
 *
 <intent-filter android:priority="1000">
 <action android:name="android.intent.action.NEW_OUTGOING_CALL"/>
 <action android:name="android.intent.action.PHONE_STATE"/>
 *
 *
 *
 * Created by pavel on 16/5/31.
 */
public class BroadcastReceiver_Call extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //如果是打电话
        if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){

           // String number = getResultData();i
            String number =  intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("aaa","你拨打电话的号码是："+number);

        }else{
            //如果是接电话
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            switch (telephonyManager.getCallState()){
                case TelephonyManager.CALL_STATE_RINGING:
                    //铃响
                   String incoming_number = intent.getStringExtra("incoming_number");
                    Log.i("aaa","接到"+incoming_number+"打过来的电话");
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    //拿起电话
                    Log.i("aaa","拿起电话");
                    break;

                case TelephonyManager.CALL_STATE_IDLE:
                    //挂断电话
                    Log.i("aaa","挂断电话");
                    break;
            }
        }

    }
}


