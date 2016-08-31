package com.cblue.framework.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cblue.framework.R;


/**
 * 1.网络访问同步方法
 * 2.网络访问异步方法，返回的内容，然后在UI线程中更新
 *
 */
public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }
}
