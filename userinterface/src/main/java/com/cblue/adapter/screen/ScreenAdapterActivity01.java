package com.cblue.adapter.screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cblue.androidstudio.R;

/**
 * 根据不同手机的像素密度，加载不同像素密度的图片
 */
public class ScreenAdapterActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceen_adpater01);
    }
}
