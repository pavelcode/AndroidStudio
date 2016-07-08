package com.cblue.image.cache2;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cblue.image.R;

/**
 * 三级缓存
 * 从网络下载图片进行优化
 *
 */
public class ImageOptimizeActivity02 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_optimize02);
    }
}


class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(Integer... params) {
        //从网络下载图片
         Bitmap  bitmap = null;
        //对图片进行压缩

        //保存在缓存中


        return bitmap;
    }
}