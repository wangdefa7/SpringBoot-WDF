package com.wdf.test.page.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wdf.test.javabasic.http.util.PostUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: TestStreamController
 * @Author WDF
 * @Description 下载测试
 * @Date 2021/4/16 13:14
 * @Copyright Dareway 2021/4/16
 * @Version 1.0
 **/
@Controller("/stream")
public class TestStreamController {


    /**
     * @Author WDF
     * @Description 模拟服务端
     * @Date 2021/4/16 9:54
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping("/testMap2Stream")
    @ResponseBody
    public JSONObject testMap2() throws IOException {
        //String  path = "E:\\a.xlsx";
        String  path = "E:\\a.msi";
        File file = new File(path);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        StringBuilder str = new StringBuilder();
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
    @RequestMapping("/testMap2Stream2")
    @ResponseBody
    public String testMap2Stream2(){
        String  path = "E:\\b.msi";
        String json = PostUtil.doPostTestOne("http://localhost/stream/testMap2Stream");
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
}
