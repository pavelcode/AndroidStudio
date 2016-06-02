package com.cblue.hardware.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.hardware.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * 调用相机，得到拍摄的图片，显示在ImageView中
 * 第一种方式：拍照之后，得到数据流
 * @author Administrator
 *
 */
public class CameraActivity01 extends AppCompatActivity  {

    ImageView  camareIV;
    Button camareBtn;
    File saveFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        camareIV = (ImageView)findViewById(R.id.camera_iv);
        camareBtn = (Button)findViewById(R.id.camera_btn);


        camareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用系统相机
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100&&resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");
            //保存图片到SD卡上
            String savePicPath = savePicToSdcard(bitmap, Environment.getExternalStorageDirectory().getAbsolutePath(),"a.jpg");
            Log.i("aaa","savePicPath="+savePicPath);
            camareIV.setImageBitmap(bitmap);

        }
    }

    //保存图片到SD卡上
    public static String savePicToSdcard(Bitmap bitmap, String path, String fileName) {
            String  filePath=path+ fileName;
            File destFile = new File(filePath);
            OutputStream os = null;
            try {
                os = new FileOutputStream(destFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
                os.flush();
                os.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        return filePath;
    }


}
