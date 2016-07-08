package com.cblue.adapter.version;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pavel on 16/7/8.
 */
public class VersionAdapterActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //当前手机的版本号
        //版本信息查下 Default Settings--Appearance&Behhavior--System Settings--Android SDK
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ActionBar actionBar = getActionBar();
        }

    }
}
