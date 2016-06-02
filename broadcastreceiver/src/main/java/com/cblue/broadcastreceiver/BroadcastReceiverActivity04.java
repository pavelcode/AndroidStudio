package com.cblue.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 使用代码注册和取消注册广播
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiverActivity04 extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2,btn3;
    BroadcastReceiver04 broadcastReceiver04 ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceiver_activity04);

        btn1 = (Button)findViewById(R.id.broadcastreceiver_activity04_btn01);
        btn2 = (Button)findViewById(R.id.broadcastreceiver_activity04_btn02);
        btn3 = (Button)findViewById(R.id.broadcastreceiver_activity04_btn03);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        broadcastReceiver04 = new BroadcastReceiver04();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.broadcastreceiver_activity04_btn01:
                //代码注册广播
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("code_broadcast");
                registerReceiver(broadcastReceiver04,intentFilter);
                break;
            case R.id.broadcastreceiver_activity04_btn02:
                //代码取消注册广播
                unregisterReceiver(broadcastReceiver04);
                break;
            case R.id.broadcastreceiver_activity04_btn03:
                //发送广播
                sendBroadcast(new Intent().setAction("code_broadcast"));
                break;
        }
    }
}
