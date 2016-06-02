package com.cblue.android5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cblue.androidstudio.R;

/**
 * CoordinatorLayout+AppBarLayout+ToolBar 实现顶部的拖动效果
 */
public class CoordinatorLayoutActivity02 extends AppCompatActivity {

    Toolbar toolbar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayout_activity02);
       // toolbar = (Toolbar) findViewById(R.id.coordinatorlayout_activity02_toolbar);
       // setSupportActionBar(toolbar);
    }
}
