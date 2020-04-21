package com.wdf.test.page.layui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: LayuiController
 * @Description: layui和使用webjars路径引入的示例
 * @Auther: WDF
 * @Date: 2020/4/1511:36
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/layui")
public class LayuiController {
    Logger log = LoggerFactory.getLogger(LayuiController.class);

    @RequestMapping("/layuiPage")
    public ModelAndView layuiPage(){
        log.info("进入layui界面");
        ModelAndView modelAndView = new ModelAndView("/layui/layui_webjars");
        return modelAndView;
    }
}
