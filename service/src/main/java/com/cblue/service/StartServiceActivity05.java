package com.cblue.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Service结合Notification展示下载进度
 */
public class StartServiceActivity05 extends AppCompatActivity {

    Button btn;
    String url="https://www.baidu.com/img/bd_logo1.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice_activity05);
        btn = (Button)findViewById(R.id.startserviceactivity05_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartServiceActivity05.this,StartService05.class);
                intent.putExtra("urlStr",url);
                startService(intent);
            }
        });
    }
}
