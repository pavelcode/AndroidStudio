package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by pavel on 16/5/19.
 */
public class StartService03 extends Service {


    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        if(mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(this,R.raw.beautiful);
            mediaPlayer.setLooping(true);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
