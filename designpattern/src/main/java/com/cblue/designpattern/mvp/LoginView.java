package com.cblue.designpattern.mvp;

/**
 * 把View层针对控件操作抽象出来一些接口,专供UI调用的
 * Created by pavel on 16/5/25.
 */
public interface LoginView {

    public String getName();
    public String getPassword();
    public void showMessage(String msg);//显示登录结果
}
