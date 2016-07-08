package com.cblue.adapter.screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cblue.androidstudio.R;

/**
 * 使用代码来精确控制TextView占整个屏幕的1/4
 */
public class ScreenAdapterActivity04 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_adapter04);

        TextView tv  = (TextView) findViewById(R.id.screen_adpater_activity04_tv);
        //获取封装当前手机屏幕信息对象，用于存放宽高值
        DisplayMetrics metrics  = new DisplayMetrics();
        //给当前屏幕设置宽高
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //获取高度
        int srceenHeight = metrics.heightPixels;
        //获取宽度
        int srceenWidth = metrics.widthPixels;
        Log.i("aaa", "Constant.srceenHeight = "+srceenHeight);
        Log.i("aaa", "Constant.srceenWidth = "+srceenWidth);
        //宽高各占50%
        RelativeLayout.LayoutParams layoutParams = new
                RelativeLayout.LayoutParams(
                (int)(srceenWidth*0.5+0.5),//代码里面进行转化的时候还需要有一个偏移值：0.5f
                (int)(srceenHeight*0.5+0.5));
        tv.setLayoutParams(layoutParams);
    }
}
