package com.cblue.customerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

/**
 * 使用自定义View实现涂鸦效果
 *
 * Created by pavel on 16/5/24.
 */
public class CustomerViewActivity04 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //得到屏幕的宽高
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        CustomerView04 tuYaView = new CustomerView04(CustomerViewActivity04.this,dm.widthPixels,dm.heightPixels);
        setContentView(tuYaView);
    }
}
