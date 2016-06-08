package com.cblue.framework.dragger2.project;

import android.app.Application;

/**
 * 应用架构级别使用dragger2
 * 在应用启动的时候，注入系统级别对象
 * 在Activity启动的时候，注入activity级别的对象
 * Created by pavel on 16/6/6.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
         //系统启动的时候，注入系统级别对象
        DaggerAppComponent.builder().appModule(new AppModule()).build().inject(this);

    }
}
