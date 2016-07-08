package com.cblue.image.cache;

import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Web缓存（从网络下载图片）
 * 使用接口回调
 * Created by pavel on 16/6/26.
 */
public class WebCache {



    public interface  CallBack{
        public void getResult(byte[] data);
    }

    public void downPic(final String urlStr, final CallBack callBack){

       new Thread(new Runnable() {
           @Override
           public void run() {

              byte[] data =  downloadFile(urlStr);
              Log.i("aaa","data="+data.length);
               callBack.getResult(data);
           }
       }).start();
    }




    public byte[] downloadFile(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           // conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.print("code="+responseCode);
            Log.i("aaa","code="+responseCode);
            if (responseCode == 200) {
                InputStream inStream = conn.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int len = -1;
                byte[] buffer = new byte[10];
                while ((len = inStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                byte[] data = outputStream.toByteArray();
                if (inStream != null) {
                    inStream.close();
                }
                return data;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
