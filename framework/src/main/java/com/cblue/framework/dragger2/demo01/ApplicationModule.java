package com.cblue.framework.dragger2.demo01;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pavel on 16/6/2.
 */
@Module
public class ApplicationModule {

    Application mApplication;

    public ApplicationModule(Application mApplication){
        this.mApplication = mApplication;
    }
    @Provides
    Application providesApplication(){
        return mApplication;
    }
}
