package com.wdf.test.javabasic.String;

public class Split {
	public static void main(String[] args) {
		String str ="123- ";
		String[] strz = str.split("-");
 		System.out.println(strz[0]);

 		String string = "update URP.UNIONPAY_TRANSFLOW set sfsc =";
		strz = string.split("set");
		System.out.println(strz[0]);
		System.out.println(strz[1]);


		String str1 ="T+1 ";
		//两种转义方式
		//String[] strz1 = str1.split("[+]");
		String[] strz1 = str1.split("\\+");
		System.out.println(strz1[1]);
	}

}
