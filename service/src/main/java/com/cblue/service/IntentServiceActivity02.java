package com.cblue.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 使用IntentService完成图片下载
 */
public class IntentServiceActivity02 extends AppCompatActivity {

    Button btn;
    String url="https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentservice_activity02);
        btn = (Button)findViewById(R.id.intentservice_activity02_btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(IntentServiceActivity02.this,IntentService02.class);
                intent.putExtra("urlStr",url);
                startService(intent);
            }
        });
    }
}
