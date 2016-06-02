package com.cblue.hardware.camera.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cblue.hardware.R;
import com.google.zxing.client.android.CaptureActivity;

public class ZXingActivity02 extends AppCompatActivity {


    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxing_activity02);
        btn = (Button)findViewById(R.id.scan_btn);
        tv = (TextView)findViewById(R.id.result_tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCameraIntent = new Intent(ZXingActivity02.this,CaptureActivity.class);
                startActivityForResult(openCameraIntent, 0);
            }
        });
      }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("aaa","--"+111);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("SCAN_RESULT");
            Log.i("aaa","--"+scanResult);
            tv.setText(scanResult);
        }
    }
}
