package com.cblue.android5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cblue.androidstudio.R;

/**
 * FloatingActionButton的简单使用
 */
public class FloatActionButtonActivity01 extends AppCompatActivity {


    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floatactionbutton_activity01);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatactionbar_activity01_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"floatingactionbutton",Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
