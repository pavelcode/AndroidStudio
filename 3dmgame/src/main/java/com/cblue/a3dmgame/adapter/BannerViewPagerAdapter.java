package com.cblue.a3dmgame.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * 首页中Fragment顶部的自定义ViewPager的适配器
 * Created by pavel on 16/6/12.
 */
public class BannerViewPagerAdapter extends PagerAdapter {


    private List<View> images;

    public BannerViewPagerAdapter(List<View> images) {
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // super.destroyItem(container, position, object);
        ((ViewPager)container).removeView(images.get(position));
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }


}
