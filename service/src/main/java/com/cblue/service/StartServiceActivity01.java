package com.cblue.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/*
*
* 启动Service
* 打印生命周期并传递参数
* 查看服务：设置-》应用程序-》正在运行
* TODO
* */

public class StartServiceActivity01 extends AppCompatActivity implements View.OnClickListener{

    private Button btn1,btn2;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice_activity01);
        btn1 = (Button)findViewById(R.id.startserviceactivity01_btn01);
        btn2 = (Button)findViewById(R.id.startserviceactivity01_btn02);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        intent = new Intent(StartServiceActivity01.this,StartService01.class);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.startserviceactivity01_btn01:
                //启动服务
                intent.putExtra("name","zhang");
                startService(intent);
                break;
            case R.id.startserviceactivity01_btn02:
                //停止服务
                stopService(intent);
                break;
        }
    }
}
