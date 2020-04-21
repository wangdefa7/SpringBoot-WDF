package com.wdf.test.page.freemaker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 测试freemarker
 */
@Controller
@RequestMapping("/freemaker")
public class FreemarkerController {

    @RequestMapping("/page")
    public ModelAndView page(){
        ModelAndView modelAndView = new ModelAndView("/freemaker/freemaker");
        modelAndView.addObject("key1","测试数据");
        modelAndView.addObject("key2",new Date().toString());
        modelAndView.addObject("key3",new Date());
        return modelAndView;
    }
}
