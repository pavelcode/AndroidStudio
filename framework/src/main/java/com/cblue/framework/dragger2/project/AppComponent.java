package com.cblue.framework.dragger2.project;

import dagger.Component;

/**
 * 将系统的模型注入到activity中
 * Created by pavel on 16/6/6.
 */
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(AppApplication appApplication);
}
