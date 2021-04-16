package com.wdf.test.page.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wdf.test.javabasic.http.util.PostUtil;
import com.wdf.test.javabasic.io.FileInputStreamTest;
import org.apache.commons.io.FileUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Byte.parseByte;

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

    /**
     * @Author WDF
     * @Description 模拟服务端
     * @Date 2021/4/16 9:54
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping("/testMapStream")
    @ResponseBody
    public JSONObject testMap() throws IOException {
        //String  path = "E:\\a.xlsx";
        String  path = "D:\\a.txt";
        File file = new File(path);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        StringBuilder str = new StringBuilder();
        String[] strings = new String[bytes.length];
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",bytes);
        return jsonObject;
    }

    /**
     * @Author WDF
     * @Description 模拟客户端
     * @Date 2021/4/16 9:54
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/testMapStream2")
    @ResponseBody
    public String testMapStream2(){
        String  path = "D:\\b.txt";
        String json = PostUtil.doPostTestOne("http://localhost/testMapStream");
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println("jsonObject");
        byte[] bytes = jsonObject.getBytes("data");
        System.out.println("数组长度："+ bytes.length);
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(path);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(path);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return "ok";
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
