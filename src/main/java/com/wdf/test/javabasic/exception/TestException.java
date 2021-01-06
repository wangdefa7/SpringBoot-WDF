package com.wdf.test.javabasic.exception;

/**
 * 
 * @Package: com.wdf.test.javabasic.exception
 * @ClassName: TestException
 * @Description: 异常方法的测试
 * @author: WDF
 * @date: 2020年6月1日 下午3:30:56
 * @version: V1.0
 */
public class TestException {

	public static void main(String[] args) {
		//noCatch();
		hadCatch();
	}
	
	/**
	 * 
	 * @Title: hadCatch
	 * @author: WDF
	 * @Description: 有异常处理的情况下，程序会自动的抛出异常，不影响程序的往下执行
	 * @date: 2020年6月1日 下午3:48:39
	 */
	public static void hadCatch() {
		try {
			String a = null;
			if (a.equals(null)) {
				System.out.println("--"+a);
			}
			System.out.println(a);
		} catch (Exception e) {
	//		e.getCause();
			System.out.println("e:" + e);
			System.out.println("e.toString():" + e.toString());
			System.out.println("e.getMessage():" + e.getMessage());
			e.getLocalizedMessage();
			System.out.println("----");
			e.getMessage();
//			e.getStackTrace();
			System.out.println("----");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			System.out.println("finally");
		}
		System.out.println("end");
	}
	
	/**
	 * 
	 * @Title: noCatch
	 * @author: WDF
	 * @Description: 没有有异常处理的情况下，程序会抛出异常后，程序会直接在这个位置死掉
	 * @date: 2020年6月1日 下午3:49:38
	 */
	public static void noCatch() {
		String a = null;
		if (a.equals(null)) {
			System.out.println("--"+a);
		}
		System.out.println(a);
		System.out.println("end");
	}
}
