package com.wdf.test.javabasic.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Package: com.wdf.test.javabasic.log
 * @ClassName: LogBasic
 * @Description: 日志基本操作类
 * @author: WDF
 * @date: 2020年5月21日 下午3:21:09
 * @version: V1.0
 */
public class LogBasic {
	
	private static Logger logger = LoggerFactory.getLogger(LogBasic.class);
	
	public static void main(String[] args) {
		String msg = "Hello World";
		logger.info("[{}]",msg);
		logger.error("[{}]",msg);
		logger.debug("[{}]",msg);
		logger.warn("[{}]",msg);
		System.out.println("-------------");
		logger.info("[{}]  [{}]",msg,msg);
		logger.info("{}",msg);//日志最简单格式
	}
}
