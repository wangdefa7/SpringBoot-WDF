package com.wdf.test.javabasic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormat {

	public static void main(String[] args) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");//可以方便地修改日期格式

		    //传入的时间长度比格式的时间格式短会抛异常
        String matchDate;
		try {
			//matchDate = dateFormat.format(dateFormat.parse("2019-07-08 15:19"));
			matchDate = dateFormat.format(dateFormat2.parse("20200925135142"));

			System.out.println(matchDate);
	        System.out.println(dateFormat.parse(matchDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
	
	}
}
