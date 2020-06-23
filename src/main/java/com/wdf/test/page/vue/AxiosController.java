package com.wdf.test.page.vue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Vue测试返回数据
 */

@RequestMapping("/vueAxios")
@Controller
public class AxiosController {

    private Logger logger  = LoggerFactory.getLogger(AxiosController.class);

    /**
     * Vue测试的返回数据
     * @return
     */
    @RequestMapping("/vueData")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    public String vueData(@RequestParam("vue") String vue){
        logger.info("vueData 测试返回数据.....");
        System.out.println(vue);
        String msg = "《- Server Data : hello, Vue | "+ vue +" -》";
        return msg;
    }
}
