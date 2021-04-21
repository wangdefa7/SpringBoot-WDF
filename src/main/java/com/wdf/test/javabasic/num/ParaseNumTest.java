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

		ParaseNumTest main = new ParaseNumTest();
		main.testInteger();
		//main.testParse();
	}

	private void testInteger(){
		Integer a_big = new Integer(155);
		int b_big = 155;
		if (a_big == b_big){
			System.out.println("==");
		}
		if (a_big.equals(b_big)){
			System.out.println("equals");
		}
	}

	private void testParse(){
		int num = 100;
		/**
		 *	 转换的进制范围2-36
		 *	超出进制范围显示十进制的结果
		 */
		System.out.println(Integer.toString(num, 2));//转二进制
		System.out.println(Integer.toString(num, 8));//转8进制
		System.out.println(Integer.toString(num, 16));//转16进制
		System.out.println(Integer.toString(num, 37));//转37进制，超出范围显示十进制结果

		/**
		 * 	把其他进制转回十进制
		 * parseInt返回的是int类型
		 * valueOf 返回的是String类型
		 */
		System.out.println(Integer.parseInt("1100010", 2));//二进制转十进制
		System.out.println(Integer.parseInt("62", 16));//16进制转十进制
		System.out.println(Integer.parseInt("2q", 36));//二进制转十进制
	}

}
