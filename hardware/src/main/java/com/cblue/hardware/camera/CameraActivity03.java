package com.cblue.hardware.camera;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.cblue.hardware.R;

public class CameraActivity03 extends AppCompatActivity {


    MenuPopWindow  menuWindow;
    View.OnClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera03);
        Button btn = (Button) this.findViewById(R.id.popwindow_showmenu);
        //把文字控件添加监听，点击弹出自定义窗口
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //实例化SelectPicPopupWindow

                LayoutInflater layoutInflater = (LayoutInflater) CameraActivity03.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mMenuView = layoutInflater.inflate(R.layout.activity_camera03_popwindow_menu, null);
                menuWindow = new MenuPopWindow(CameraActivity03.this,mMenuView, listener);
                //显示窗口
                menuWindow.showAtLocation(CameraActivity03.this.findViewById(R.id.popwindow), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
            }
        });

        //为弹出窗口实现监听类
        listener = new View.OnClickListener(){

            public void onClick(View v) {
                menuWindow.dismiss();
                switch (v.getId()) {
                    case R.id.btn_take_photo:
                        Toast.makeText(CameraActivity03.this, "臭美的，拍张照片把", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_pick_photo:
                        Toast.makeText(CameraActivity03.this, "臭美的，找张照片把", Toast.LENGTH_SHORT).show();
                        break;
                }


            }

        };

    }

}

class MenuPopWindow extends PopupWindow {

    private Button btn_take_photo, btn_pick_photo, btn_cancel;
    private View mMenuView;

    public MenuPopWindow(Context context,View mMenuView, View.OnClickListener onClickListener) {
        // TODO Auto-generated constructor stub
        super(context);

        btn_take_photo = (Button) mMenuView.findViewById(R.id.btn_take_photo);
        btn_pick_photo = (Button) mMenuView.findViewById(R.id.btn_pick_photo);
        btn_cancel = (Button) mMenuView.findViewById(R.id.btn_cancel);
        // 取消按钮
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // 销毁弹出框
                dismiss();
            }
        });

        // 设置按钮监听
        btn_pick_photo.setOnClickListener(onClickListener);
        btn_take_photo.setOnClickListener(onClickListener);
        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        // this.setAnimationStyle(R.style.AnimBottom);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
		/*mMenuView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});*/

    }
}
