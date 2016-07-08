package com.cblue.animat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cblue.image.R;

/**
 * 使用补间动画，只是修改了界面的重绘效果（当图片移动之后，依然只能点击原来的位置）
 * 属性动画是真正修改了图片的位置属性
   当多个属性动画（右移，下移，旋转）执行的时候，会发现动画是叠加效果,并且是异步实现的
 使用PropertyValueHolder实现动画叠加效果（google对叠加效果做了优化）
 使用AnimatorSet实现动画叠加效果
 使用AnimatorSet实现动画顺序效果
 使用play  with  before after控制动画顺序

 * Created by pavel on 16/7/4.
 */
public class PropertyAnimator01 extends AppCompatActivity{


    ImageView iv;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animator01);
         iv = (ImageView) findViewById(R.id.property_animitor01_iv);


    }

    public void show(View view){
        Toast.makeText(PropertyAnimator01.this, "show", Toast.LENGTH_SHORT).show();

    }

    public void doAnimator(View view) {
        Toast.makeText(PropertyAnimator01.this, "move", Toast.LENGTH_SHORT).show();
     /*   TranslateAnimation tranlateAnimation = new TranslateAnimation(0,200,0,0);
        tranlateAnimation.setDuration(200);
        //设置动画执行完，保存动画的结束的状态
        tranlateAnimation.setFillAfter(true);
        iv.startAnimation(tranlateAnimation);*/


        //位置移动
        // ObjectAnimator.ofFloat(iv,"translationX",0F,200F).setDuration(200).start();
        //旋转
        //ObjectAnimator.ofFloat(iv,"rotation",0F,180F).setDuration(200).start();
        //使用PropertyValueHolder效果，使动画叠加
        /*PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX",0F,200F);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY",0F,200F);
        ObjectAnimator.ofPropertyValuesHolder(iv,p1,p2).setDuration(200).start();*/
        //使用AnimatorSet实现动画叠加
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv,"translationX",0F,200F);
        ObjectAnimator oa2  =ObjectAnimator.ofFloat(iv,"rotation",0F,180F);
        ObjectAnimator oa3  =ObjectAnimator.ofFloat(iv,"alpha",0F,1F);
        AnimatorSet as = new AnimatorSet();
        //叠加播放
        // as.playTogether(oa1,oa2);
         //顺序播放
        //as.playSequentially(oa1,oa2);
        //精细控制顺序
        //as.play(oa2).with(oa1);
        //as.play(oa2).before(oa1);
        //as.play(oa2).after(oa1);
        //as.play(oa1).after(oa2);
        as.play(oa3).after(oa1);



        as.setDuration(200).start();





    }


}
