package com.cblue.customerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * 自定义流式显示
 * https://github.com/LyndonChin/AndroidFlowLayout
 * Created by pavel on 16/5/24.
 */
public class FlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_activity);
        addChildTo(((FlowLayout) findViewById(R.id.flow_layout)));
    }


    private void addChildTo(FlowLayout flowLayout) {
        for (int i = 'A'; i < 'Z'; i++) {
            Button btn = new FlowButton(this);
            btn.setHeight(dp2px(32));
            btn.setTextSize(16);
           // btn.setTextColor(getResources().getColorStateList(R.color.checkable_text_color));
           // btn.setBackgroundResource(R.drawable.checkable_background);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i - 'A' + 4; j++) {
                sb.append((char) i);
            }
            btn.setText(sb.toString());
            flowLayout.addView(btn);
        }
    }

    public int dp2px(int dpValue) {
        return (int) (dpValue * getResources().getDisplayMetrics().density);
    }
}
