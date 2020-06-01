package com.wdf.test.javabasic.digui;

/**
 * 
 * @Package: com.wdf.test.javabasic.digui
 * @ClassName: TestOrder
 * @Description: 测试递归的执行顺序
 * @author: WDF
 * @date: 2020年6月1日 下午2:39:17
 * @version: V1.0
 */
public class TestOrder {

	public static void main(String[] args) {
		System.out.println(orderTest(3,false));;
	}
	
	public static String orderTest(int num,boolean flag) {
		if (flag) {
			return "succ";
		}else {
			if (num == 0) {
				System.out.println("num==");
				return "fail";
			}else {
				System.out.println("num:"+num);
				return orderTest(--num,flag);
			}
		}
		
	}
}
