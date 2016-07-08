package com.cblue.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;


/**
 * 使用Service从内部储存到SD卡copy文件
 */
public class StartServiceActivity07 extends AppCompatActivity {


    private Button btn1;
    private Button btn2;
    private static final String fileName="doctormagazine.xmind";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice_activity07);
        btn1 = (Button)findViewById(R.id.startserviceactivity07_btn01);
        btn2 = (Button)findViewById(R.id.startserviceactivity07_btn02);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(StartServiceActivity07.this,StartService07.class);
                intent.putExtra("fileName", fileName);
                startService(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    writeInternalFile("aaa.txt", "data".getBytes());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
    public boolean writeInternalFile(String fileName, byte[] data)
            throws Exception {
        boolean flag = false;
        FileOutputStream mFileOutputStream = null;
        mFileOutputStream = openFileOutput(fileName,
                Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
        mFileOutputStream.write(data, 0, data.length);
        flag = true;
        if (mFileOutputStream != null) {
            mFileOutputStream.close();

        }
        return flag;
    }
}
