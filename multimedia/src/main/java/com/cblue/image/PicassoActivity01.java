package com.cblue.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity01 extends AppCompatActivity {


    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_activity01);
        iv1 = (ImageView) findViewById(R.id.picasso_activity01_iv01);

        Picasso.with(getApplicationContext()).load("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png").into(iv1);
    }
}
