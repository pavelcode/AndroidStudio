package com.cblue.actionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 在低版本支持ActionBar功能
 * 对于低于2.1的版本的，可以使用继承ActionBarActivity来实现
 * 但是ActivityBarActivity已经过时，使用AppCompatActivity代替
 * Created by pavel on 16/5/17.
 */
public class ActionBarActivity01 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar02);
    }
}
