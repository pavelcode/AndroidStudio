package com.cblue.android5;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cblue.androidstudio.R;

public class SwipeRefreshLayoutActivity01 extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    TextView tv;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiperefreshlayout_activity01);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swiperefreshlayout_activity01_srl);
        tv = (TextView)findViewById(R.id.swiperefreshlayout_activity01_tv);
        recyclerView = (RecyclerView)findViewById(R.id.swiperefreshlayout_activity01_rv);

        //设置SwipeRefreshLayout的颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,android.R.color.holo_red_light);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                tv.setText("开始刷新");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       tv.setText("刷新完成");
                        swipeRefreshLayout.setRefreshing(false);

                    }
                },5000);

            }
        });

    }
}
