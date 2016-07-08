package com.cblue.image.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by pavel on 16/6/26.
 */
public class CacheManager {


    private FileCache fileCache = new FileCache();

    private MomeryCache momeryCache = new MomeryCache();

    private WebCache webCache = new WebCache();

    Handler handler = new Handler();


    public void getCache(final String urlStr,final ImageView imageView) {
        Bitmap bitmap = null;
        Log.i("aaa","momeryCache.getBitmapFromLruCache(urlStr) "+momeryCache.getBitmapFromLruCache(urlStr) );
        if (momeryCache.getBitmapFromLruCache(urlStr) != null) {
            Log.i("aaa","111");
            bitmap =  momeryCache.getBitmapFromLruCache(urlStr);
            imageView.setImageBitmap(bitmap);
        }else if (fileCache.getImageFromSDcard(urlStr) != null) {
                Log.i("aaa","222");
                bitmap = fileCache.getImageFromSDcard(urlStr);
                momeryCache.addBitmapToLruCache(urlStr, bitmap);
                imageView.setImageBitmap(bitmap);
        } else {
                Log.i("aaa","333");
                webCache.downPic(urlStr, new WebCache.CallBack() {
                    @Override
                    public void getResult(byte[] data) {
                      // final Bitmap  webBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        //压缩后的图片
                        final  Bitmap webBitmap = ImageCompression.getBitmapByBytes(data,50,50);
                        //把压缩后的bitmap转化byte数组
                        byte[] d =  Bitmap2Bytes(webBitmap);
                        //TODO 这是实现图片压缩
                        fileCache.saveImageToSDcard(d, urlStr);
                        momeryCache.addBitmapToLruCache(urlStr,webBitmap);
                        //出现Only the original thread that created a view hierarchy can touch its views
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.i("aaa","run----");
                               imageView.setImageBitmap(webBitmap);
                            }
                        });

                    }
                });
            }
        }


    //把bitmap对象转化为byte[]
    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    }




