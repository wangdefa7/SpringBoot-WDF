package com.wdf.test.javabasic.md5;

import com.wdf.test.javabasic.http.get.GetUtil;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MD5Test
 * @Author WDF
 * @Description //TODO
 * @Date 2020/11/26 13:45
 * @Copyright Dareway 2020/11/26
 * @Version 1.0
 **/
public class MD5Test {

    public static void main(String[] args) {
        MD5Test md5Test = new MD5Test();
        String str = MD5("wdrjnp0c");//密码加密
        System.out.println("密码转md5："+str.toLowerCase());
        //e10adc3949ba59abbe56e057f20f883e
       // String time = "20130806102030";
        //               20201126170023
        String time = parseDateToNumberStr2(new Date());
        System.out.println("时间:"+time);
        System.out.println("密码加密与时间拼接："+str.toLowerCase()+time);
        str = MD5(str.toLowerCase()+time);
        System.out.println("key："+str.toLowerCase());
        String key = str.toLowerCase();
        //cd6e1aa6b89e8e413867b33811e70153
        //http://117.122.225.52:8080/eums/sms/gbk/send.do?name=test&seed=20130806102030&key=cd6e1aa6b89e8e413867b33811e70153&dest=13800138000,13012345678&content=test123
        String msgPushUrl = "http://117.122.225.52:8080/eums/sms/gbk/send.do";
        try {
            msgPushUrl = msgPushUrl + "?" +
                    "name=" + URLEncoder.encode("jnfdhy","gbk") + "&" +
                    "seed=" + URLEncoder.encode(time,"gbk") + "&" +
                    "key=" + URLEncoder.encode(key,"gbk") + "&" +
                    "dest=" + URLEncoder.encode("17865316817","gbk") + "&" +
                    "content=" + URLEncoder.encode("1[山大附属生殖医院]","gbk") ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /*String msgPushUrl = "http://117.122.225.52:8080/eums/sms/utf8/send.do";
        try {
             msgPushUrl = msgPushUrl + "?" +
                                        "name=" + URLEncoder.encode("jnfdhy","UTF-8") + "&" +
                                        "seed=" + URLEncoder.encode(time,"UTF-8") + "&" +
                                        "key=" + URLEncoder.encode(key,"UTF-8") + "&" +
                                        "dest=" + URLEncoder.encode("17865316817","UTF-8") + "&" +
                                        "content=" + URLEncoder.encode("1","UTF-8") ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        System.out.println(msgPushUrl);
        //doGetTestOne(msgPushUrl);
        try {
            GetUtil.sendGet(msgPushUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public final static String MD5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String parseDateToNumberStr2(Date date)  {
        final SimpleDateFormat DAYTIME_NUMBER_FORMATOR = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            return DAYTIME_NUMBER_FORMATOR.format(date);
        }catch (Exception e){
            return null;
        }
    }

    public static void doGetTestOne(String url) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
