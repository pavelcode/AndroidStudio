package com.cblue.hardware.camera.zxing;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.cblue.hardware.R;

import java.io.File;

/**
 * 二维码生成，保存文件，带logo
 *   compile group: 'com.google.zxing', name: 'core', version: '3.2.1'
 * Created by pavel on 16/5/30.
 */
public class ZXingActivity01 extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxing_activity01);


        //生成二维码的内容
        final EditText contentET = (EditText) findViewById(R.id.content);
        //生成的二维码图片
        final ImageView imageView = (ImageView) findViewById(R.id.image);
        //是否添加Logo
        final CheckBox addLogoCB = (CheckBox) findViewById(R.id.create_logo);

        Button createQrBtn = (Button) findViewById(R.id.createQRBtn);


        createQrBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //生成的二维码图片保存的路径
                final String filePath = getFileRoot(ZXingActivity01.this) + File.separator
                        + "qr_" + System.currentTimeMillis() + ".jpg";

                //二维码图片较大时，生成图片、保存文件的时间可能较长，因此放在新线程中
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        boolean success = QRCodeUtil.createQRImage(contentET.getText().toString().trim(), 800, 800,
                                addLogoCB.isChecked() ? BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher) : null,
                                filePath);

                        if (success) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageBitmap(BitmapFactory.decodeFile(filePath));
                                }
                            });
                        }
                    }
                }).start();

            }
        });


    }

    //文件存储根目录
    private String getFileRoot(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            File external = context.getExternalFilesDir(null);
            if (external != null) {
                return external.getAbsolutePath();
            }
        }
        return context.getFilesDir().getAbsolutePath();
    }


}
