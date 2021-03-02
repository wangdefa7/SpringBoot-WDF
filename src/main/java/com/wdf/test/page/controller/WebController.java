package com.wdf.test.page.controller;

import com.wdf.test.config.result.ResponseResult;
import com.wdf.test.config.result.Result;
import com.wdf.test.config.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * 
 * @Package: com.wdf.test.page.controller
 * @ClassName: WebController
 * @Description: 
 * @author: WDF
 * @date: 2020年5月29日 上午10:53:34
 * @version: V1.0
 */
@Controller
@RequestMapping
//@ResponseResult
public class WebController {

    Logger logger = LoggerFactory.getLogger(WebController.class);
    public static int num = 0;
    public static HashMap<Integer,Integer> map = new HashMap<>();

    /**
     * @Author WDF
     * @Description 访问域名首页跳转
     * @Date 2020/10/30 11:01
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/")
    public String index() {
        logger.info("访问了首页");
        return "redirect:/0.html";
    }

    /**
     * @Author WDF
     * @Description 后台打印首页被谁访问过
     * @Date 2020/10/30 11:01
     * @Param [ip, city]
     * @return java.lang.String
     **/
    @RequestMapping("/address")
    @ResponseBody
    public String address(@RequestParam("ip") String ip, @RequestParam("city") String city) {
        System.out.println("用户[" + ip + "] 在  [" + city + "] 访问了这个网站");
        logger.info("用户[{}] 在 [{}] 访问了这个网站", ip, city);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ip", ip);
        jsonObject.put("city", city);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/resultCode/s")
    @ResponseBody
    public Result TestResultCode(){
        logger.info("TestResultCode...");
        return new Result(ResultCode.SUCCESS,"TestResultCode");
    }

    @RequestMapping("/resultCode/static")
    @ResponseBody
    public Result TestResultCodeStatic(){
        logger.info("TestResultCode...");
        return Result.success("测试静态方法返回值的调用");
    }

    @RequestMapping("/resultCode/a")
    @ResponseBody
    @ResponseResult
    public String TestResultCodeAnnotation(){
        logger.info("TestResultCodeAnnotation...");
        return "TestResultCodeAnnotation";
    }

    @RequestMapping("/test")
    @ResponseBody
    public int test(){
        System.out.println(num++);
        try {
            Runnable runnable = ()->{
                map.put(1,num);
            };

            Thread thread = new Thread(runnable);
            thread.start();

            Thread.sleep(3000);
            System.out.println(map.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return num;
    }
   
}