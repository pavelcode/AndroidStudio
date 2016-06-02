package com.cblue.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 本地广播
 * TODO 注意 所有的注册和卸载都使用LocalBroadCastManager调用
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiverActivity05 extends AppCompatActivity{


    BroadcastReceiver broadcastReceiver;
    Button btn1;
    LocalBroadcastManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceiver_activity05);

        manager = LocalBroadcastManager.getInstance(getApplicationContext());

        btn1 = (Button)findViewById(R.id.broadcastreceiver_activity05_btn01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.sendBroadcast(new Intent().setAction("localboradcast"));
            }
        });


        broadcastReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("aaa","本地广播接收了");
            }
        };


    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("localboradcast");
        manager.registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterReceiver(broadcastReceiver);
    }
}
