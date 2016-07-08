package com.cblue.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 使用StartService实现文件下载
 */
public class StartServiceActivity04 extends AppCompatActivity {


    String url="https://www.baidu.com/img/bd_logo1.png";
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice_activity04);
        btn1 = (Button)findViewById(R.id.startserviceactivity04_btn01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开始下载服务
                Intent intent = new Intent(StartServiceActivity04.this,StartService04.class);
                intent.putExtra("url",url);
                startService(intent);
            }
        });

    }
}
