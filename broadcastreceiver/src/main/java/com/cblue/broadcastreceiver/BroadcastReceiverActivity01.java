package com.cblue.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/*
*
* 使用清单文件注册的方式发送广播
*    1 使用显示Intent发送广播
*    2 使用隐示Intent发送广播
* */
public class BroadcastReceiverActivity01 extends AppCompatActivity implements View.OnClickListener{


    private Button btn1;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceiver_activity01);

        btn1 = (Button)findViewById(R.id.broadcastreceiver_activity01_btn01);
        btn2 = (Button)findViewById(R.id.broadcastreceiver_activity01_btn02);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.broadcastreceiver_activity01_btn01:
                //显示Intent发送广播
                Intent intent01 = new Intent(BroadcastReceiverActivity01.this,BroadcastReceiver01.class);
                sendBroadcast(intent01);

                break;
            case R.id.broadcastreceiver_activity01_btn02:
                //隐示Intent发送广播
                Intent intent02 = new Intent();
                intent02.setAction("aaa");
                sendBroadcast(intent02);
                break;
        }

    }
}
