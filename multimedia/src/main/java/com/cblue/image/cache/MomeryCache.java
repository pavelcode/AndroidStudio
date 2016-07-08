package com.cblue.image.cache;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * 内存缓存（使用LruCache）vai
 * Created by pavel on 16/6/17.
 */
public class MomeryCache {


    private static LruCache<String,Bitmap> lruCache;

    public MomeryCache(){

        //获取到可用内存的最大值，使用内存超出这个值会引起OutOfMemory异常。
        int maxMomery = (int)Runtime.getRuntime().maxMemory();

        //使用最大可用内存值的1/8作为缓存的大小
        int cacheSize = maxMomery/8;

        lruCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //计算出每张缓存图片的大小
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };

    }

   //从LruCache中获得缓存对象
    public synchronized   Bitmap getBitmapFromLruCache(String key){
          if(key!=null) {
              if(lruCache!=null) {
                  Log.i("aaa","getBitmapFromLruCache="+key);
                  return lruCache.get(key);
              }
          }
        return null;
    }
   //把图片对象加入到LruCache缓存中
    public synchronized void addBitmapToLruCache(String key,Bitmap bitmap){
        if(key!=null&&bitmap!=null) {
            if (getBitmapFromLruCache(key) == null) {
                Log.i("aaa","addBitmapToLruCache="+key);
                lruCache.put(key, bitmap);
            }
        }
    }

    /**
     * 清空缓存、添加图片到缓存、从缓存中取得图片、从缓存中移除。
     移除和清除缓存是必须要做的事，因为图片缓存处理不当就会报内存溢出，所以一定要引起注意。
     * @param key
     */

    public synchronized void removeBitmapFromLruCache(String key){
        if(key!=null){
            if(lruCache!=null){
               Bitmap bitmap =  lruCache.remove(key);
                if(bitmap!=null){
                    bitmap.recycle();
                }
            }
        }
    }

    public void clearAllLruCache(){
        if(lruCache!=null){
            if(lruCache.size()>0){
                lruCache.evictAll();
            }
            lruCache = null;
        }
    }

}
