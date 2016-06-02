package com.cblue.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Service的线程问题
 * Created by pavel on 16/5/18.
 */
public class StartServiceActivity02 extends AppCompatActivity {


    Button btn;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice_activity02);
        btn = (Button)findViewById(R.id.startserviceactivity02_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent  = new Intent(StartServiceActivity02.this,StartService02.class);
                startService(intent);
            }
        });

    }
}
