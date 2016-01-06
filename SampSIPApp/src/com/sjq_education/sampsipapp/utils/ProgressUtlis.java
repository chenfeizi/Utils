package com.sjq_education.sampsipapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.WindowManager;

import com.sjq_education.sampsipapp.R;

/**
 * 加载动画
 * 
 * @author chenhongwei
 * 
 */
public class ProgressUtlis {

	/**
	 * 自定义提示框(退出程序)
	 */
	public static void Popup(final Activity context) {
		final Dialog dialog = new Dialog(context, R.style.MyDialogTheme);
		dialog.setContentView(R.layout.load_progress);
		dialog.show();
		fullScreen(context, dialog);
	}

	/**
	 * 设置全屏
	 * 
	 * @param context
	 *            上下文
	 * @param dialog
	 */
	@SuppressWarnings("deprecation")
	public static void fullScreen(final Activity activity, final Dialog dialog) {
		WindowManager windowManager = activity.getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.width = (int) (display.getWidth()); // 设置宽度
		dialog.getWindow().setAttributes(lp);
	}

}
