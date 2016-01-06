package com.sjq_education.sampsipapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * SQLite 数据库访问的工具类
 * 
 * @author chenhongwei
 * 
 */
public class DBUtil {

	/**
	 * DataBaseHelper 帮助类
	 */
	private static DataBaseHelper dbHelper;

	/**
	 * SQLiteDatabase 数据库
	 */
	public static SQLiteDatabase db;

	/**
	 * DBUtil 当前上下文
	 * @param context
	 */
	public DBUtil(Context context) {
		dbHelper = new DataBaseHelper(context);
		db = dbHelper.getWritableDatabase();
	}

	/**
	 * 关闭数据库连接
	 */
	public static void CloseDB() {

		db.close();
		dbHelper.close();
	}

/*	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "NAME";
	public static final String COLUMN_PASS = "PASS";
	public static final String COLUMN_AGE = "AGE";
	public static final String COLUMN_CLASSNAME = "CLASSNAME";
	public static final String COLUMN_TEL = "TEL";
	public static final String COLUMN_EMAIL = "EMAIL";
	public static final String COLUMN_DATETIME = "DATETIME";*/

}
