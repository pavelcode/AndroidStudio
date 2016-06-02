package com.cblue.customerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
*
* 自定义View的第一种方式：继承基本控件
* */
public class CustomerViewActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerview_activity01);
    }
}
