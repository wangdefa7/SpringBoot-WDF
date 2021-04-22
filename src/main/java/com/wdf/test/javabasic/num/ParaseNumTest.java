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
		int b_big = 15;
		Integer a_big = new Integer(b_big);
		Integer c_big = new Integer(b_big);
		Integer d_big = b_big;
		Integer e_big = b_big;
		if (a_big == b_big){
			System.out.println("==");
		}
		if (a_big.equals(b_big)){
			System.out.println("equals");
		}
		System.out.println("-----------");
		//包装类型之间不相等，需要用equals进行比较。
		if (a_big == c_big){
			System.out.println("==");
		}
		if (a_big.equals(c_big)){
			System.out.println("equals");
		}
		System.out.println("-----------");
		//超出了int的范围(128)，就会类似于String一样，new一个新的对象.如果在范围内会相等
		if (d_big == e_big){
			System.out.println("==");
		}
		if (d_big.equals(e_big)){
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
