package com.wdf.test.javabasic.file.path;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @ClassName: TestPath
 * @Author WDF
 * @Description //TODO
 * @Date 2020/10/14 13:49
 * @Copyright Dareway 2020/10/14
 * @Version 1.0
 **/
public class TestPath {
    public static void main(String[] args) {
        try {
            String url = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(url);
            getResourcePath();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getResourcePath() throws FileNotFoundException {
        String fileName = "";
        // 方法1：获取文件或流
//        this.getClass().getResource("/")+fileName;
//        this.getClass().getResourceAsStream(failName);
// 方法2：获取文件
        File file = org.springframework.util.ResourceUtils.getFile("classpath:favicon.ico");
        System.out.println(file);
        // 方法3：获取文件或流
//        ClassPathResource classPathResource = new ClassPathResource("test.txt");
//        classPathResource .getFile();
//        classPathResource .getInputStream();

// >>>>>>>>>>>>>>>> 下面方法可以读取jar包下文件
        // 假设resources目录下有一个test.txt文件，首先获得当前的类加载器，通过类加载器读取文件。

// 方法1
    //    InputStream io = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.txt");
// 方法2
      //  InputStream io = getClass().getClassLoader().getResourceAsStream("test.txt");
    }
}
