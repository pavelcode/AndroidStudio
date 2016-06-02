package com.cblue.aidlserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * AIDL服务端
 */
public class AIDLServiceActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction("com.android.AIDLSERVICE");
        //Android5.0后service不能采用隐式启动，故此处加上包名
        intent.setPackage("com.cblue.aidlserver");//
        //Intent intent = new Intent("com.android.AIDLSERVICE");
        startService(intent);
        Log.i("aaa","AIDLService启动");

    }
}
