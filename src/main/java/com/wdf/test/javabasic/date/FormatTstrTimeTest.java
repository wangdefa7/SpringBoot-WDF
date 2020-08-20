package com.wdf.test.javabasic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatTstrTimeTest {

	public static void main(String[] args) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH24:Mi:ss
		String time = "2020-08-18T16:48:13.023";
		time = time.replace("T", " ").substring(0, time.lastIndexOf("."));
		System.out.println(time);
		try {
			System.out.println(format.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
