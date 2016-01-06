package com.sjq_education.sampsipapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sjq_education.sampsipapp.R;

/**
 * 
 * Toast 工具，关闭页面时调用方法取消
 * 
 * @author hongwei
 *
 */
@SuppressLint({ "ShowToast", "InflateParams" })
public class MyToast {
	private static Toast mToast;
	  
	/***
	 * 显示Toast的方法 
	 * @param context：上下文对象
	 * @param message：Toast显示的提示内容文本
	 */
	@SuppressLint("InflateParams")
	public static void showShortToast(Context context, String message) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.custom_toast, null);// 自定义布局
		TextView text = (TextView) view.findViewById(R.id.toast_message);// 显示的提示文字
		text.setText(message);
		
		// 只有mToast==null时才重新创建，否则只需更改提示文字
		if (mToast == null) {
			mToast = new Toast(context);
			mToast.setDuration(Toast.LENGTH_SHORT);
			mToast.setGravity(Gravity.CENTER, 0, 0);
			mToast.setView(view);
		} else {
			mToast.setView(view);			
		}
		
		mToast.show();

	}
	
	/***
	 * 关闭Toast的方法
	 */
	public static void close (){
		if (mToast != null) {
			mToast.cancel();
			mToast = null;
		}
	}
}
