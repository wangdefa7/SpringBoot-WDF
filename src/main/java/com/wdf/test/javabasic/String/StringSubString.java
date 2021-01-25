package com.wdf.test.javabasic.String;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		String  fileName = "wdf.jpg";
		int i = fileName.lastIndexOf(".");//i = 3 字符串从0开始
		String hzm = fileName.substring(i);
		System.out.println(hzm);

		String test = "20200703101025";
		System.out.println(test.substring(0,8));//0,1位置的显示，2位置的不显示
		System.out.println(test.substring(2,3));//显示2，3位置的不显示
		System.out.println(test.substring(-1,2));

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

		//System.out.println(compareTime("2020-07-15T16:02:27.98","2020-07-15 16:02:26"));
	}

}
