package com.wdf.test.page.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * bootstrap的操作
 */
@Controller
@RequestMapping("/bootstrap")
public class BootsTrapController {

    Logger log = LoggerFactory.getLogger(BootsTrapController.class);

    @RequestMapping("/bootstrapPage")
    public String tablePage(){
        log.info("进入bootstrap - bootstrapPage页面");
        return "bootstrap/bootstrapPage";
    }
    @RequestMapping("/panel")
    public String panel(){
        log.info("进入bootstrap - tablePanel页面");
        return "bootstrap/Panel";
    }

    @RequestMapping("/table")
    public String tablePanel(){
        log.info("进入bootstrap - table页面");
        return "bootstrap/table";
    }
}
