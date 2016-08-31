package com.cblue.android5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.cblue.androidstudio.R;

/**
 * 设置不显示actionBar
 * CoordinatorLayout+AppBarLayout+CollapsingToolbarLayout+ToolBar 实现顶部拖动隐藏头部
 * NestedScrollView 下面实现滚动效果 里面只包含一个子元素 使用include包含cardView
 */
public class CoordinatorLayoutActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayout_activity02);

    }
}
