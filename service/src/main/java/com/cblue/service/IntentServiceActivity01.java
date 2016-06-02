package com.cblue.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by pavel on 16/5/19.
 */
public class IntentServiceActivity01 extends AppCompatActivity implements View.OnClickListener{


    Button btn1,btn2;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentservice_activity01);
        btn1 = (Button)findViewById(R.id.intentservice_activity01_btn1);
        btn2 = (Button)findViewById(R.id.intentservice_activity01_btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        intent = new Intent(IntentServiceActivity01.this,IntentService01.class);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.intentservice_activity01_btn1:
                //启动服务
                startService(intent);


                break;
            case R.id.intentservice_activity01_btn2:
                //停止服务
                stopService(intent);
                break;
        }

    }
}
