package com.cblue.a3dmgame.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cblue.a3dmgame.R;
import com.cblue.a3dmgame.adapter.BannerViewPagerAdapter;
import com.cblue.a3dmgame.view.MyViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 文章列表的Fragment
 */
public class ArticleFragment extends Fragment implements ViewPager.OnPageChangeListener {

    //默认请求的网络记录数
    private int record_count = 10;
    //文章类型
    private int typeid;

    private View point1,point2,point3;



    BannerViewPagerAdapter bannerViewPagerAdapter;

    //BannerViewPager下面的点
    View point01,point02,point03;

    public ArticleFragment() {
    }

    public ArticleFragment(int typeid){
        this.typeid = typeid;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //当进入Activity，首先出现头部的加载数据

        //然后从本地加载数据
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        //第二个参数不是参数container
        View view =  inflater.inflate(R.layout.fragment_article_list,null);


        //加载首页Fragment顶部的banner
        MyViewPager myViewPager = (MyViewPager) view.findViewById(R.id.mainactivity_fragment_banner_myviewpager);
        //保存Banner中的图片
        List<View> images = new ArrayList<View>();
        int imageRsId [] = {R.drawable.banner1,R.drawable.banner2,R.drawable.banner3};

        for(int i=0;i<3;i++){
            ImageView imageView = new ImageView(getActivity());
            //设置图片的缩放类型  铺满全屏
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageRsId[i]);
            images.add(imageView);
        }
        bannerViewPagerAdapter = new BannerViewPagerAdapter(images);
        myViewPager.setAdapter(bannerViewPagerAdapter);
        myViewPager.addOnPageChangeListener(this);

        //得到自定义ViewPager下面的点
        point1 = view.findViewById(R.id.mainactivity_fragment_banner_myviewpager_point1);
        point2 = view.findViewById(R.id.mainactivity_fragment_banner_myviewpager_point2);
        point3 = view.findViewById(R.id.mainactivity_fragment_banner_myviewpager_point3);
        //初始Point的状态
        setPointStatus(0);


        //加载新闻界面
       // TextView tv  = (TextView) view.findViewById(R.id.fragment_article_tv);
       // tv.setText(typeid+"");

        PullToRefreshListView pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.fragment_article_pull_refresh_list);
        ListView actualListView = pullToRefreshListView.getRefreshableView();
        String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi"};
        LinkedList mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mListItems);
        actualListView.setAdapter(arrayAdapter);
        /**
         * PullToRefreshBase
         * 实现 接口  OnRefreshListener2<ListView>  以便与监听  滚动条到顶部和到底部
         */
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh( PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(getActivity(), "onPullDownToRefresh", Toast.LENGTH_SHORT).show();
                //new GetDataTask().execute("down");
            }
            @Override
            public void onPullUpToRefresh( PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(getActivity(), "onPullUpToRefresh", Toast.LENGTH_SHORT).show();
                //new GetDataTask().execute("up");
            }
        });



        return view;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setPointStatus(position);
    }

    //设置ViewPager底部显示点的状态
    private void setPointStatus(int position){
        point1.setBackgroundResource(R.drawable.articlefragment_viewpager_point_shape);
        point2.setBackgroundResource(R.drawable.articlefragment_viewpager_point_shape);
        point3.setBackgroundResource(R.drawable.articlefragment_viewpager_point_shape);
        switch (position){
            case 0:
                point1.setBackgroundResource(R.drawable.articlefragment_viewpager_point_shape_current);
                break;
            case 1:
                point2.setBackgroundResource(R.drawable.articlefragment_viewpager_point_shape_current);
                break;
            case 2:
                point3.setBackgroundResource(R.drawable.articlefragment_viewpager_point_shape_current);
                break;
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

