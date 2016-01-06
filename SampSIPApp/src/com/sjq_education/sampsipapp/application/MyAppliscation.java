package com.sjq_education.sampsipapp.application;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.sjq_education.sampsipapp.R;

/**
 * 
 * @author chenhongwei
 * 
 */
@SuppressLint("SdCardPath")
@SuppressWarnings("deprecation")
public class MyAppliscation extends Application {


	@Override
	public void onCreate() {
		super.onCreate();
		setImage();

	}

	private DisplayImageOptions options;

	/**
	 * 初始化加载图片工具
	 */
	public void setImage() {
		// 配置图片缓存路径
		String dir = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/" + "XJPT" + "/";
		if (!Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			dir = "/data/data/" + getApplicationContext().getPackageName()
					+ "/" + "XJPT" + "/";
		}
		File cacheDir = new File(dir);
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.default_avatars)
				.showImageForEmptyUri(R.drawable.default_avatars)
				.showImageOnFail(R.drawable.default_avatars)
				.cacheInMemory(true).cacheOnDisc(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.resetViewBeforeLoading(true)
//				.displayer(new RoundedBitmapDisplayer(90))//设置圆角图片
				.build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.memoryCacheExtraOptions(360, 640)
				.threadPoolSize(3)
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new WeakMemoryCache())
				.memoryCacheSize(2 * 1024 * 1024)
				// .discCacheFileNameGenerator(new
				// Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.diskCacheFileCount(100)
				.diskCacheSize(50 * 1024 * 1024)
				.discCache(new UnlimitedDiscCache(cacheDir))
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				.imageDownloader(
						new BaseImageDownloader(getApplicationContext(),
								5 * 1000, 30 * 1000))
				.defaultDisplayImageOptions(options).writeDebugLogs().build();// 开始构建
		// 配置图片读取
		ImageLoader.getInstance().init(config);

	}

}
