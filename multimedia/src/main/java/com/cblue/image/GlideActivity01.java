package com.cblue.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideActivity01 extends AppCompatActivity {


    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_activiy01);
        iv = (ImageView)findViewById(R.id.glideactivity01_iv01);
        Glide.with(getApplicationContext()).load("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png").into(iv);
    }
}
