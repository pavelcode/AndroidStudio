package com.cblue.customerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/*
*
* 自定义View实现的第二种方式：继承容器
* */
public class CustomerViewActivity02 extends AppCompatActivity implements View.OnClickListener {

    CustomerView02 customerView02;

    Button btn1,btn2;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerview_activity02);
        customerView02 = (CustomerView02)findViewById(R.id.customerview02);
        btn1 = (Button)customerView02.findViewById(R.id.customerview02_btn01);
        btn2 = (Button)customerView02.findViewById(R.id.customerview02_btn02);
        tv = (TextView)customerView02.findViewById(R.id.customerview02_tv01);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.customerview02_btn01:
                tv.setText("btn1");
                break;
            case R.id.customerview02_btn02:
                tv.setText("btn2");
                break;
        }

    }
}
