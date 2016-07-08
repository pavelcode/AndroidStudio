package com.cblue.adapter.screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cblue.androidstudio.R;

/**
 * 使用dimens来控制在不同分辨率手机的上控件是屏幕的一半
 */
public class ScreenAdapterActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_adapter02);
    }
}
