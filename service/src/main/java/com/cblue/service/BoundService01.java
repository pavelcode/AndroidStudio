package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by pavel on 16/5/19.
 */
public class BoundService01 extends Service {


    private MyBinder myBinder = new MyBinder();

    public class MyBinder extends Binder{

        public void doSomeThing(){
            //使用线程执行操作
            Log.i("aaa","doSomeThing");
        }
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String set =  data.readString();
            Log.i("aaa","set="+set);
            reply.writeString("get data");
            return super.onTransact(code, data, reply, flags);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("aaa","onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("aaa","onBind");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("aaa","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}