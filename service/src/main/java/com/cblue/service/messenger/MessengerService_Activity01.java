package com.cblue.service.messenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cblue.service.R;

/**
 * 使用Messenger在不同进程中传递数据
 * Activity作为客户端，Service作为服务端
 * 当我们从客户端通过Messenger传递一个Message给服务端
 * 服务端也通过一个Messenger对象传递数据给服务端
 * Activity和Service在不同应用中
 */
public class MessengerService_Activity01 extends AppCompatActivity {


    Button btn1;
    Intent intent;
    Messenger messenger;
    Messenger replyMessenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messengerservice_activity01);
        btn1 = (Button)findViewById(R.id.messengerservice_activity01_btn01);
        replyMessenger = new Messenger(handler);
        intent = new Intent();
        intent.setAction("com.cblue.messengerserver.MessengerService01");
        bindService(intent,new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                messenger= new Messenger(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message msg = Message.obtain();
                msg.arg1=1;
                msg.arg2=2;
                msg.replyTo = replyMessenger;
                try {
                    messenger.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("aaa","得到服务端的消息："+msg.arg1);
        }
    };


}
