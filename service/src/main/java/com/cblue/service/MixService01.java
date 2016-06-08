package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by pavel on 16/6/3.
 */
public class MixService01 extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new myBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("aaa","onUnbind");
        return super.onUnbind(intent);
    }

    public class myBinder extends Binder{

        public void play(){
            Log.i("aaa","play...");
        }

        public void pause(){
            Log.i("aaa","pause");
        }

        public void contiune(){
            Log.i("aaa","continue");
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("aaa","ondestory");
    }
}
