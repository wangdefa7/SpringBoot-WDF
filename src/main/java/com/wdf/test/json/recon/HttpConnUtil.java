package com.wdf.test.json.recon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** 
 * <p>Description: [将请求转发到前置机的具体实现]</p>
 * Created on 2013-7-18
 * @author  YQZL--银企直连
 * @version 1.0 
 * Copyright (c) 2013 宇信易诚--新企业网银--银企直连 
 */ 
public class HttpConnUtil {
	/**
     * 转发至网
     * 
     * @param formData 原表单数
     * @param signedData 已签名数
     * @param encryptPwdType 密码加密类型
     * @return Object
     */
	//, HttpServletRequest request, HttpServletResponse response
    public static String forwardNetBank(String url, String cgb_data) throws Exception {
        return getHttpDocument(url, cgb_data, 200000);
//    	return "返回报文";
    }
    
    /**
     * 通过流的方式，推送数据到网银
     * 
     * @param urlStr 网银URL
     * @param formData 原表单数
     * @param signedData 已签名数
     * @param encryptPwdType 密码加密类别
     * @param timeOut 过期时间
     * @param isAuth 与网银的连接是否提供客户端证??
     * @return 
     */
    public static String getHttpDocument(String url, String cgb_data, int timeOut) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setConnectTimeout(timeOut);
        conn.getOutputStream().write(("cgb_data="+cgb_data).getBytes());
        String document = getDataFromAppServerNewLine(conn, false);
        conn.disconnect();
        return document;
    }
    
    public static String getDataFromAppServerNewLine(HttpURLConnection conn, boolean isNewLine) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String buffer = "";
        String sumBuffer = "";
        while (buffer != null) {
            try {
                buffer = br.readLine();
                if (buffer != null) {
                    if (isNewLine) {
                        sumBuffer += "\n";
                    }
                    sumBuffer += buffer;
                }
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                break;
            }
        }
        if (isNewLine) {
            sumBuffer = sumBuffer.trim();
        }
        return new String(sumBuffer.getBytes(), "GBK").toString();
    }
}
