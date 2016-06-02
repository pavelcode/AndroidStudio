package com.cblue.customerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 流布局
 * Created by pavel on 16/5/24.
 */
public class FlowLayout extends ViewGroup {

    //默认的水平或垂直空间
    private static final int DEFAULT_HORIZONTAL_SPACING = 5;
    private static final int DEFAULT_VERTICAL_SPACING = 5;

    private int mVerticalSpacing;
    private int mHorizontalSpacing;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        try {
            mHorizontalSpacing = a.getDimensionPixelSize(
                    R.styleable.FlowLayout_horizontal_spacing, DEFAULT_HORIZONTAL_SPACING);
            mVerticalSpacing = a.getDimensionPixelSize(
                    R.styleable.FlowLayout_vertical_spacing, DEFAULT_VERTICAL_SPACING);
        } finally {
            a.recycle();
        }
    }


    public void setHorizontalSpacing(int pixelSize) {
        mHorizontalSpacing = pixelSize;
    }

    public void setVerticalSpacing(int pixelSize) {
        mVerticalSpacing = pixelSize;
    }

    /**
     * @Method 对控件进行测量
     * @param widthMeasureSpec  父类给的水平空间
     * @param heightMeasureSpec 父类给的垂直空间
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //查看resolveSize的源码，根据提供的尺寸，和测量的尺寸，方法里面会得到显示的模式，根据模式，返回View的显示大小
        int myWidth = resolveSize(0,widthMeasureSpec);

        //得到父控件的内间距
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        //让子控件的左边和顶部紧挨着父控件
        int childLeft = paddingLeft;
        int childTop = paddingTop;

        //行高
        int lineHeight = 0;
        // Measure each child and put the child to the right of previous child
        // if there's enough room for it, otherwise, wrap the line and put the child to next line.
        //循环得到每一个子控件
        for(int i=0,childCount =getChildCount();i<childCount;i++){
            View child = getChildAt(i);
            //如果子控件显示,测量子控件
            if(child.getVisibility()!=View.GONE){
                measureChild(child,widthMeasureSpec,heightMeasureSpec);
            }else{
                continue;
            }
            //得到子控件的宽高
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

             //确定一行的高度（默认是按照子控件的高度即为行高）
            lineHeight = Math.max(childHeight, lineHeight);


            //如果子控件的宽度大于父控件的宽度，进行换行
            if (childLeft + childWidth + paddingRight > myWidth) {
                childLeft = paddingLeft;
                childTop += mVerticalSpacing + lineHeight;
                lineHeight = childHeight;
            } else {
                //确定子控件在前面控件的右边
                childLeft += childWidth + mHorizontalSpacing;
            }
        }
        //得到想要的高度
        int wantedHeight = childTop + lineHeight + paddingBottom;
        //设置测量的大小，规模
        //resolveSize(wantedHeight, heightMeasureSpec)  根据提供的高度，得到能到使用的高度
        setMeasuredDimension(myWidth,resolveSize(wantedHeight, heightMeasureSpec));

    }

    /**
     * 对控件进行布局,用于放置子View的位置
     * @param 这是一个新的尺寸或者位置的视图
     * @param 父控件的左上角left、top以及右下角right、bottom
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int myWidth = r - l;

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();

        int childLeft = paddingLeft;
        int childTop = paddingTop;

        int lineHeight = 0;

        for (int i = 0, childCount = getChildCount(); i < childCount; ++i) {
            View childView = getChildAt(i);

            if (childView.getVisibility() == View.GONE) {
                continue;
            }

            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            lineHeight = Math.max(childHeight, lineHeight);

            if (childLeft + childWidth + paddingRight > myWidth) {
                childLeft = paddingLeft;
                childTop += mVerticalSpacing + lineHeight;
                lineHeight = childHeight;
            }

            childView.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
            childLeft += childWidth + mHorizontalSpacing;
        }
    }
}
