package com.cblue.image.cache;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.image.R;

/**
 * 对本地图片进行优化
 * 显示原图片
 * 显示二次采样后的压缩图片
 * 显示从缓存中获得的图片
 * Created by pavel on 16/6/17.
 */
public class ImageOptimizeActivity01 extends AppCompatActivity{

    ImageView iv1,iv2,iv3;
    Button btn;

    CacheManager cacheManager;
    MomeryCache momeryCache;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_optimize01);
        iv1 = (ImageView)findViewById(R.id.image_optimize_iv01);
        iv2 = (ImageView)findViewById(R.id.image_optimize_iv02);
        btn = (Button)findViewById(R.id.image_optimize_btn01);

        //原始图片显示
        //iv1.setImageResource(R.drawable.baidu);

        //把图片压缩显示
       final ImageCompression  imageCompression = new ImageCompression(getApplicationContext());
        WebCache webCache = new WebCache();
        webCache.downPic("http://img13.360buyimg.com/vclist/jfs/t2716/280/2664674095/10910/db53efc9/576fecb4N30bf9438.jpg", new WebCache.CallBack() {
            @Override
            public void getResult(byte[] data) {
                Bitmap bitmap = imageCompression.getBitmapByBytes(data,20,20);
                iv1.setImageBitmap(bitmap);
            }
        });



        //把图片添加缓存，从缓存中取出显示
        //MomeryCache imageCache = new MomeryCache();
        //imageCache.addBitmapToLruCache("baidu",bitmap);
         //iv1.setImageBitmap(imageCache.getBitmapFromLruCache("baidu"));

        //通过三级缓存得到图片
       // cacheManager = new CacheManager();
       // cacheManager.getCache("http://img13.360buyimg.com/vclist/jfs/t2716/280/2664674095/10910/db53efc9/576fecb4N30bf9438.jpg",iv1);



        //加载Lru缓存中的图片
        momeryCache = new MomeryCache();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Bitmap  bitmap =  momeryCache.getBitmapFromLruCache("http://img13.360buyimg.com/vclist/jfs/t2716/280/2664674095/10910/db53efc9/576fecb4N30bf9438.jpg");
                iv2.setImageBitmap(bitmap);
            }
        });



    }



}
