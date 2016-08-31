package com.cblue.android5;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.TextView;

import com.cblue.androidstudio.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshLayoutActivity01 extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;

    List<RecyclerViewItem> recyclerViewItems  = null;

    RecyclerViewAdapter mRecyclerViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiperefreshlayout_activity01);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swiperefreshlayout_activity01_srl);

        //设置ProgressBar的背景颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        //设置ProgressBar的滚动颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        //设置ProgressBar的位置（第一参数含义是是否使用属性动画）
        //TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()) 把像素转化为dp
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));


        recyclerView = (RecyclerView)findViewById(R.id.swiperefreshlayout_activity01_rv);

        initData();

        //设置显示布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //参数 列的数目
     /*   GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);*/

        //设置分割线
        recyclerView.addItemDecoration(new RecycleViewItemDivider());


        //添加适配器
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,recyclerViewItems);
        recyclerView.setAdapter(mRecyclerViewAdapter);




        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<RecyclerViewItem> newDatas = new ArrayList<RecyclerViewItem>();
                        for (int i = 0; i <5; i++) {
                            newDatas.add(new RecyclerViewItem(R.mipmap.ic_launcher,"new data"+i));
                        }

                        //把之前的数据加入到新数据之后
                        newDatas.addAll(recyclerViewItems);
                        //移除适配器之前是数据
                        recyclerViewItems.removeAll(recyclerViewItems);
                        //把所有的数据重新加入到适配器中
                        recyclerViewItems.addAll(newDatas);
                        mRecyclerViewAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },5000);

            }
        });

    }

    private void initData(){
        recyclerViewItems = new ArrayList<RecyclerViewItem>();
        for(int i=0;i<20;i++){
            recyclerViewItems.add(new RecyclerViewItem(R.mipmap.ic_launcher,"info"+i));
        }
    }

}
