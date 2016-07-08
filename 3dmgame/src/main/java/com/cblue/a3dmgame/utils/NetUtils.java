package com.cblue.a3dmgame.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络监测
 * Created by pavel on 16/6/13.
 */
public class NetUtils {

    public static boolean detector(Activity activity){
        //根据系统服务得到链接管理者
        boolean flag = false;
        //得到连接的管理对象
        ConnectivityManager connectivityManager = (ConnectivityManager)activity.getApplicationContext().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //如果连接的管理对象为空，直接返回
        if(connectivityManager==null){
            return flag;
        }
        //根据连接的管理对象得到网络的信息对象
        NetworkInfo networkInfo =  connectivityManager.getActiveNetworkInfo();
        //如果连接的信息对象不为空，或连接的信息对象是活动的，说明网络连接成功
        if(networkInfo!=null||networkInfo.isAvailable()){
            flag = true;
        }
        return flag;
    }

}
