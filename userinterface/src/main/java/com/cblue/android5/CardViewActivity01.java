package com.cblue.android5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

import com.cblue.androidstudio.R;


/**
 * CardView演示
 * 使用拖动条演示卡片的阴影和圆角效果
 */
public class CardViewActivity01 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar01,seekBar02;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_activity01);

        cardView = (CardView)findViewById(R.id.cardviewactivity01_carview);
        seekBar01 = (SeekBar)findViewById(R.id.cardviewactivity01_seekbar01);
        seekBar02 = (SeekBar)findViewById(R.id.cardviewactivity01_seekbar02);
        seekBar01.setOnSeekBarChangeListener(this);
        seekBar02.setOnSeekBarChangeListener(this);


    }

    //最后一个参数表示滚动条的拖动是人为的
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch (seekBar.getId()){
            case  R.id.cardviewactivity01_seekbar01:
               //控制阴影
                    cardView.setCardElevation(i);

            break;

            case R.id.cardviewactivity01_seekbar02:
               //控制圆角
                cardView.setRadius(i);

            break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
