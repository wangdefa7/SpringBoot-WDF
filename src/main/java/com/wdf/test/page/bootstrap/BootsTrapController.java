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

    @RequestMapping("/tablePage")
    public String tablePage(){
        log.info("进入bootstrap - table页面");
        return "bootstrap/table";
    }
}
