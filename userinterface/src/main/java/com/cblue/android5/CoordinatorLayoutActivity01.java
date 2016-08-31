package com.cblue.android5;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cblue.androidstudio.R;


/**
 * CoordinatorLayout实现的SnackBar显示的时候，实现FloatingActionButton的躲避遮挡效果
 */
public class CoordinatorLayoutActivity01 extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayout_activity01);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.coordinatorlayoutactivity01_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"coordinatorLayout",Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
