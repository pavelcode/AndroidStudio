package com.cblue.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 使用StartService播放音乐
 * Created by pavel on 16/5/19.
 */
public class StartServiceActivity03 extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice_activity03);
        btn1 =(Button)findViewById(R.id.startserviceactivity03_btn01);
        btn2 = (Button)findViewById(R.id.startserviceactivity03_btn02);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        intent = new Intent(StartServiceActivity03.this,StartService03.class);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.startserviceactivity03_btn01:
            //播放音乐
                startService(intent);
                break;
            case R.id.startserviceactivity03_btn02:
                //停止音乐
                stopService(intent);
                break;
        }
    }
}
