package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by pavel on 16/5/19.
 */
public class BoundService02 extends Service {


    private MyBinder myBinder = new MyBinder();
    private MediaPlayer mediaPlayer;

    public class MyBinder extends Binder{

        public void start(){
            if(mediaPlayer!=null){
                //pause后只需要直接start就行了，但是stop后需要重新prepare后才能start。 但是直接用prepare会报错
                mediaPlayer.start();

            }
        }
        public void pause(){

            if(mediaPlayer!=null){
                mediaPlayer.pause();
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}
