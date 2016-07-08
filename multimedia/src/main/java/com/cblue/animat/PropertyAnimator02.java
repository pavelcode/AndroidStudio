package com.cblue.animat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cblue.image.R;

public class PropertyAnimator02 extends AppCompatActivity {


    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animator01);
        iv = (ImageView) findViewById(R.id.property_animitor01_iv);

    }

    public void doAnimator(View view){
        ObjectAnimator objectAnimator =  ObjectAnimator.ofFloat(iv,"alpha",0F,1f);
       /* objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });*/


        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(PropertyAnimator02.this,"动画执行完毕",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        objectAnimator.setDuration(3000).start();


    }


}
