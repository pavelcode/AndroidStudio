package com.cblue.framework.dragger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 得到控制类对象
 * Created by pavel on 16/6/6.
 */
@Singleton
@Module
public class UserModule {

    @Provides
    UserPresenter provideUserPresenter(){
        return new UserPresenter();
    }

}
