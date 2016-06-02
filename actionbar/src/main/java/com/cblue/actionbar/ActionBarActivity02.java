package com.cblue.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 控制ActionBar的显示和隐藏
 * Created by pavel on 16/5/17.
 */
public class ActionBarActivity02 extends AppCompatActivity implements View.OnClickListener{

    private Button btn_show;
    private Button btn_hide;

    private ActionBar actionBar;


    //@Nullable 表示定义的字段可以为空
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar02);
        btn_show = (Button) findViewById(R.id.actionbar_activity02_btn01);
        btn_hide = (Button)findViewById(R.id.actionbar_activity02_btn02);

        btn_show.setOnClickListener(this);
        btn_hide.setOnClickListener(this);

        //如果是3.0以上版本，直接使用getActionBar
        actionBar = getSupportActionBar();




    }

    @Override
    public void onClick(View view) {
           switch (view.getId()){
               case R.id.actionbar_activity02_btn01:
                   actionBar.show();
                   break;
               case R.id.actionbar_activity02_btn02:
                   actionBar.hide();
                   break;
           }
    }
}
