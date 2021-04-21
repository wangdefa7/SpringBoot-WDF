package com.wdf.test.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: RequestMappingTestController
 * @Author WDF
 * @Description RequestMapping注解的用法
 * @Date 2021/4/20 11:11
 * @Copyright Dareway 2021/4/20
 * @Version 1.0
 **/
@Controller
public class RequestMappingTestController {

    /**
     * @Author WDF
     * @Description 限制请求参数
     * @Date 2021/4/20 11:13
     * @Param []
     * @return java.lang.String
     **/
    // 该方法将接收 /user/login 发来的请求，且请求参数必须为 username=kolbe&password=123456
    @RequestMapping(path = "/limitRequest", params={"username=kolbe","password=123456"})
    public String limitRequest() {
        return "success";
    }

    /**
     * @Author WDF
     * @Description 限制header
     * @Date 2021/4/20 11:17
     * @Param []
     * @return java.lang.String
     **/
    // 表示只接收本机发来的请求
    @RequestMapping(path = "/limitIP", headers="Host=localhost:8080")
    public String limitIP() {
        return "success";
    }

    /**
     * @Author WDF
     * @Description value重复是可以的， 但method属性就不能一样了， 必需是不同的方式，一个get，一个post才行，这样确实可以的
     * @Date 2021/4/20 11:19
     * @Param
     * @return
     **/
    @RequestMapping(path = "/repeat", headers="Host=localhost:8080",method = RequestMethod.POST)
    public String repeat() {
        return "success";
    }
    @RequestMapping(path = "/repeat", headers="Host=localhost:8080",method = RequestMethod.GET)
    public String repeat2() {
        return "success";
    }
}
