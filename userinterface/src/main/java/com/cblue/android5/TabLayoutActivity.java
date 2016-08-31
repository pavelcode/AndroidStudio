package com.cblue.android5;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cblue.androidstudio.R;

/**
 * TabLayout+ViewPager实现tab效果
 */
public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    String [] title = new String[10];
    String [] content = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_activity);

        tabLayout = (TabLayout)findViewById(R.id.tablayout_activity_tl);

        initData();

        //给Tab添加标题
        for (int i = 0; i <title.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(title[i]));
        }
        //实例化ViewPager
        viewPager = (ViewPager)findViewById(R.id.tablayout_activity_vp);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),title);
        viewPager.setAdapter(adapter);
        //给ViewPager添加监听(这里我们直接使用TabLayout里面提供的TabLayoutOnPageChangeListener无需自己再编写)
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //设置setOnTabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换到指定的item
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {
        for(int i=0;i<10;i++){
            title[i]= "title"+i;
            content[i] = "content"+i;
        }

    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] title = null;
        public MyPagerAdapter(FragmentManager fm, String[] title) {
            super(fm);
            this.title = title;
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fg=new TabLayoutFragment();
            Bundle bundle=new Bundle();
            bundle.putString("CONTENT",content[position]);
            fg.setArguments(bundle);
            return fg;
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }
}
