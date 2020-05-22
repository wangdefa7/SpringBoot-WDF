package com.wdf.test.page.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	
	Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String index(){
        System.out.println("访问了首页");
        return "redirect:/0.html";
    }
    
    @RequestMapping("/address")
    @ResponseBody
    public String address(@RequestParam String ip, @RequestParam String city) {
    	System.out.println("用户"+ip+"在 "+city +" 访问了这个网站");
    	logger.info("用户[{}] 在 [{}] 访问了这个网站",ip,city);
    	return ip+"  "+city;
    }
}
