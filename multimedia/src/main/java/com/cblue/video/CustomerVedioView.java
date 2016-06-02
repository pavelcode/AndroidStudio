package com.cblue.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by pavel on 16/5/26.
 */
public class CustomerVedioView extends VideoView {
    public CustomerVedioView(Context context) {
        super(context);
    }

    public CustomerVedioView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerVedioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
