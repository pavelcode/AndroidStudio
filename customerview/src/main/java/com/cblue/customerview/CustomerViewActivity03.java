package com.cblue.customerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 自定义View实现的第三种方式：继承View，并且自定义属性
 * Created by pavel on 16/5/24.
 */
public class CustomerViewActivity03 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerview_activity03);
    }
}
