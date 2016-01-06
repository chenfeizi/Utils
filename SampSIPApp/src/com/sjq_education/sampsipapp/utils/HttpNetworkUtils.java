package com.sjq_education.sampsipapp.utils;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * 判断是否有可用网络
 * 
 * @author hongwei
 * 
 */
public class HttpNetworkUtils {

	/**
	 * 判断是否有网络连接
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * 判断是否连接上网络
	 * 
	 * @param act
	 * @return
	 */
	public static boolean detect(Activity act) {

		// No network connection found
		ConnectivityManager manager = (ConnectivityManager) act
				.getApplicationContext().getSystemService(
						Context.CONNECTIVITY_SERVICE);

		if (manager == null) {
			return false;
		}

		NetworkInfo networkinfo = manager.getActiveNetworkInfo();

		if (networkinfo == null || !networkinfo.isAvailable()) {
			return false;
		}

		return true;
	}

	/**
	 * 检查当前的网络连接
	 * 
	 * @param context
	 *            上下文
	 * @return ture代表有网络 false代表没网络
	 */
	public static boolean isNectivity(Context context) {
		// 获取网络连接管理服务
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isAvailable()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return 是否有活动的网络连接
	 */
	public final boolean hasNetWorkConnection(Context context) {
		// 获取连接活动管理器
		final ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 获取链接网络信息
		final NetworkInfo networkInfo = connectivityManager
				.getActiveNetworkInfo();

		return (networkInfo != null && networkInfo.isAvailable());

	}

	/**
	 * @return 返回boolean ,是否为wifi网络
	 * 
	 */
	public final boolean hasWifiConnection(Context context) {
		final ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo networkInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		// 是否有网络并且已经连接
		return (networkInfo != null && networkInfo.isConnectedOrConnecting());

	}

	/**
	 * @return 返回boolean,判断网络是否可用,是否为移动网络
	 * 
	 */

	public final boolean hasGPRSConnection(Context context) {
		// 获取活动连接管理器
		final ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo networkInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		return (networkInfo != null && networkInfo.isAvailable());

	}

	/**
	 * 网络是否可用
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager mgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] info = mgr.getAllNetworkInfo();
		if (info != null) {
			for (int i = 0; i < info.length; i++) {
				if (info[i].getState() == NetworkInfo.State.CONNECTED) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return 
	 *         判断网络是否可用，并返回网络类型，ConnectivityManager.TYPE_WIFI，ConnectivityManager
	 *         .TYPE_MOBILE，不可用返回-1
	 */
	public static final int getNetWorkConnectionType(Context context) {
		final ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo wifiNetworkInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		final NetworkInfo mobileNetworkInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if (wifiNetworkInfo != null && wifiNetworkInfo.isAvailable()) {
			return ConnectivityManager.TYPE_WIFI;
		} else if (mobileNetworkInfo != null && mobileNetworkInfo.isAvailable()) {
			return ConnectivityManager.TYPE_MOBILE;
		} else {
			return -1;
		}
	}

	/**
	 * 判断当前是否打开GPS
	 * 
	 * @param context
	 *            上下文
	 * @return false 表示没有打开 true 表示已经打开
	 */
	public static final boolean isOPenGPS(final Context context) {
		LocationManager locationManager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		boolean gps = locationManager
				.isProviderEnabled(LocationManager.GPS_PROVIDER);
		boolean network = locationManager
				.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		if (gps || network) {
			return true;
		}

		return false;
	}

	/**
	 * 判断手机是否有SIM卡
	 * @param context	上下文
	 * @return	false 表示没有  true 表示有
	 */
	public static boolean checkPhoneNet(Context context) {

		TelephonyManager mTelephonyManager = (TelephonyManager) context
				.getSystemService(Service.TELEPHONY_SERVICE);
		if (mTelephonyManager.getSimState() != TelephonyManager.SIM_STATE_READY) // SIM卡没有就绪
		{
			return false;
		} else {
//			ConnectivityManager cManager = (ConnectivityManager) context
//					.getSystemService(Context.CONNECTIVITY_SERVICE);
//			NetworkInfo info = cManager.getActiveNetworkInfo();
//			if (info != null && info.isAvailable()) {
//				// 能联网
//				return true;
//			} else {
//				// do something
//				// 不能联网
//				return false;
//			}
			return true;
		}
	}

}
