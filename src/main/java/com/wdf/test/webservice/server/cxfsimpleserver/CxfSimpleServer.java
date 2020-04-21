package com.wdf.test.webservice.server.cxfsimpleserver;

import com.wdf.test.webservice.server.cxfsimpleserver.service.WsInterface;
import com.wdf.test.webservice.server.cxfsimpleserver.service.impl.WsInterfaceImpl;
import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * @ClassName: CxfSimpleServer
 * @Description:  简单发布cxfServer 接口
 * 该方式无需在类中指定相关协议，也就是说不需要在类中指定相关webservice注解，一个普通类就行。
 * https://www.cnblogs.com/domi22/p/8068291.html
 * @Auther: WDF
 * @Date: 2020/4/2116:16
 * @Version: 1.0
 **/
public class CxfSimpleServer {

    public static void main(String[] args) {
        ServerFactoryBean svrFactory = new ServerFactoryBean();
        //设置服务接口类
        svrFactory.setServiceClass(WsInterface.class);
        svrFactory.setAddress("http://localhost/cxfs");
        //设置服务实现接口类
        svrFactory.setServiceBean(new WsInterfaceImpl());
        svrFactory.create();
        System.out.println("http://localhost/cxfs 发布成功");
    }
}
