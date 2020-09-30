package com.wdf.test.json.recon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String doPostBank(String url, String cgb_data) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("GBK");

		//url = url + "/CGBClient/BankAction";
		logger.info("url={}", url);
		String rep_data = "";
		try {
			 rep_data = HttpConnUtil.forwardNetBank(url, cgb_data);//返回xml格式
			 logger.info("请求返回内容：{}", rep_data);
		} catch (Exception e) {
			logger.error("请求异常：{}", e.getMessage());
			e.printStackTrace();
			rep_data="请求出现异常！";
		}
		return rep_data;
	}
	
}
