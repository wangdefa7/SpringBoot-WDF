package com.wdf.test.webservice.server.cxfserver.service.impl;

import com.wdf.test.webservice.server.cxfserver.service.WsInterface;

import javax.jws.WebService;

/**
 * @ClassName: WsInterfaceImpl
 * @Description:
 * @Auther: WDF
 * @Date: 2020/4/2110:15
 * @Version: 1.0
 **/
@WebService
public class WsInterfaceImpl implements WsInterface {


    public String say(String s) {
        System.out.println("调用了实现类方法，传入的值:"+s);
        return "ws 返回值++++"+s;
    }
}
