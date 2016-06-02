package com.cblue.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 演示绑定服务,并传值
 * Created by pavel on 16/5/19.
 */
public class BoundServiceActivity01 extends AppCompatActivity implements View.OnClickListener{



    Button btn1,btn2,btn3;
    Intent intent;
    boolean isConnect = false;

    BoundService01.MyBinder myBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boundservice_activity01);
        btn1 = (Button)findViewById(R.id.boundservice_activity01_btn1);
        btn2 = (Button)findViewById(R.id.boundservice_activity01_btn2);
        btn3 = (Button)findViewById(R.id.boundservice_activity01_btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        intent = new Intent(BoundServiceActivity01.this,BoundService01.class);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boundservice_activity01_btn1:
                //绑定Service
                isConnect = true;
                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.boundservice_activity01_btn2:
                //取消绑定Service
                if(isConnect) {
                    unbindService(serviceConnection);
                    isConnect = false;
                }
                break;
            case R.id.boundservice_activity01_btn3:
                //传递数据
                Parcel setData = Parcel.obtain();
                Parcel getData = Parcel.obtain();
                setData.writeString("setData");
                try {
                    myBinder.transact(0,setData,getData,1);
                    String get = getData.readString();
                    Log.i("aaa","get="+get);
                }catch(Exception e){

                }

                break;
        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("aaa","onServiceConnected");
            //得到Bound服务的MyBinder对象,这里得到的就是MyBinder类的实例
            myBinder =(BoundService01.MyBinder)iBinder;
            myBinder.doSomeThing();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            //这个方法只有Service异常销毁时（内存不足），才会被调用
            Log.i("aaa","onServiceDisconnected");

        }
    };
}
