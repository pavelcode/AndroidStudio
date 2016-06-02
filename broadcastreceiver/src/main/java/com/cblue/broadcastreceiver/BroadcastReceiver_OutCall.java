package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 打电话接收的广播
 * 注册广播的action NEW_OUTGOING_CALL
 * 添加权限 PROCESS_OUTGOING_CALLS
 * Created by pavel on 16/5/31.
 */
public class BroadcastReceiver_OutCall extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String number = getResultData();
        Log.i("aaa","你拨打电话的号码是："+number);
    }
}


