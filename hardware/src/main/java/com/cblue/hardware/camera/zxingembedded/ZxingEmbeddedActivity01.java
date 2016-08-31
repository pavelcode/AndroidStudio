package com.cblue.hardware.camera.zxingembedded;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cblue.hardware.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.Hashtable;


/**
 * 添加
 *   compile 'com.journeyapps:zxing-android-embedded:3.2.0@aar'
     compile group: 'com.google.zxing', name: 'core', version: '3.2.1'
 */
public class ZxingEmbeddedActivity01 extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2;
    EditText et;
    ImageView img;
    TextView tv;
    String str = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxingembedded_activity01);
        btn1 = (Button)findViewById(R.id.zxing_embedded_createQRBtn);
        btn2 = (Button)findViewById(R.id.zxing_embedded_scanQRBtn);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        et = (EditText)findViewById(R.id.zxing_embedded_content);
        img = (ImageView)findViewById(R.id.zxing_embedded_image);
        tv =(TextView)findViewById(R.id.zxing_embedded_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zxing_embedded_createQRBtn:
                //创建二维码
                str = et.getText().toString();
                if(str != null){
                   Bitmap bitmap = createQRCode(str);
                   img.setImageBitmap(bitmap);
                }
                break;
            case R.id.zxing_embedded_scanQRBtn:
                //扫描二维码  Integrator积分器
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setPrompt("请扫描"); //底部的提示文字，设为""可以置空  Prompt提示
                integrator.setCameraId(0); //前置或者后置摄像头 0后置  1前置
                // integrator.setBeepEnabled(false); //扫描成功的「哔哔」声，默认开启
                integrator.initiateScan();
                break;
        }

    }


    private Bitmap createQRCode(String qrCodeString){
        Bitmap bmp = null;    //二维码图片
        QRCodeWriter writer = new QRCodeWriter();
        try {
            //设置编码方式，否则出现乱码
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix bitMatrix = writer.encode(qrCodeString, BarcodeFormat.QR_CODE, 512, 512,hints); //参数分别表示为: 条码文本内容，条码格式，宽，高
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            //绘制每个像素
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // bitMatrix.get 判断x，y坐标点是否是矩阵中的值
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }

        } catch (WriterException e) {
            e.printStackTrace();
        }

        return bmp;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("aaa", "Cancelled");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("aaa", "Scanned: " + result.getContents());
                tv.setText(result.getContents());
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        }
    }


}
