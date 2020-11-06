package com.wdf.test.javabasic.file.path;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: SpringBootGetFile
 * @Author WDF
 * @Description SpringBoot获取resource下面的几种方式
 *  参考：https://www.jianshu.com/p/7d7e5e4e8ae3
 * @Date 2020/11/6 16:22
 * @Copyright Dareway 2020/11/6
 * @Version 1.0
 **/
public class SpringBootGetFile {


    public void testGetFile() throws IOException {
        //1
        ClassPathResource classPathResource = new ClassPathResource("excleTemplate/test.xlsx");
        InputStream inputStream =classPathResource.getInputStream();
        //2
        InputStream inputStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("excleTemplate/test.xlsx");
        //3
        InputStream inputStream3 = this.getClass().getResourceAsStream("/excleTemplate/test.xlsx");
        //4
        File file = ResourceUtils.getFile("classpath:excleTemplate/test.xlsx");
        InputStream inputStream4 = new FileInputStream(file);

    }
}
