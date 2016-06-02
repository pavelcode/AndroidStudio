package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by pavel on 16/5/19.
 */
public class BoundService02 extends Service {


    private MyBinder myBinder = new MyBinder();
    private MediaPlayer mediaPlayer;

    public class MyBinder extends Binder{

        public void start(){
            if(mediaPlayer!=null){
                mediaPlayer.start();
            }
        }
        public void stop(){
            if(mediaPlayer!=null){
                mediaPlayer.stop();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(this,R.raw.beautiful);
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        myBinder.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}
