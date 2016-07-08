package com.cblue.a3dmgame.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cblue.a3dmgame.R;
import com.cblue.a3dmgame.adapter.GuideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 16/6/13.
 */
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {



    private ViewPager vp;
    private GuideViewPagerAdapter vpAdapter;
    private List<View> views;

    private ImageView[] dots; // 底部小点图片
    private int currentIndex;  // 记录当前选中位置

    private static final String SHAREDPREFERENCES_NAME = "first_pref";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initDots();
    }


    private void initView(){

        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        // 初始化引导图片列表
        views.add(inflater.inflate(R.layout.activity_guide_viewpager_step1, null));
        views.add(inflater.inflate(R.layout.activity_guide_viewpager_step2, null));
        views.add(inflater.inflate(R.layout.activity_guide_viewpager_step3, null));

        // 初始化Adapter
        vp = (ViewPager) findViewById(R.id.activity_guide_viewpager);
        vpAdapter = new GuideViewPagerAdapter(views, this);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.addOnPageChangeListener(this);

    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_guide_ll);
        dots = new ImageView[views.size()];

        // 循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);// 都设为灰色
        }

        currentIndex = 0;
        dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
    }


    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }
    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }
    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        // 设置底部小点选中状态
        if (position < 0 || position > views.size() - 1
                || currentIndex == position) {
            return;
        }
        //当前的图片设置为白色
        dots[position].setEnabled(false);
        //刚划过的图片设置为灰色
        dots[currentIndex].setEnabled(true);
        //划入的图片设置为当前图片
        currentIndex = position;


        if (position == views.size() - 1) {
            Button button = (Button)views.get(position).findViewById(R.id.activity_guide_viewpager_step3_btn);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setGuided();
                    goMain();
                }
            });

        }
    }


    /**
     *
     * 置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        // 存入数据
        editor.putBoolean("isFirstIn", false);
        // 提交修改
        editor.commit();
    }


    private void goMain() {
        // 跳转到主界面
        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
