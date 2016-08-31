package com.cblue.android5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

import com.cblue.androidstudio.R;


/**
 * CardView演示
 * 使用拖动条演示卡片的阴影和圆角效果
 */
public class CardViewActivity01 extends AppCompatActivity{

    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_activity01);

    }

}
