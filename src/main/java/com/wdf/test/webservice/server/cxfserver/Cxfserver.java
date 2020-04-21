package com.wdf.test.webservice.server.cxfserver;

import com.wdf.test.webservice.server.cxfserver.service.WsInterface;
import com.wdf.test.webservice.server.cxfserver.service.impl.WsInterfaceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


/**
 * @ClassName: Cxfserver
 * @Description:
 * @Auther: WDF
 * @Date: 2020/4/2110:51
 * @Version: 1.0
 **/
public class Cxfserver {

    public static void main(String[] args) {
       // System.out.println("");
        System.out.println("CXF WebService 发布开始---");
        WsInterfaceImpl stuimpl = new WsInterfaceImpl();
        String url = "http://192.168.31.244/cxf";//ipconfig得到的本机地址
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress(url);//设置地址
        factoryBean.setServiceClass(WsInterface.class);//设置接口
        factoryBean.setServiceBean(new WsInterfaceImpl());//设置实现类
        factoryBean.create();//创建接口
        System.out.println("CXF WebService 已经发布---");
    }

}
