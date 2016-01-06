package com.sjq_education.sampsipapp.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * SQLite  增删改查帮助类 
 * 
 * @author chenhongwei
 *
 */
public class SQLiteHelper {

	/**
	 * 查询数据
	 * 
	 * @param TABLE 表名
	 * @param context
	 *            当前上下文
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Cursor QueryTableDate(String TABLE , Context context) {
		// 获取SQLite帮助类
		DBUtil dbHelper = new DBUtil(context);
		
		Cursor cursor = dbHelper.db.query(TABLE, null, null, null, null, null," _id asc");
		
		//注意：查询返回数据不能关闭db
		return cursor;
	}
	
	/**
	 * 查询单个数据
	 * 
	 * @param TABLE
	 *            表名
	 * @param context
	 *            上下文
	 * @param id
	 *            需要查询的id
	 * @return 返回单个数据
	 */
	public static Cursor QueryASingle(String TABLE, Context context, String id) {
		// 获取SQLite帮助类
//		DBUtil dbHelper = new DBUtil(context);

//		Cursor cursor = dbHelper.db.rawQuery("select * from "
//				+ VersionNumber.TABLE_NAME + "  where Type = " + id, null);

		// 注意：查询返回数据不能关闭db
//		return cursor;
		return null;
	}
	
	
	
	/**
	 * 更新
	 * 
	 * @param table
	 *            表名
	 * @param values
	 *            值
	 * @param whereClause
	 * @param whereArgs
	 */
	@SuppressWarnings("static-access")
	public static int Update(String TABLE, ContentValues values, String whereClause,
			String[] whereArgs, Context context) {
		// 获取SQLite帮助类
		DBUtil dbHelper = new DBUtil(context);
		// 更新数据
		int updateValue = dbHelper.db.update(TABLE, values, whereClause,
				whereArgs);
		// 关闭数据库
		DBUtil.CloseDB();
		return updateValue;// 返回影响的行数
	}
	
	/**
	 * 保存数据
	 * 
	 * @param values
	 *            值
	 * @param TABLE
	 *            表名
	 * @param context
	 *            当前上下文
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static int Save(ContentValues values, String TABLE, Context context) {

		// 获取SQLite帮助类
		DBUtil dbHelper = new DBUtil(context);
		// 插入数据
		Long id = dbHelper.db.insert(TABLE, null, values);
		// 关闭数据库
		DBUtil.CloseDB();
		return id.intValue();
	}

	/**
	 * 删除全部表的数据
	 * 
	 * @param TABLE
	 *            表
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static int Delete(String TABLE, Context context) {
		// 获取SQLite帮助类
		DBUtil dbHelper = new DBUtil(context);
		// 删除数据
		int deleteValue = dbHelper.db.delete(TABLE, "1", null);
		// 关闭数据库
		DBUtil.CloseDB();
		return deleteValue;// 返回影响的行数
	}

	

}
