package com.cblue.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Checkable;

/**
 * 流布局中的按钮
 * Created by pavel on 16/5/24.
 */
public class FlowButton extends Button implements Checkable {
    private boolean mChecked;
    private static final int[] CHECKED_STATE_LIST = new int[]{android.R.attr.state_checked};

    private boolean mBroadcasting;

    private OnCheckedChangeListener mOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

    public FlowButton(Context context) {
        super(context);
    }

    public FlowButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (mChecked) {
            mergeDrawableStates(drawableState, CHECKED_STATE_LIST);
        }
        return drawableState;
    }


    /**
     * <p>Changes the checked state of this button.</p>
     *
     * @param checked true to check the button, false to uncheck it.
     */
    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();

            // Avoid infinite recursions if setChecked() is called from a listener
            if (mBroadcasting) {
                return;
            }

            mBroadcasting = true;
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
            if (mOnCheckedChangeWidgetListener != null) {
                mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
            }
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeWidgetListener = listener;
    }

    /**
     * Interface definition for a callback to be invoked when the checked state
     * of a checkable button changed.
     */
    public interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a checkable button has changed.
         *
         * @param buttonView The checkable button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        void onCheckedChanged(FlowButton buttonView, boolean isChecked);
    }

}