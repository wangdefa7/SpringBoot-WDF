package com.wdf.test.javabasic.String;

/**
 * 
 * @Package: com.wdf.test.javabasic.String
 * @ClassName: StringSubString
 * @Description: 字符串操作
 * @author: WDF
 * @date: 2020年5月13日 上午9:46:27
 * @version: V1.0
 */
public class StringSubString {
	
	public static void main(String[] args) {
		String  fileName = "wdf.jpg";
		int i = fileName.lastIndexOf(".");//i = 3 字符串从0开始
		String hzm = fileName.substring(i);
		System.out.println(hzm);
	}

}
