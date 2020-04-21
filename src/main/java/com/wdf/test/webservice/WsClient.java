package com.wdf.test.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @ClassName: WsClient
 * @Description: 调用webservice的测试类（spring boot）
 * @Auther: WDF
 * @Date: 2020/4/2113:24
 * @Version: 1.0
 **/

@RestController
@RequestMapping("/cxf")
public class WsClient {

   // @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/clientTest")
    @CrossOrigin
    public String clientTest() {
        String url = "http://192.168.31.244/cxf";
        String str = "clientTest";
        String msg = restTemplate.postForEntity(url, str, String.class).getBody();
        System.out.println("收到的信息："+msg);
        return msg;
    }

    @RequestMapping("/client2Test")
    public String client2Test(){
        JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();

        Client client=dcflient.createClient("http://192.168.31.244/cxf?wsdl");
        try{
            Object[] objects=client.invoke("");
            System.out.println("getUserById 调用结果："+objects[0].toString());

            Object[] objectall=client.invoke("getUsers");
            System.out.println("getUsers调用部分结果："+objectall[0].toString());

        }catch (Exception e){
            e.printStackTrace();
        }

        return "ok";
    }

    /**
     * @Author WDF
     * @Description
     * @Date 15:50 2020/4/21
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/http")
    public String httpWsTest() throws IOException {
        //第一步：创建服务地址，不是WSDL地址
        URL url = new URL("http://192.168.31.244/jdk");
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
                    return "OK";
}

    //组织数据，将数据拼接一下
    public static String getXML(String msg){
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
                        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.jdkserver.server.wdf.com/\">\n" +
                                "   <soapenv:Header/>\n" +
                                "   <soapenv:Body>\n" +
                                "      <ser:say>\n" +
                                "         <!--Optional:-->\n" +
                                "         <arg0>" + msg + "</arg0>\n" +
                                "      </ser:say>\n" +
                                "   </soapenv:Body>\n" +
                                "</soapenv:Envelope>";
        return soapXML;
    }
}
