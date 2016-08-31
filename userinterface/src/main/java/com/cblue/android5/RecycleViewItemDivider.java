package com.cblue.android5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 设置分割线
 * Created by pavel on 16/7/13.
 */
public class RecycleViewItemDivider extends RecyclerView.ItemDecoration {

    private Paint paint;

    //每个Item被绘制之前进行
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //super.onDraw(c, parent, state);
        //得到分割线的起点
        final int left = parent.getPaddingLeft();
        //得到分割线的终点
        final int right = parent.getWidth()-parent.getPaddingRight();
         //得到item的条数
        final int itemcount = parent.getChildCount();

        if(paint==null){
            paint = new Paint();
            paint.setColor(Color.BLACK);
        }
        if(itemcount>0){
            //给每一个item画线
            for(int i=0;i<itemcount;i++){
                View view =  parent.getChildAt(i);
                //x轴起点，y轴起点  x轴的终点  y轴终点
                c.drawLine(left,view.getBottom(),right,view.getBottom(),paint);
            }

        }
    }

    //在绘制完Item后进行绘制
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    //每个Item设置一定的偏移量
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, 0);
    }
}
