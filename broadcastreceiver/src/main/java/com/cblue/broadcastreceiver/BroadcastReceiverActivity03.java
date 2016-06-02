package com.cblue.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 发送广播出现的Notification提示
 * Created by pavel on 16/5/18.
 */
public class BroadcastReceiverActivity03 extends AppCompatActivity {

    private Button btn1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceiver_activity03);
        btn1 = (Button)findViewById(R.id.broadcastreceiver_activity03_btn01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent01 = new Intent(BroadcastReceiverActivity03.this,BroadcastReceiver_Notification.class);
                sendBroadcast(intent01);
            }
        });

    }
}
