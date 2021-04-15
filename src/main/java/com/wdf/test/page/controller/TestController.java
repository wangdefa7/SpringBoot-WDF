package com.wdf.test.page.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TestController
 * @Author WDF
 * @Description //TODO
 * @Date 2021/1/15 11:01
 * @Copyright Dareway 2021/1/15
 * @Version 1.0
 **/
@RestController
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/testMap")
    @ResponseBody
    public String testMap(@RequestParam Map<String, Object> map){
        logger.info(map.toString());
        return map.toString();
    }

    @RequestMapping("/testFile")
    @ResponseBody
    public JSONObject testFile(){
        Map map = new HashMap();
        File file = new File("D:\\a.xls");
        String msg = null;
        byte[] bytes = null;
        try {
            bytes = FileUtils.readFileToByteArray(file);
            msg = FileUtils.readFileToString(file,Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("data",bytes);
        System.out.println(bytes);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }
}
