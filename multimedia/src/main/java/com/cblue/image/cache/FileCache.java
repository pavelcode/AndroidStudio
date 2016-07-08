package com.cblue.image.cache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.bumptech.glide.disklrucache.DiskLruCache;

/**
 * 文件缓存（把图片保存到SDCard中CACHE_FOLDERb）
 */
public class FileCache {

    //DiskLruCache


    //sdcard的绝对路径
    private final static File SDCARD_FOLDER = Environment.getExternalStorageDirectory();
    //缓存目录名
    private String cache_folder = "sdcache";
    //缓存目录对象
    private File SDCARD_CACHE_FOLDER = null;
    //判断sdcard是否加载成功
    private Boolean mount_sdcard;

    /**
     * 静态方法，得到SDCardCacheManager实例化对象
     *
     * @return
     */
    public FileCache() {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            mount_sdcard = false;
            Log.e("aaa", "SDCard不存在或者尚未申请sdcard读写权限!");//error
        } else {
            mount_sdcard = true;
            SDCARD_CACHE_FOLDER = new File(SDCARD_CACHE_FOLDER, cache_folder);
            if (!SDCARD_CACHE_FOLDER.exists()) {
                SDCARD_CACHE_FOLDER.mkdirs();
            }

        }
    }


    /**
     * 保存图片到SD卡中
     *
     * @param data
     * @param
     * @return 保存图片的路径
     */
    public synchronized void saveImageToSDcard(byte[] data, String urlStr) {
        if (mount_sdcard) {
            if (!SDCARD_CACHE_FOLDER.exists()) {
                return;
            }
            FileOutputStream fos = null;
            File file = null;
            try {
                //获得文件名字
                String fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1);
                // 创建写入文件对象
                file = new File(SDCARD_CACHE_FOLDER, fileName);
                fos = new FileOutputStream(file);
                fos.write(data, 0, data.length);
                Log.i("aaa","saveImageToSDcard="+file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                        fos = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 从SD卡中读取图片路径
     *
     * @param urlStr 图片的全路径
     * @return
     */
    public Bitmap getImageFromSDcard(String urlStr) {

        if(mount_sdcard) {
            Bitmap bitmap = null;
            //获得文件名字
           String fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1);
            if (fileName != null) {
                File file = new File(SDCARD_CACHE_FOLDER,fileName);
                if (file.exists()) {
                    bitmap = BitmapFactory.decodeFile(SDCARD_CACHE_FOLDER+File.separator+fileName);
                    return bitmap;
                }
            }
        }
        return null;
    }


    public boolean remove(String fileName) {
        if(mount_sdcard) {
            if (fileName != null) {
                File file = new File(SDCARD_CACHE_FOLDER,fileName);
                if (file.exists()) {
                    return file.delete();
                }
            }
        }
        return false;
    }

    public void clear() {
        if(mount_sdcard){
            File[] files = SDCARD_CACHE_FOLDER.listFiles();
            for(File file:files){
                file.delete();
            }
        }
    }


}
