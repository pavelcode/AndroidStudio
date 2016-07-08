package com.cblue.a3dmgame.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.cblue.a3dmgame.R;
import com.cblue.a3dmgame.service.DataService;
import com.cblue.a3dmgame.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;


/**
 * 动画显示
 * 判断网络
 * 服务下载数据
 */

public class WelcomeActivity extends AppCompatActivity {

    private static final String SHAREDPREFERENCES_NAME ="first_pref" ;
    GifImageView gifImageView ;
    Intent activityIntent;

    private static final int STARTSERVER = 1000; //启动服务
    private static final int GO_MAIN = 1001; //跳转到主界面
    private static final int GO_GUIDE = 1002; //跳转到引导界面

    boolean networkState; //判断网络是否正常

    // 延迟1秒
    private static final long SPLASH_DELAY_MILLIS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        gifImageView = (GifImageView)findViewById(R.id.welcome_activity_gitimageview);

        //设置透明度动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(3000);
        gifImageView.startAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 1 网络访问问题,如果没有网络的话，跳出一个对话框，点设置进入网络设置
                   networkState = NetUtils.detector(WelcomeActivity.this);
                Log.i("aaa","networkState="+networkState);
                // 2 如果网络正常，启动服务下载数据
                if (networkState) {
                    mHandler.sendEmptyMessage(STARTSERVER);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (!networkState) {
                    Toast.makeText(getApplicationContext(), "网络不可用", Toast.LENGTH_LONG).show();
                }
                // 3 使用SharePreference是否以前登陆判断
                isFirstLogin();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    /**
     * 判断是否是第一次登陆
     *
     */
    private void isFirstLogin() {
        // 读取SharedPreferences中需要的数据
        SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, MODE_PRIVATE);
        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        boolean isFirstIn = preferences.getBoolean("isFirstIn", true);
        Log.i("aaa", "isFirstIn=" + isFirstIn);
        // isFirstIn = false;
        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (!isFirstIn) {
            // 使用Handler的postDelayed方法，1秒后执行跳转到MainActivity
            mHandler.sendEmptyMessageDelayed(GO_MAIN, SPLASH_DELAY_MILLIS);
        } else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
        }

    }

    /**
     * Handler:启动服务或跳转到不同界面
     */
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STARTSERVER:
                    startDataServer();
                    break;
                case GO_MAIN:
                    goMain();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void startDataServer() {
        Intent serviceIntent = new Intent(WelcomeActivity.this, DataService.class);
        startService(serviceIntent);
    }

    private void goGuide() {
        activityIntent = new Intent(WelcomeActivity.this, GuideActivity.class);
        startActivity(activityIntent);
        this.finish();
    }

    private void goMain() {
        activityIntent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(activityIntent);
        finish();
    }




}
