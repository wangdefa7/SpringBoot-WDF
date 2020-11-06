package com.wdf.test.javabasic.file.path;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: FileTest
 * @Author WDF
 * @Description io下的File测试类
 * @Date 2020/11/6 13:07
 * @Copyright Dareway 2020/11/6
 * @Version 1.0
 **/
public class FileTest {
    public static void main(String[] args) throws IOException {
        FileTest fileTest = new FileTest();
        fileTest.fileExists();
    }

    public  void fileExists() throws IOException {
        String afilePath = "E://a//b//a.txt";
        File afile = new File(afilePath);
        System.out.println(afile.exists());
        System.out.println(afile.getParentFile().exists());
        System.out.println(afile.isFile());
        afile.getParentFile().mkdirs();
        System.out.println("mkdirs----");//递归创建父目录
        System.out.println(afile.exists());
        System.out.println(afile.getParentFile().exists());
        System.out.println(afile.isFile());
        afile.createNewFile();//创建文件
        System.out.println("createNewFile----");
        System.out.println(afile.exists());
        System.out.println(afile.getParentFile().exists());
        System.out.println(afile.isFile());
    }
}
