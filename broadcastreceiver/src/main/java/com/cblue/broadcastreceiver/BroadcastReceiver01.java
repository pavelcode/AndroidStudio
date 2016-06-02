package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver01 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa","BroadcastReceiver01接收到广播");
    }
}
