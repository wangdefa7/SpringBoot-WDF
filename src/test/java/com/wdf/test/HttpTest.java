package com.wdf.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;


public class HttpTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpTest.class);

	@Test
	public void mobileSms() {
		JSONObject jsonObject = new JSONObject();
		logger.info("调用短信接口[/msg/mobileSms]....");
		
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
		String url = "http://fudaduanxin.com:81/sendsms2?message=ceshi&phone=17865316817&username=10019&password=dengliang";
		// 通过址默认配置创建一个httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpGet远程连接实例
        HttpGet httpGet = new HttpGet(url);
        // 设置请求头信息
        //httpGet.setHeader("Content-Type", "text/xml;charset=utf-8");
        // 设置配置请求参数
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 请求超时时间
                .setSocketTimeout(60000)// 数据读取超时时间
                .build();
        // 为httpGet实例设置配置
        httpGet.setConfig(requestConfig);
        // 执行get请求得到返回对象
        try {
			response = httpClient.execute(httpGet);
			// 通过返回对象获取返回数据
	        HttpEntity entity = response.getEntity();
	        // 通过EntityUtils中的toString方法将结果转换为字符串
	        result = EntityUtils.toString(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //山大生殖医院返回参数处理（短信接口）
        String msg[] = result.split(",");
        if(msg[0].equals("0") || msg[0].equals("00")) {
        	jsonObject.put("errorCode", "0");
			jsonObject.put("errorMsg", msg[1]);
			logger.info(msg[1]);
        }else{
        	jsonObject.put("errorCode", "2");
			jsonObject.put("errorMsg", msg[1]);
			logger.error("短信接口错误提示："+msg[1]);
        }
	}
}
