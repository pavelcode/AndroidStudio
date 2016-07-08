package com.cblue.image.cache2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 从网络上下载图片
 * Created by pavel on 16/5/23.
 */
public class ImageUtils {



    public static byte[] getBitmapFormUrl(String url) {
        Bitmap bitmap = null;
        HttpURLConnection con = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {

            URL mImageUrl = new URL(url);
            con = (HttpURLConnection) mImageUrl.openConnection();
            con.setConnectTimeout(10 * 1000);
            con.setReadTimeout(10 * 1000);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            Log.i("aaa","code"+con.getResponseCode());
            InputStream inputStream = con.getInputStream();
            byte [] b = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();
            int length = 0;
            while((length=inputStream.read(b))!=-1){
                byteArrayOutputStream.write(b,0,length);
            }
           return byteArrayOutputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return null;
    }


        //读取SDcard文件
        public byte[] readSDCardFile(String fileName) throws Exception {
            // 判断SD卡的状态
            String state = Environment.getExternalStorageState();
            FileInputStream mFileInputStream;
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                // 得到当前目录的根路径
                File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                Log.i("aaa", "根路径" + root.getAbsolutePath());
                File file = new File(root, fileName);
                if (file.exists()) {
                    ByteArrayOutputStream mByteArrayOutputStream = new ByteArrayOutputStream();
                    mFileInputStream = new FileInputStream(file);
                    byte[] b = new byte[1024];
                    int length = 0;
                    while ((length = mFileInputStream.read(b)) != -1) {
                        mByteArrayOutputStream.write(b, 0, length);
                    }
				/*if (mByteArrayOutputStream != null) {
					mByteArrayOutputStream.close();
				}*/
                    if (mFileInputStream != null) {
                        mFileInputStream.close();
                    }
                    return mByteArrayOutputStream.toByteArray();
                }

            }
            return null;
        }





}
