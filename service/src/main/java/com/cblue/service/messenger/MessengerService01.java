package com.cblue.service.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class MessengerService01 extends Service {
    public MessengerService01() {
    }



    Messenger messenger = new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //从服务端获得的消息，然后处理之后发送给客户端
            Message msgToClient =  Message.obtain(msg);
            Log.i("aaa","得到客户端的消息:"+msgToClient.arg1+"和"+msgToClient.arg2);
            msgToClient.arg1 = msgToClient.arg1 +msgToClient.arg2;
            try {
                msgToClient.replyTo.send(msgToClient);
            }catch (Exception e){

            }

        }
    });

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return messenger.getBinder();
    }




}
