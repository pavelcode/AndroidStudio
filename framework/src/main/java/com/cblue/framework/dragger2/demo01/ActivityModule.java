package com.cblue.framework.dragger2.demo01;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pavel on 16/6/2.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity){
        this.mActivity = mActivity;
    }

    @Provides
    Activity providesActivity(){
        return mActivity;
    }


}
