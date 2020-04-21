package com.wdf.test.webservice.server.jdkserver;


import com.wdf.test.webservice.server.jdkserver.service.impl.WsInterfaceImpl;

import javax.xml.ws.Endpoint;

/**
 * @ClassName: JdkWsServer
 * @Description: jdk自带的服务发布
 * @Auther: WDF
 * @Date: 2020/4/2110:06
 * @Version: 1.0
 **/
public class JdkWsServer {

    public static void main(String[] args) {
        System.out.println("JDK WebService 发布开始---");
        WsInterfaceImpl stuimpl = new WsInterfaceImpl();
        String url = "http://192.168.31.244/jdk";//ipconfig得到的本机地址
        Endpoint.publish(url,stuimpl);
        System.out.println("JDK WebService 已经发布---");
    }
}
