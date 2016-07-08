package com.cblue.adapter.screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cblue.androidstudio.R;

/***
 * 给不同的分辨率创建不同的布局文件
 */
public class ScreenAdapterActivity03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_activity);
    }
}
