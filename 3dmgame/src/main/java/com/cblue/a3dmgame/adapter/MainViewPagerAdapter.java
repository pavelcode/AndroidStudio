package com.cblue.a3dmgame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 主Activity的ViewPagerd适配器
 * Created by pavel on 16/6/12.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    public MainViewPagerAdapter(FragmentManager fm,List<Fragment> fragmets) {
        super(fm);
        this.fragments = fragmets;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
