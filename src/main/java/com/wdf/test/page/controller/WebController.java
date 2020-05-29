package com.wdf.test.page.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class WebController {
	
	Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String index(){
    	logger.info("访问了首页");
        return "redirect:/0.html";
    }
    
    @RequestMapping("/address")
    @ResponseBody
    public String address(@RequestParam("ip") String ip, @RequestParam("city") String city) {
    	System.out.println("用户["+ip+"] 在  ["+city +"] 访问了这个网站");
    	logger.info("用户[{}] 在 [{}] 访问了这个网站",ip,city);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("ip", ip);
    	jsonObject.put("city", city);
    	return jsonObject.toJSONString();
    }
}
