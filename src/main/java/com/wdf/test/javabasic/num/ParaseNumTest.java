package com.wdf.test.javabasic.num;

/**
 * 
 * @Package: com.wdf.test.javabasic.num
 * @ClassName: ParaseNumTest
 * @Description: 十进制与其他进制的转换
 * @author: WDF
 * @date: 2020年8月12日 上午9:01:21
 * @version: V1.0
 */
public class ParaseNumTest {
	
	public static void main(String[] args) {
		
		int num = 100;
		/**
		 *	 转换的进制范围2-36
		 */
		System.out.println(Integer.toString(num, 2));//转二进制
		System.out.println(Integer.toString(num, 8));//转8进制
		System.out.println(Integer.toString(num, 16));//转16进制
	}

}
