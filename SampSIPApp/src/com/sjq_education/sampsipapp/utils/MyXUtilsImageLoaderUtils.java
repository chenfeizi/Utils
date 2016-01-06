package com.sjq_education.sampsipapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;

/**
 * 加载图片工具类
 * 
 * @author hongwei
 * 
 */
@SuppressLint("SdCardPath")
public class MyXUtilsImageLoaderUtils {

	private static Context mContext;
	private BitmapUtils bitmapUtils;

	public MyXUtilsImageLoaderUtils(Context context) {
		mContext = context;
		thePath();
	}

	/**
	 * @param context
	 *            上下文
	 * @param b
	 *            圆形图片
	 * 
	 */
	public MyXUtilsImageLoaderUtils(Context context, boolean b) {
		mContext = context;
		thePath();
	}


	/**
	 * 缓存路径
	 */
	public void thePath() {
		String dir = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/" + "XJPT" + "/";
		if (!Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			dir = "/data/data/" + mContext.getPackageName() + "/" + "XJPT"
					+ "/";
		}
		bitmapUtils = new BitmapUtils(mContext, dir);
		bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);// 设置图片压缩类型
	}

	/**
	 * 清除缓存
	 */
	public void clearCache() {
		bitmapUtils.clearCache();
	}

	/**
	 * 设置非圆形图片
	 * 
	 * @author hongwei
	 * 
	 */
	public class CustomBitmapLoadCallBack extends
			DefaultBitmapLoadCallBack<ImageView> {

		@Override
		public void onLoadCompleted(ImageView container, String uri,
				Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
			super.onLoadCompleted(container, uri, bitmap, config, from);
			
			if(bitmapListener != null){
				bitmap = bitmapListener.onClick(bitmap);
			}
			container.setImageBitmap(bitmap);
		}

		@Override
		public void onLoadFailed(ImageView container, String uri,
				Drawable drawable) {
			super.onLoadFailed(container, uri, drawable);
		}
	}
	

	/**
	 * 实现方法
	 * 
	 * @param container
	 *            控件
	 * @param url
	 *            图片地址
	 */
	public void display(ImageView container, String url) {
			bitmapUtils.display(container, url, new CustomBitmapLoadCallBack());
	}
	
	
	private BitmapListener bitmapListener;
	
	public void setBitmapListener(BitmapListener bitmapListener) {
		this.bitmapListener = bitmapListener;
	}
	/**
	 * 根据屏幕分辨率来控制图片大小
	 */
	public interface BitmapListener{
		Bitmap onClick(Bitmap bitmap);
	} 
}





