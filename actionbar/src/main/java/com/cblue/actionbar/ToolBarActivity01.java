package com.cblue.actionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

/**
 * ToolBar实现ActionBar效果
 * Created by pavel on 16/5/17.
 */
public class ToolBarActivity01 extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 这里的位置很重要，一定要在setContentView之上
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.toolbar01);

        toolbar = (Toolbar)findViewById(R.id.toolbar01);

        //toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("Title");//设置主标题
        toolbar.setSubtitle("Subtitle");//设置子标题

        toolbar.inflateMenu(R.menu.toolbaractivity01_menu);//设置右上角的填充菜单
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(ToolBarActivity01.this , "search" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_notice) {
                    Toast.makeText(ToolBarActivity01.this , "notice" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_add) {
                    Toast.makeText(ToolBarActivity01.this , "add" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_show) {
                    Toast.makeText(ToolBarActivity01.this , "show" , Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });


    }
}
