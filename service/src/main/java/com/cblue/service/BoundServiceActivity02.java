package com.cblue.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 使用BoundService播放音乐
 * Created by pavel on 16/5/19.
 */
public class BoundServiceActivity02 extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2;
    Intent intent;
    BoundService02.MyBinder myBinder;
    BoundService02 boundService02;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boundservice_activity02);
        btn1 = (Button)findViewById(R.id.boundservice_activity02_btn1);
        btn2 = (Button)findViewById(R.id.boundservice_activity02_btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        intent = new Intent(BoundServiceActivity02.this,BoundService02.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.boundservice_activity02_btn1:
                //播放音乐
                myBinder.start();
                break;
            case R.id.boundservice_activity02_btn2:
                //停止音乐
                myBinder.stop();
                break;
        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (BoundService02.MyBinder)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
