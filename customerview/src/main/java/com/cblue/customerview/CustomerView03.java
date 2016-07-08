package com.cblue.customerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Created by pavel on 16/5/24.
 */
public class CustomerView03 extends View {

    Drawable drawable;
    String txtvalue;

    public CustomerView03(Context context) {
        super(context);
    }

    public CustomerView03(Context context, AttributeSet attrs) {
        super(context, attrs);
        //在values文件夹下创建一个arrays文件
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.customerview_attr);
        drawable = typedArray.getDrawable(R.styleable.customerview_attr_image);
        txtvalue = typedArray.getString(R.styleable.customerview_attr_txt);
        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Drawable类型转化成Bitmap类型

        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Paint paint =new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(18);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        //靠右边居中显示
        canvas.drawText(txtvalue,bitmap.getWidth(),bitmap.getHeight()-paint.getTextSize(), paint);
    }
}
