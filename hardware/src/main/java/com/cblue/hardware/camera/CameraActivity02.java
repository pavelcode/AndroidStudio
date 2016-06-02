package com.cblue.hardware.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.hardware.R;

/**
 * Created by pavel on 16/5/30.
 * 图片大小问题，导致图片会显示不出来，设置了剪裁之后，就没有问题
 * 打开图片库，选中图片，显示出来
 * @author Administrator
 *
 */

public class CameraActivity02 extends AppCompatActivity {

    ImageView camareIV;
    Button camareBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        camareIV = (ImageView)findViewById(R.id.camera_iv);
        camareBtn = (Button)findViewById(R.id.camera_btn);
        camareBtn.setText("打开图片库");


        camareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                // 设置裁剪模式
                intent.putExtra("crop", "true");  //TODO  这里是字符串，不是布尔值
                // aspectX aspectY 剪裁的宽高比例 1:1
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                // outputX outputY 是裁剪图片宽高
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 200);
                intent.putExtra("return-data", true);

                startActivityForResult(intent, 100);

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("aaa",data.toString());
        if(requestCode==100&&resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Log.i("aaa",extras.toString());
            Bitmap photo = extras.getParcelable("data");
            camareIV.setImageBitmap(photo);
        }
    }

}
