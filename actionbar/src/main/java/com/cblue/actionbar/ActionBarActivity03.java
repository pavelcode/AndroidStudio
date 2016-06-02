package com.cblue.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 *
 *  ActionBar上设置按钮和动作
 *  ActionBar的Home添加动作
 *
 * Created by pavel on 16/5/17.
 */
public class ActionBarActivity03 extends AppCompatActivity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        if(actionBar!=null){
            //显示标题
            actionBar.setDisplayShowTitleEnabled(true);
            //显示应用图标可以被点击
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbaractivity03_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_show01:
                Toast.makeText(ActionBarActivity03.this, "show01被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_hide01:
                Toast.makeText(ActionBarActivity03.this, "hide01被点击", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(ActionBarActivity03.this,"home被点击",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
