package com.wdf.test.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index(){
        System.out.println("访问了首页");
        return "redirect:/0.html";
    }
}
