package com.wdf.test.page.ztree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Ztree的操作
 */
@Controller
@RequestMapping("/ztree")
public class ZtreeController {

    Logger log = LoggerFactory.getLogger(ZtreeController.class);

    @RequestMapping("/ztreePage")
    public ModelAndView ztreePage(ModelAndView modelAndView){
        modelAndView = new ModelAndView("/ztree/ztree");
        return modelAndView;
    }
}
