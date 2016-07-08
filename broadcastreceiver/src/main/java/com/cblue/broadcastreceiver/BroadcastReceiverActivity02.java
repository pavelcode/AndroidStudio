package com.cblue.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 使用隐示Intent发送无序广播和有序广播
 * 无序广播进行传值
 * 有序广播进行传值
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiverActivity02 extends AppCompatActivity implements View.OnClickListener{


    private Button btn1,btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceiver_activity02);

        btn1 = (Button)findViewById(R.id.broadcastreceiver_activity02_btn01);
        btn2 = (Button)findViewById(R.id.broadcastreceiver_activity02_btn02);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.broadcastreceiver_activity02_btn01:
             //发送无序广播
                Intent intent01= new Intent();
                intent01.setAction("aaa");
                sendBroadcast(intent01);
                break;
            case R.id.broadcastreceiver_activity02_btn02:
             //发送有序广播
                Intent intent02 = new Intent();
                intent02.setAction("bbb");
                sendOrderedBroadcast(intent02,null);
                break;
        }
    }
}
