package com.cblue.framework.dragger2;

/**
 * Created by pavel on 16/6/6.
 */
public class UserPresenter {


    //用户验证
    public boolean login(User user){
        boolean flag = false;
        if(user!=null){
            if("zhangsan".equals(user.getName())&&"123".equals(user.getPassword())){
                flag = true;
            }
        }

        return flag;
    }
}
