package com.cblue.android5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.cblue.androidstudio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 16/5/26.
 */
public class RecyclerViewActivity01 extends AppCompatActivity {


    RecyclerView recyclerView;

    List<RecyclerViewItem> recyclerViewItems  = null;

    RecyclerViewAdapter mRecyclerViewAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity01);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_activity01_recyclerview);

        initData();

        //设置显示布局
        /*
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);*/

        //参数 列的数目
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);


        //添加适配器
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,recyclerViewItems);
        recyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.setItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View v, String data) {
                Toast.makeText(RecyclerViewActivity01.this, "你点击了"+data, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initData(){
        recyclerViewItems = new ArrayList<RecyclerViewItem>();
        for(int i=0;i<10;i++){
            recyclerViewItems.add(new RecyclerViewItem(R.mipmap.ic_launcher,"info"+i));
        }
    }



}
