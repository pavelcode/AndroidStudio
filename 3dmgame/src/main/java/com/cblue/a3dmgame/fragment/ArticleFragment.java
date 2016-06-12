package com.cblue.a3dmgame.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cblue.a3dmgame.R;
import com.cblue.a3dmgame.adapter.BannerViewPagerAdapter;
import com.cblue.a3dmgame.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章列表的Fragment
 */
public class ArticleFragment extends Fragment {

    //默认请求的网络记录数
    private int record_count = 10;
    //文章类型
    private int typeid;



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
        ImageView imageView01 = new ImageView(getActivity());;
        ImageView imageView02 = new ImageView(getActivity());
        ImageView imageView03 = new ImageView(getActivity());
        //让图片铺满屏幕
        imageView01.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView02.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView03.setScaleType(ImageView.ScaleType.FIT_XY);


        imageView01.setImageResource(R.drawable.banner1);
        imageView02.setImageResource(R.drawable.banner2);
        imageView03.setImageResource(R.drawable.banner3);
        images.add(imageView01);
        images.add(imageView02);
        images.add(imageView03);

        //得到ViewPager下面的点
        View point1 =  view.findViewById(R.id.mainactivity_fragment_banner_myviewpager_point1);
        View point2 = view.findViewById(R.id.mainactivity_fragment_banner_myviewpager_point2);
        View point3 = view.findViewById(R.id.mainactivity_fragment_banner_myviewpager_point3);
       // point1.setBackgroundResource(R);


        bannerViewPagerAdapter = new BannerViewPagerAdapter(images);
        myViewPager.setAdapter(bannerViewPagerAdapter);




        //加载新闻界面
        TextView tv  = (TextView) view.findViewById(R.id.fragment_article_tv);
        tv.setText(typeid+"");
        return view;
    }
}

