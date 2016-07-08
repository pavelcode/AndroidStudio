package com.cblue.image;

import android.provider.Settings;
import android.util.Log;

import com.cblue.image.cache.WebCache;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testA(){
      byte [] picbyte = ImageUtils.getBitmapFormUrl("http://img.ivsky.com/img/bizhi/pic/201602/28/jingmi_xiaoshiguang_xinqing-001.jpg");

       // ImageUtils.get(picbyte);
    }

    @Test
    public void testB(){
        String urlStr = "http://img.ivsky.com/img/bizhi/pic/201602/28/jingmi_xiaoshiguang_xinqing-001.jpg";
        String fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1);
        System.out.print(fileName);
      //  Log.i("aaa","fileName="+fileName);
    }

    @Test
    public void testC(){
        WebCache webCache = new WebCache();
        System.out.print("-----");
        webCache.saveFile("http://img11.360buyimg.com/da/jfs/t2839/47/2588927000/245649/5477cfc3/576bacc8N0c81ddeb.jpg");
    }

}