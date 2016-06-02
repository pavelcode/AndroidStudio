package com.cblue.android5;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cblue.androidstudio.R;


/**
 * 设置Snackbar，动作，动作文字颜色
 */
public class SnackbarActivity01 extends AppCompatActivity implements View.OnClickListener {


    Button btn1;
    View showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar_activity01);
        btn1 = (Button)findViewById(R.id.snackbar_acitivity01_btn01);
        btn1.setOnClickListener(this);

        showView = findViewById(R.id.snackbar_acitivity01_view01);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.snackbar_acitivity01_btn01:
                //最简单的snackbar
                //Snackbar.make(view,"mysnack",Snackbar.LENGTH_LONG).show();
                //添加action的snackbar
                /*
                Snackbar.make(view,"snakckaction",Snackbar.LENGTH_LONG).setAction("myaction", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"snackaction被点击了",Toast.LENGTH_LONG).show();
                    }
                }).show();
                */
               //设置snackbar的action颜色
                Snackbar snackbar = Snackbar.make(view,"snackcolor",Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(Color.parseColor("#ff0000"));
                snackbar.setAction("snackcoloraction", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"snackcoloraction被点击了",Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
                break;
        }
    }
}
