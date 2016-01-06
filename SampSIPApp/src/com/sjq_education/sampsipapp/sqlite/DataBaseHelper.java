package com.sjq_education.sampsipapp.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 控制数据库版本
 * 
 * @author chenhongwei
 *
 */
public class DataBaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "sjq_zyzfw.db";		//数据库名
	private static final int DATABASE_VERSION = 16;				//数据库版本
		
		
	/**
	 * 在SQLiteOpenHelper的子类当中，必须有该构造函数
	 * 
	 * @param context
	 *            上下文对象
	 * @param name
	 *            数据库名称
	 * @param factory
	 * @param version
	 *            当前数据库的版本，值必须是整数并且是递增的状态
	 */
	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	public DataBaseHelper(Context context,String name,int version){
		this(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public DataBaseHelper(Context context,String name){
		this(context, DATABASE_NAME,DATABASE_VERSION);
	}
	
	public DataBaseHelper(Context context){
		this(context, DATABASE_NAME,DATABASE_VERSION);
	}

	
	
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		//创建登录表
//		db.execSQL("CREATE TABLE IF NOT EXISTS "+ Login.TABLE_NAME +" (" + Login.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
//				+ Login.COLUMN_NAME + " TEXT," + Login.COLUMN_PASS + " TEXT," 
//				+ Login.COLUMN_PHONE + " TEXT," + Login.COLUMN_HEADADDRESS + " TEXT," 
//				+ Login.COLUMN_USERTYPE + " TEXT," + Login.COLUMN_ISCAPTAIN + " TEXT," 
//				+ Login.COLUMN_ROLETYPE + " TEXT," + Login.COLUMN_REALNAME + " TEXT,"+ Login.COLUMN_ISMANAGE + " TEXT," 
//				+ Login.COLUMN_USERID+" TEXT)");
		
		
//		ContentValues values = new ContentValues();
		
//初始化数据库
//		values.put(VersionNumber.COLUMN_TABLENAME, "ServiceType");
//		values.put(VersionNumber.COLUMN_VERSION, 1);
//		values.put(VersionNumber.COLUMN_TYPE, 3);
//		
//		db.insert(VersionNumber.TABLE_NAME, null, values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 删除原来的表
//		db.execSQL("drop table if exists "+PersonalDetails.TABLE_NAME);
		onCreate(db);
	}

}
