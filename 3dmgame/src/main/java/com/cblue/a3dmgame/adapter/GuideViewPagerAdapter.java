package com.cblue.a3dmgame.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.cblue.a3dmgame.R;
import com.cblue.a3dmgame.activity.MainActivity;

import java.util.List;

/**
 * Created by pavel on 16/6/13.
 */
public class GuideViewPagerAdapter extends PagerAdapter {

    private static final String TAG ="ViewPagerAdapter";

    // 界面列表
    private List<View> views;
    private Activity activity;


    public GuideViewPagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }

    // 实例化Item

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(views.get(position));
        return views.get(position);
    }

    //获得当前界面数
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    // 判断是否由对象生成界面
    //判断一个页面视图是否和instantiateItem返回值关联
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    // 销毁
    @Override
    public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }





}
