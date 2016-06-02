package com.cblue.designpattern.mvp;

/**
 * Created by pavel on 16/5/25.
 */
public class LoginPresenterImpl implements LoginPresenter,LoginListener {

    //private UserService userService;
    private LoginView loginView;


    public LoginPresenterImpl(final LoginView loginView){
        this.loginView = loginView;

    }

    @Override
    public void login() {
        UserBean userBean = new UserBean();
        userBean.setName(loginView.getName());
        userBean.setPassword(loginView.getPassword());
        boolean status = false;
        String n = userBean.getName();
        String p = userBean.getPassword();
        if(n!=null&&"zhang".equals(n)){
            if(p!=null&&"123".equals(p)){
                status = true;
            }
        }
        loginStatus(status);
    }

    @Override
    public void loginStatus(boolean status) {
        if(status){
            loginView.showMessage("登录成功");
        }else{
            loginView.showMessage("登录失败");
        }
    }
}
