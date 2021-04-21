package com.wdf.test.javabasic.date;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateToString {

	public static void main(String[] args) {
		DateToString main = new DateToString();
		main.testInstant();
		String time = new Date().toString();
		System.out.println(time);
	}

	/**
	 * 获取的时间戳与北京时间相差8个时区，需要修正为北京时间，
	 * 通过查看源代码发现Instant.now()使用等是UTC时间Clock.systemUTC().instant()。
	 * LocalDate、LocalDateTime 的now()方法使用的是系统默认时区 不存在Instant.now()的时间问题。
	 * ###解决方法
	 * 增加8个小时
	 * ————————————————
	 * 版权声明：本文为CSDN博主「springinwinter_4all」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
	 * 原文链接：https://blog.csdn.net/chunzhilianxue/article/details/80974202
	 **/
	private void testInstant(){
		Instant now1 = Instant.now();
		System.out.println("now:"+now1);
		//加八个小时
		Instant now = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
		System.out.println("now:"+now);
	}

}
