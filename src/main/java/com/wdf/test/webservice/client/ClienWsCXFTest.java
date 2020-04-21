package com.wdf.test.webservice.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName: ClienWsTest
 * @Description: jdk调用 客户端测试
 * @Auther: WDF
 * @Date: 2020/4/2111:23
 * @Version: 1.0
 **/
public class ClienWsCXFTest {

            public static void main(String[] args) throws IOException {
                //第一步：创建服务地址，不是WSDL地址
                URL url = new URL("http://192.168.31.244/cxf");
                //第二步：打开一个通向服务地址的连接
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //第三步：设置参数
                //3.1发送方式设置：POST必须大写
                connection.setRequestMethod("POST");
                //3.2设置数据格式：content-type
                connection.setRequestProperty("content-type", "text/xml;charset=UTF-8");
                //3.3设置输入输出，因为默认新创建的connection没有读写权限，
                connection.setDoInput(true);
                connection.setDoOutput(true);
                //第四步：组织SOAP数据，发送请求
                String soapXML = getXML("XXXXXXX");
                OutputStream os = connection.getOutputStream();
                os.write(soapXML.getBytes());
                //第五步：接收服务端响应，打印
                int responseCode = connection.getResponseCode();
                if(200 == responseCode){//表示服务端响应成功
                    InputStream is = connection.getInputStream();
                    //将字节流转换为字符流
                    InputStreamReader isr = new InputStreamReader(is,"utf-8");
                    //使用缓存区
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String temp = null;
                    while(null != (temp = br.readLine())){
                        sb.append(temp);
                    }
                    System.out.println(sb.toString());

                    is.close();
                    isr.close();
                    br.close();
                }

                os.close();
            }

        //组织数据，将数据拼接一下
        public static String getXML(String msg){
            String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                    +"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.cxfserver.server.wdf.com/\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <ser:say>\n" +
                    "         <!--Optional:-->\n" +
                    "         <arg0>"+ msg +"</arg0>\n" +
                    "      </ser:say>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            return soapXML;
        }
    }

