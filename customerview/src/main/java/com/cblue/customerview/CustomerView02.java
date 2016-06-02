package com.cblue.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by pavel on 16/5/24.
 */
public class CustomerView02 extends LinearLayout {
    public CustomerView02(Context context) {
        super(context);
    }

    public CustomerView02(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.customerview02,this,true);
    }

}
