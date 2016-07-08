package com.cblue.customerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by pavel on 16/5/24.
 */
public class CustomerView04 extends View {

    //画笔
    private Paint paint;

    //画板
    private Canvas canvas;

    //纸
    private Bitmap bitmap;

    //我们画的每一条路径对象
    private Path path;

    //临时的保存当前坐标点
    private float mX,mY;

    public CustomerView04(Context context, int screenWidth, int screenHeight) {
        super(context);
        // TODO Auto-generated constructor stub
        //创建图片
        bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        //创建画布
        canvas = new Canvas(bitmap);

        paint = new Paint();
        paint.setAntiAlias(true);//设置平滑效果
        paint.setStyle(Paint.Style.STROKE);//实线
        paint.setStrokeWidth(5);

    }

    //当我们开始触摸手机屏幕的p，这里会得到手指的坐标
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //创建一个类
                path = new Path();
                path.moveTo(x, y);
                mX = x;
                mY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                //得到滑动的间距
                float dx = Math.abs(x-mX);
                float dy = Math.abs(y-mY);
                if(dx>=4||dy>=4){
                    path.lineTo(x, y);
                    //出现实时路线效果
                    canvas.drawPath(path, paint);
                }
                mX = x;
                mY = y;
                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();

        return true;
    }

    //把画出的内容画在屏幕上
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
