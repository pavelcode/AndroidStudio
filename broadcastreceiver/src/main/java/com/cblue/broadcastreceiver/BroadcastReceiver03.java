package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiver03 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa","BroadcastReceiver03接收到广播");
        Bundle bundle = new Bundle();
        bundle.putString("info","BroadcastReceiver03--Info");
        setResultExtras(bundle);
    }
}
