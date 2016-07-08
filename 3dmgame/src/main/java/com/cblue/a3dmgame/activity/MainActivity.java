package com.cblue.a3dmgame.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cblue.a3dmgame.R;
import com.cblue.a3dmgame.adapter.MainViewPagerAdapter;
import com.cblue.a3dmgame.fragment.ArticleFragment;

import java.util.ArrayList;
import java.util.List;

/*
 * 首先初始化界面控件
 *
 */
public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener {


    HorizontalScrollView horizontalScrollView;
    RadioGroup rg_top;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10;
    ViewPager viewPager;
    RadioGroup rg_bottom;
    RadioButton rb1_bottom,rb2_bottom,rb3_bottom;

     List<Fragment> fragments = null;
     MainViewPagerAdapter mainViewPagerAdapter = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initViewPagerData();


    }

    /**
     * 初始化数据
     */
    private void initViewPagerData() {

        fragments = new ArrayList<Fragment>();
        fragments.add(new ArticleFragment(0));
        fragments.add(new ArticleFragment(1));
        fragments.add(new ArticleFragment(2));
        fragments.add(new ArticleFragment(3));
        fragments.add(new ArticleFragment(4));
        fragments.add(new ArticleFragment(5));

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mainViewPagerAdapter);
        //设置预加载Fragment的个数，当前页面和两边2页
        viewPager.setOffscreenPageLimit(2);

    }

    /**
     * 初始化所有监听
     */
    private void initListener() {
        viewPager.addOnPageChangeListener(this);
        rg_top.setOnCheckedChangeListener(this);
        rg_bottom.setOnCheckedChangeListener(this);
    }

    /**
     * 初始化所有控件
     */
    private void initView() {
        horizontalScrollView = (HorizontalScrollView)findViewById(R.id.mainactivity_top_hsv);
        rg_top = (RadioGroup)findViewById(R.id.mainactivity_top_rg);

        rb1 = (RadioButton)findViewById(R.id.mainactivity_top_rb01);
        rb2 = (RadioButton)findViewById(R.id.mainactivity_top_rb02);
        rb3 = (RadioButton)findViewById(R.id.mainactivity_top_rb03);
        rb4 = (RadioButton)findViewById(R.id.mainactivity_top_rb04);
        rb5 = (RadioButton)findViewById(R.id.mainactivity_top_rb05);
        rb6 = (RadioButton)findViewById(R.id.mainactivity_top_rb06);
        rb7 = (RadioButton)findViewById(R.id.mainactivity_top_rb07);
        rb8 = (RadioButton)findViewById(R.id.mainactivity_top_rb08);
        rb9 = (RadioButton)findViewById(R.id.mainactivity_top_rb09);
        rb10 = (RadioButton)findViewById(R.id.mainactivity_top_rb10);
        rb1.setChecked(true);

        viewPager = (ViewPager)findViewById(R.id.mainactivity_vp);

        rg_bottom = (RadioGroup)findViewById(R.id.mainactivity_bottom_rg);

        rb1_bottom = (RadioButton)findViewById(R.id.mainactivity_bottom_rb01);
        rb2_bottom = (RadioButton)findViewById(R.id.mainactivity_bottom_rb02);
        rb3_bottom = (RadioButton)findViewById(R.id.mainactivity_bottom_rb03);


    }


    /**
     * ViewPager的监听实现
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        viewPager.setCurrentItem(position);
        //当我们滑动ViewPager的时候，让顶部的RadioButton跟着滑动
        horizontalScrollView.setVisibility(View.VISIBLE);
        rg_top.setVisibility(View.VISIBLE);
        RadioButton radioButton = (RadioButton) rg_top.getChildAt(position);
        Log.i("aaa","radiobutton.text="+radioButton.getText());
        radioButton.setChecked(true);
        //得到RaidoButton左侧的位置，让水平滚动到对应位置
        int left = radioButton.getLeft();
        horizontalScrollView.smoothScrollTo(left,0);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * GroupView的监听实现
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkid) {

         switch (checkid){
             case R.id.mainactivity_top_rb01:
                 Log.i("aaa","mainactivity_top_rb01点击了");
                 viewPager.setCurrentItem(0);
                 break;

             case R.id.mainactivity_top_rb02:
                 Log.i("aaa","mainactivity_top_rb02点击了");
                 viewPager.setCurrentItem(1);
                 break;
             case R.id.mainactivity_top_rb03:
                 Log.i("aaa","mainactivity_top_rb03点击了");
                 viewPager.setCurrentItem(2);
                 break;

             case R.id.mainactivity_bottom_rb01:
                 Log.i("aaa","mainactivity_bottom_rb01点击了");
                 rb1_bottom.setChecked(true);


                 //当点击下面的RadioButton的时候，顶部的RadioButton滑动的最左边
                 horizontalScrollView.smoothScrollTo(0,0);

                 viewPager.setCurrentItem(3);
                 break;
         }
    }
}
