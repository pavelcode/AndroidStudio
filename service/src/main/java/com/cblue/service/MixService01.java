package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.MediaController;

/**
 * Created by pavel on 16/6/3.
 */
public class MixService01 extends Service {


    public class myBinder extends Binder{

         public void play(){
             MixService01.this.play();
         }

        public void stop(){
            MixService01.this.stop();
        }
    }

    MediaPlayer mediaPlayer = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.beautiful);
        mediaPlayer.setLooping(false);
    }

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


   public void play(){
       if(mediaPlayer!=null){
           mediaPlayer.start();
       }
   }

    public void stop(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("aaa","ondestory");
    }





}
