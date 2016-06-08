package com.cblue.framework.dragger2;

import dagger.Component;

/**
 * 把Module对象注入到那个Activity中
 * Created by pavel on 16/6/6.
 */
@Component(modules = UserModule.class)
public interface UserComponent {

      void inject(LoginActivity loginActivity);

}
