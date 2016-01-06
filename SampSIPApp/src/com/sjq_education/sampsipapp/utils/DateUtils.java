package com.sjq_education.sampsipapp.utils;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @Author HONGWEI
 */
@SuppressLint("SimpleDateFormat")
public class DateUtils {
	
	/**
	 * 获取当前年月日时分秒
	 * @return
	 */
	public static String getData() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 获取当前年月日
	 * @return
	 */
	public static String getShortData() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
}