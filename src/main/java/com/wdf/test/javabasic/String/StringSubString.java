package com.wdf.test.javabasic.String;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		//lastIndexOf  最后一次出现的索引
		String  fileName = "wdf.jpg";
		int i = fileName.lastIndexOf(".");//i = 3 字符串从0开始
		String hzm = fileName.substring(fileName.length()-i,fileName.length());
		System.out.println(hzm);
		
		String urlString = "http://172.16.1.162:8070/FeeService.asmx/IPay_GetStatementInfo";
		int position = urlString.lastIndexOf(".asmx");//
		int position2 = position + 5;
		System.out.println(position);
		System.out.println(position2);
		System.out.println(urlString.substring(0,position2));
		
		
		//双重转换处理时间格式中带有T的参数
		String time = "2020-07-15T16:02:27.98";
		System.out.println(time.substring(11, 19));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			//System.out.println(dateFormat.format(format.parseObject(time)));
			System.out.println(dateFormat.format(format.parse(time)));
			//System.out.println(dateFormat.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(compareTime("2020-07-15T16:02:27.98","2020-07-15 16:02:26"));
	}

	
	public static boolean compareTime(String hisTime, String flagTime) {
		boolean flag = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date hisDate,unionpayDate;
		try {
			hisDate = format.parse(hisTime);
			unionpayDate = dateFormat.parse(flagTime);
			if(unionpayDate.before(hisDate)){ //his的时间早于银联的截至时间
                flag = true;
            }else{  
            	flag = false;
            } 
			//System.out.println(dateFormat.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
