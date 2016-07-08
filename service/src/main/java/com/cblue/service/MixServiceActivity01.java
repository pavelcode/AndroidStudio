package com.cblue.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 混合服务调用音乐服务(error 不明原理，不要讲)
 */
public class MixServiceActivity01 extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2;
    Intent intent = null;
    MixService01.myBinder myBinder;
    boolean serviceRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mixservice_activity01);

        btn1 = (Button)findViewById(R.id.mixservice_activity01_btn01);
        btn2 = (Button)findViewById(R.id.mixservice_activity01_btn02);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        //启动服务，然后绑定服务
        intent = new Intent(MixServiceActivity01.this,MixService01.class);
        startService(intent);
        //BIND_AUTO_CREATE 表示当服务还没有创建的时候，就创建一个
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        serviceRunning = true;



    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MixService01.myBinder)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onClick(View view) {
           switch (view.getId()){
               case R.id.mixservice_activity01_btn01:
                 //开始播放
                   myBinder.play();
                   break;
               case R.id.mixservice_activity01_btn02:
                  //停止播放
                   myBinder.stop();
                   //停止服务
                   if(serviceRunning) {
                       unbindService(serviceConnection);
                       stopService(intent);
                       serviceRunning = false;
                   }
                   break;

           }
    }
}
