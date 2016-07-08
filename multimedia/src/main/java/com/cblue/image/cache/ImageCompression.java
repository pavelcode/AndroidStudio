package com.cblue.image.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.cblue.image.R;

/**
 * 对图片进行二次采集，获得缩略图
 * Created by pavel on 16/6/17.
 */
public class ImageCompression {


    private Context context;

    public ImageCompression(Context context){
        this.context = context;
    }

    /**
     * 根据图片字节数组，对图片可能进行二次采样，不致于加载过大图片出现内存溢出
     * @param
     * @return
     */
    public static Bitmap getBitmapByBytes(byte[] data,int picWidth, int picHeight){

        Bitmap initBitmap = BitmapFactory.decodeByteArray(data,0,data.length);
        Log.i("aaa","采集前图片的大小："+ initBitmap.getByteCount());

        BitmapFactory.Options options = new BitmapFactory.Options();
        //如果指定了inJustDecodeBounds=true，decodeResource将返回为空，通过这种方式获得图片的宽高，而不加载图片
        options.inJustDecodeBounds = true;
       //Bitmap beforeBitmap = BitmapFactory.decodeResource(context.getResources(),ResId,options);
        Bitmap beforeBitmap = BitmapFactory.decodeByteArray(data,0,data.length,options);
        //BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        //Log.i("aaa","原始图片的大小："+bytes.length);

        //对于图片的二次采样,主要得到图片的宽与高
        int width = 0;
        int height = 0;
        height = options.outHeight;
        width = options.outWidth;
        Log.i("aaa","原始图片的宽高："+width+":"+height);

        //根据需要的图片的宽高计算缩放比例
        options.inSampleSize = calculateInSampleSize(options,picWidth,picHeight);
        //options.inSampleSize =0.8;
        Log.i("aaa","缩放："+options.inSampleSize);

        //当得到图片的比率的时候，inJustDecodeBounds=false，这时候decodeByteArray方法会获得二次采集后的图片
        options.inJustDecodeBounds = false;
       // Bitmap resultBitmap = BitmapFactory.decodeResource(context.getResources(),ResId,options);

        Bitmap resultBitmap = BitmapFactory.decodeByteArray(data,0,data.length,options);
        Log.i("aaa","采集后图片的宽高："+resultBitmap.getWidth()+":"+resultBitmap.getHeight());
        Log.i("aaa","采集后图片的大小："+resultBitmap.getByteCount());

        return resultBitmap;
    }


    //计算缩略比率
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        System.out.println("图片的宽高为"+width+":"+height);
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

}
