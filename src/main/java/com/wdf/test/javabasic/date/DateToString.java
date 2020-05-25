package com.wdf.test.javabasic.date;

import java.util.Date;

public class DateToString {
	public static void main(String[] args) {
		String time = new Date().toString();
		System.out.println(time);
		
		System.out.println(System.currentTimeMillis());
	}

}
