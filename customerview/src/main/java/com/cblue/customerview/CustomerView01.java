package com.cblue.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 从控件中获得属性
 * Created by pavel on 16/5/24.
 */
public class CustomerView01 extends TextView {

    private String viewValue;

    public CustomerView01(Context context) {
        super(context);
    }

    public CustomerView01(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewValue = attrs.getAttributeValue("http://schemas.android.com/apk/res/android","text");

    }

    public CustomerView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setFakeBoldText(true);
        canvas.drawText(viewValue,0,getTextSize(),paint);

    }


}
