package com.wdf.test.json.recon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 *  @title
	 *  @Description 描述:获取传入时间的前一天时间
	 *  @author wjZ
	 *  @Date 2020/5/21 14:14
	 *  @params
	 *  @return
	 */
	public static Date getYesterday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}
	/**
	 *
	 * 方法描述.将日期转换成指定格式的字符串
	 * @param date 日期
	 * @param pattern 日期格式
	 * @return 返回值类：日期字符串
	 */
	public static String formatDate(Date date,String pattern) {
		SimpleDateFormat sdf = null;
		String result = "";
		try {
			sdf = new SimpleDateFormat(pattern);
			result = sdf.format(date);
		} catch (Exception e) {
			e.getMessage();
		}

		return result;
	}
	
	/**
	 *  @Description 将一个日期字符串，按它的格式转换为Date
	 *  @method getAddressBookListByXm
	 *  @author LCJ
	 *  @Date 2020年07月08日 下午4:15:21
	 *  @param toFormatString 需要转换的字符串
	 *  @param pattern 匹配格式
	 *  @return
	 */
	public static Date dateStringToDate(String toFormatString, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);	
		Date date = null;

		try {
			date = sdf.parse(toFormatString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	
	/**
	 *  @Description 将一个日期字符串，按它的格式转换为Date,再转换为标准的日期字符串
	 *  @method getAddressBookListByXm
	 *  @author LCJ
	 *  @Date 2020年07月08日 下午4:29:01
	 *  @param toFormatString 需要转换的字符串
	 *  @return
	 */
	public static String toFormatDateString(String toFormatString,
			       String currentPattern, String expectedPattern) {
			Date formatDate = dateStringToDate(toFormatString,currentPattern);
			String formatDateString = formatDate(formatDate,expectedPattern);
		return formatDateString;
	}
	
	/**
	 *  @Description 判断日期字符串是不是符合格式
	 *  @method isValidDate
	 *  @author LCJ
	 *  @Date 2020年07月09日 下午5:29:59
	 *  @param inputStr 需要判断的字符串
	 *  @param validFormat 匹配格式
	 *  @return
	 */
	public static boolean isValidDate(String inputStr, String validFormat) {    
		SimpleDateFormat sdf = new SimpleDateFormat(validFormat);	
		sdf.setLenient(false);
		try {
			sdf.parse(inputStr);
			return true; 
		} catch (ParseException e) {
			return false;
		}			
	}
	
	/**
	 * 方法描述.获取当前字符串时间，格式自定义,如：yyyyMMdd,yyMMdd,yyyyMMddHHmmss等
	 * @author LRM
	 * @param format
	 * @return
	 * @date 2019年7月15日 下午5:06:39
	 */
	public static String getCurrentDateToString(String format) {
		Calendar calendar = Calendar.getInstance(); //获取当前时间
		SimpleDateFormat sdf = null;
		String result = "";
		Date date = new Date(calendar.getTimeInMillis());
		
		try {
			sdf = new SimpleDateFormat(format);
			result = sdf.format(date);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return result;
	}
}

