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
 * Messenger客户端
 * 使用Messenger在不同进程中传递数据
 * 当我们从客户端通过Messenger传递一个Message给服务端
 * 服务端也通过一个Messenger对象传递数据给服务端
 */
public class MessengerService_Activity01 extends AppCompatActivity {


    Button btn1;
    Intent intent;
    Messenger sendMessenger;//客户端发送信息的Messenger
    Messenger clientMessenger; //被发送给服务端的Messenger
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messengerservice_activity01);
        btn1 = (Button)findViewById(R.id.messengerservice_activity01_btn01);

        clientMessenger = new Messenger(handler);
        //连接Messenger服务端
        intent = new Intent();
        intent.setAction("com.cblue.messengerserver.MessengerService01");
        bindService(intent,new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                sendMessenger= new Messenger(iBinder);
                Log.i("aaa","连接成功");
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
                //把客户端的Messenger传递给服务端，让服务端知道发送消息的接收着
                msg.replyTo = clientMessenger;
                try {
                    sendMessenger.send(msg);
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
