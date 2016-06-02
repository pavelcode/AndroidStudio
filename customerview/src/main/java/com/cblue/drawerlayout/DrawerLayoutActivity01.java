package com.cblue.drawerlayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.cblue.customerview.R;


/**
 * 使用ToolBar和DrawerLayout实现侧滑效果
 */

public class DrawerLayoutActivity01 extends AppCompatActivity {

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView drawerLayout_LV;
    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};
    private ArrayAdapter arrayAdapter;
    private ImageView ivRunningMan;
    private AnimationDrawable mAnimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //清单文件中，一定要设置@style/Theme.AppCompat.Light.NoActionBar
        setContentView(R.layout.drawerlayout_activity01);

        toolbar = (Toolbar) findViewById(R.id.toobar);
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#000000")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(DrawerLayoutActivity01.this, "打开", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(DrawerLayoutActivity01.this, "关闭", Toast.LENGTH_SHORT).show();

            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        //设置左侧弹出的内容
        drawerLayout_LV = (ListView) findViewById(R.id.drawerlayout_lv);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        drawerLayout_LV.setAdapter(arrayAdapter);

    }
}
