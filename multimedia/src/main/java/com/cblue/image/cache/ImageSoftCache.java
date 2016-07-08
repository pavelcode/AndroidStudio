package com.cblue.image.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.graphics.Bitmap;

/**
 * 软引用保存缓存
 */
public class ImageSoftCache {

	
	private HashMap<String, SoftReference<Bitmap>> map;

	public ImageSoftCache() {

		map = new HashMap<String, SoftReference<Bitmap>>();
	}
	
	/**
	 * 根据name找到软引用指向的对象
	 * @param name
	 * @return
	 */
	public Bitmap getCacheBitmapByKey(String name){
		Bitmap bitmap = null;
		SoftReference<Bitmap> softRef = map.get(name);
		if(softRef != null){
			bitmap = softRef.get();
			if(bitmap == null){
				map.remove(name);
			}
		}
		return bitmap;
	}
	/**
	 * 将制定的name-bitmap键值对添加至集合中
	 * @param name
	 * @param bitmap
	 */
	public synchronized boolean addCacheBitmap(String name, Bitmap bitmap){
		SoftReference<Bitmap> softRef = new SoftReference<Bitmap>(bitmap);
		map.put(name, softRef);
		return true;
	}
	

	public void clear() {
	   map.clear();
	}

	public void remove(String key) {
		map.remove(key);
	}
}