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

    /**
     * 这个方法重新，是由子类决定测量的宽高
     * @param widthMeasureSpec  宽的测量值
     * @param heightMeasureSpec  高的测量值
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //如果设定的是match_parent就得到屏幕的宽度，如果使用wrap_content的话，就可以在屏幕范围内任意指定值
        // 参数1 默认值，测量的大小
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
