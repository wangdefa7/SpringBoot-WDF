package com.wdf.test.page.echarts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Echarts配置
 */
@RequestMapping("/echarts")
@Controller
public class EchartsPageController {

    Logger logger = LoggerFactory.getLogger(EchartsPageController.class);

    /**
     * echarts菜单
     * @return
     */
    @RequestMapping("/")
    public String menu(){
        logger.info("menu。。。。");
        return "/echarts/menu";
    }

    /**
     * 测试demo1
     * @return
     */
    @RequestMapping("demo1")
    public String openEchartsDemo(){
        logger.info("openEchartsDemo....");
        return "/echarts/demo1";
    }

    /**
     * 测试demo2
     * @return
     */
    @RequestMapping("demo2")
    public String openEchartsDemo2(){
        logger.info("openEchartsDemo2....");
        return "/echarts/demo2-PageButton";
    }
}
