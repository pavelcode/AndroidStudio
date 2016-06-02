package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 使用代码注册的广播
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver04 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa","接收到使用代码注册的广播");
    }
}
