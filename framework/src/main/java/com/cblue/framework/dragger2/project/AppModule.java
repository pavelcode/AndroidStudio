package com.cblue.framework.dragger2.project;

import dagger.Module;
import dagger.Provides;

/**
 * 得到系统级别的操作对象
 * Created by pavel on 16/6/6.
 */
@Module
public class AppModule {

    @Provides
    HttpManager provideHttpManager(){
        return new HttpManager();
    }

}
