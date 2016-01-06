package com.sjq_education.sampsipapp.utils;

/**
 * 所以地址
 * @author chenhongwei
 *
 */
public class Constants {
	
	//定义是否使用正式服务器地址
	public static  boolean isUse = false;
	
    //正式服务器IP地址
    public static String FORMALSERVER = "http://183.6.175.42:9090";//公司外网服务器
	
	//测试服务器IP地址
	public static String CESHISERVER = "http://api.kpzyz.com:8000";//服务器版本测试

	/**
	 * 获取是否使用正式服务器地址
	 * @return
	 */
	public static  String  returnURL() {
		String Url = null;
		
		if (isUse){
			Url = FORMALSERVER; //返回正式服务器地址
		}else {
			Url = CESHISERVER;  //返回测试服务器地址
		}
		
		return Url;
	}
	
	
    
}
