package com.cblue.baidumap;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by pavel on 16/5/23.
 */
public class BaidumapApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
    }
}
