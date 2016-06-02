package com.cblue.pulltorefresh;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cblue.customerview.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 使用PullToRefresh实现下拉刷新 上拉加载
 * Created by pavel on 16/5/24.
 */
public class PullToRefreshActivity01 extends AppCompatActivity {

    private LinkedList<String> mListItems;
    private PullToRefreshListView mPullRefreshListView;
    private ArrayAdapter<String> mAdapter;

    //数据源
    String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pulltorefresh_activity01);
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);


        ListView actualListView = mPullRefreshListView.getRefreshableView();
        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListItems);
        actualListView.setAdapter(mAdapter);
        /**
         * PullToRefreshBase
         * 实现 接口  OnRefreshListener2<ListView>  以便与监听  滚动条到顶部和到底部
         */
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh( PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(PullToRefreshActivity01.this, "onPullDownToRefresh", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute("down");
            }
            @Override
            public void onPullUpToRefresh( PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(PullToRefreshActivity01.this, "onPullUpToRefresh", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute("up");
            }
        });

        /**
         *   Add Sound Event Listener
         *   设置下拉刷新和上拉加载时的 铃声（可有可无）
         */
        /*
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener<ListView>(this);
        soundListener.addSoundEvent(State.PULL_TO_REFRESH, R.raw.pull_event);
        soundListener.addSoundEvent(State.RESET, R.raw.reset_sound);
        soundListener.addSoundEvent(State.REFRESHING, R.raw.refreshing_sound);
        mPullRefreshListView.setOnPullEventListener(soundListener);*/

        // You can also just use setListAdapter(mAdapter) or
        // mPullRefreshListView.setAdapter(mAdapter)



    }

    //模拟网络加载数据的   异步请求类
    //
    private class GetDataTask extends AsyncTask<String, Void, String> {

        //子线程请求数据
        @Override
        protected String doInBackground(String... params) {
            // Simulates a background job.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            return params[0];
        }

        //主线程更新UI
        @Override
        protected void onPostExecute(String result) {

            //向RefreshListView Item 添加一行数据  并刷新ListView
            //mListItems.addLast("Added after refresh...");
            if("down".equals(result)){
                mListItems.addFirst("Added down refresh...");
            }else if("up".equals(result)){
                mListItems.addLast("Added up refresh...");
            }
            mAdapter.notifyDataSetChanged();

            //通知RefreshListView 我们已经更新完成
            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

}
