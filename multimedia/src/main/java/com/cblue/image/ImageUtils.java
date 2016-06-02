package com.cblue.image;

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
 * 从SD卡读取图片文件，
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
                File root = Environment.getExternalStorageDirectory();
                //
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

    /**
     * 根据图片字节数组，对图片可能进行二次采样，不致于加载过大图片出现内存溢出
     * @param bytes
     * @return
     */
    public static Bitmap getBitmapByBytes(byte[] bytes,int picWidth,int picHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();
        //如果指定了inJustDecodeBounds=true，decodeByteArray将返回为空，通过这种方式获得图片的宽高，而不加载图片
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);

        System.out.println("采集前的图片的大小："+bytes.length);

        //对于图片的二次采样,主要得到图片的宽与高
        int width = 0;
        int height = 0;
        height = options.outHeight;
        width = options.outWidth;
        System.out.println("图片的宽高为"+width+":"+height);

        //根据需要的图片的宽高计算缩放比例
        options.inSampleSize = calculateInSampleSize(options,picWidth,picHeight);
        //options.inSampleSize =0.8;
        System.out.println("options.inSampleSize："+options.inSampleSize);

        //当得到图片的比率的时候，inJustDecodeBounds=false，这时候decodeByteArray方法会获得二次采集后的图片
        options.inJustDecodeBounds = false;
        Bitmap resultBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);

        System.out.println("采集后的图片的大小："+bytes.length);

        return resultBitmap;
    }

    //计算缩放比率
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        System.out.println("图片的宽高为"+width+":"+height);
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }


    public static  void get(byte[] bytes){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 设置了此属性一定要记得将值设置为false
        Bitmap bitmap = null;
        Log.i("aaa","before"+bytes.length);
        bitmap =  BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        int be = (int) ((options.outHeight > options.outWidth ? options.outHeight / 150
                : options.outWidth / 200));
        if (be <= 0) // 判断200是否超过原始图片高度
            be = 1; // 如果超过，则不进行缩放
        options.inSampleSize = be;
        options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
            Log.i("aaa","after"+bytes.length);
        } catch (OutOfMemoryError e) {
            System.gc();
        }
    }



}
