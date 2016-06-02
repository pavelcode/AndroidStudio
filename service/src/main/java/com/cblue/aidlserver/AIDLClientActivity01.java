package com.cblue.aidlserver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cblue.service.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * AIDL的客户端
 * TODO 主要包要一致
 *
 */
public class AIDLClientActivity01 extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2;
    Intent intent;
    IMyAidlInterface myAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidlclient_activity01);

        btn1 = (Button)findViewById(R.id.aidlclient_activity01_btn01);
        btn2 = (Button)findViewById(R.id.aidlclient_activity01_btn02);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        intent = new Intent ();
        intent.setAction("com.cblue.aidlserver.AIDLService01");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aidlclient_activity01_btn01:
                //绑定服务
                Log.i("aaa","绑定服务") ;
                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE) ;
                break;
            case R.id.aidlclient_activity01_btn02:
                //调用服务
                Log.i("aaa","调用服务") ;
                try{
                 int result=   myAidlInterface.add(3,4);
                    Log.i("aaa","result="+result);

                    List<String> list = new ArrayList<String>();
                    list.add("zhang");
                    list.add("li");
                    List<String> backList = myAidlInterface.getData(list);
                    for(int i=0;i<backList.size();i++){
                        Log.i("aaa","返回的"+backList.get(i));
                    }
                    Person p = new Person("一休",20);
                    Person bPerson = myAidlInterface.getPerson(p);
                    Log.i("aaa","person="+bPerson);

                }catch (Exception e){

                }

                break;
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myAidlInterface = null;
        }
    };
}
