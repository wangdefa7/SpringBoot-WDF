package com.wdf.test.webservice.server.cxfserver.service;

import javax.jws.WebService;

/**
 * @ClassName: WsInterface
 * @Description: jdk发布方式的接口
 * @Auther: WDF
 * @Date: 2020/4/2110:14
 * @Version: 1.0
 **/
@WebService
public interface WsInterface {

     String say(String s);
}
