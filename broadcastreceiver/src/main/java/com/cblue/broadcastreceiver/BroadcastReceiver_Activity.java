package com.cblue.broadcastreceiver;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * Created by pavel on 16/6/15.
 */
public class BroadcastReceiver_Activity extends Activity{


    BroadcastReceiver_OS startOS;
    BroadcastReceiver_SMS sms;
    BroadcastReceiver_Call call;
    BroadcastReceiver_HeadSet headSet;
    BroadcastReceiver_Net net;
    BroadcastReceiver_Battery battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //接收短信
        sms = new BroadcastReceiver_SMS();
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(sms,intentFilter1);

        //电话播出 接听ok
        call = new BroadcastReceiver_Call();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter2.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(call,intentFilter2);

        //耳机插入拔出ok
        headSet = new BroadcastReceiver_HeadSet();
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(headSet,intentFilter3);

        //网络状态变化ok
        net = new BroadcastReceiver_Net();
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(net,intentFilter4);

        //电量变化ok
        battery = new BroadcastReceiver_Battery();
        IntentFilter intentFilter5 = new IntentFilter();
        intentFilter5.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(battery,intentFilter5);




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(startOS);
        unregisterReceiver(sms);
        unregisterReceiver(call);
        unregisterReceiver(headSet);
        unregisterReceiver(net);
        unregisterReceiver(battery);

    }
}
