package com.cblue.image.cache2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cblue.image.cache.ImageSoftCache;

import java.lang.ref.SoftReference;
import java.net.URL;

/**
 *
 * 步骤：（1）先通过URL查看缓存中是否有图片，如果有，则直接去缓存中取得。如果没有，就开线程重新去网上下载。
 *      （2）下载完了之后，就把图片放在缓存里面，方便下次可以直接从缓存中取得。
 * Created by pavel on 16/6/24.
 */
public class ImageCacheActivity01 extends AppCompatActivity{


    ImageSoftCache imageSoftCache;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageSoftCache = new ImageSoftCache();
    }

    public Bitmap loadBitmap(final String imageUrl, final ImageCallBack imageCallBack) {

        Bitmap bitmap = imageSoftCache.getCacheBitmapByKey(imageUrl);

        if(bitmap!=null){
             return bitmap;
        }

        final Handler handler = new Handler() {

            public void handleMessage(final android.os.Message msg) {

                //加入到缓存中

                Bitmap bitmap = (Bitmap)msg.obj;

                imageSoftCache.addCacheBitmap(imageUrl,bitmap);

                if(imageCallBack != null) {

                    imageCallBack.getBitmap(bitmap);

                }

            }

        };

        new Thread(){

            public void run() {

                Message message = handler.obtainMessage();

                message.obj = downloadBitmap(imageUrl);

                handler.sendMessage(message);

            }

        }.start();

        return null ;

    }



    // 从网上下载图片

    private Bitmap downloadBitmap (String imageUrl) {

        Bitmap bitmap = null;

        try {

            bitmap = BitmapFactory.decodeStream(new URL(imageUrl).openStream());

            return bitmap ;

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }


    public interface ImageCallBack{

        void getBitmap(Bitmap bitmap);

    }


}
