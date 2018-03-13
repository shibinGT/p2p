package com.qhcs.security.cache;

/**
 * 常量类(为规范化添加前缀)
 * 
 * @author Administrator
 *
 */
public class Constants {
	private Constants(){}

	public static String getUserSessionKey(String name){
		return "usk:"+name;
	}
	
	public static String getUserModuleCacheKey(String str){
		return "auths:"+str;
	}
	
	public static String getUserRolesCacheKey(String str){
		return "roles:"+str;
	}
	

}
