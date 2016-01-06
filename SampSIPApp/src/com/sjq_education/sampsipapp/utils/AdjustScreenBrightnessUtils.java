package com.sjq_education.sampsipapp.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.view.Window;
import android.view.WindowManager;

/**
 * 调节屏幕亮度
 * 
 * @author hongwei
 * 
 */
public class AdjustScreenBrightnessUtils {
	/**
	 * 保存亮度
	 * 
	 * @param progress
	 *            亮度值（0-255）
	 * @param activity
	 *            当前activity
	 */
	public static void setScreenLight(int progress, Activity activity) {
		if (progress < 1) {
			progress = 1;
		} else if (progress > 255) {
			progress = 255;
		}
		final WindowManager.LayoutParams attrs = activity.getWindow()
				.getAttributes();
		attrs.screenBrightness = progress / 255f;
		activity.getWindow().setAttributes(attrs);
	}

	/**
	 * 根据亮度值修改当前window亮度
	 * 
	 * @param context	
	 * @param brightness
	 */
	public static void changeAppBrightness(Context context, int brightness) {
		Window window = ((Activity) context).getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		if (brightness == -1) {
			lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
		} else {
			lp.screenBrightness = (brightness <= 0 ? 1 : brightness) / 255f;
		}
		window.setAttributes(lp);
	}

	/**
	 * 获取当前系统屏幕亮度
	 * 
	 * @param activity
	 *            当前activity
	 * @return 返回系统屏幕亮度值
	 */
	public static int getScreenBrightness(Activity activity) {
		int value = 0;
		ContentResolver cr = activity.getContentResolver();
		try {
			value = Settings.System.getInt(cr,
					Settings.System.SCREEN_BRIGHTNESS);
		} catch (SettingNotFoundException e) {

		}
		return value;
	}
}
