package com.wdf.test.javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流（byte缓冲区）
 */
public class FileStreamTest {

    public static void main(String[] args) {

        try {
            //创建流
            FileInputStream fileInputStream = new FileInputStream("E:\\test.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\test-byte.txt");

            //使用
            byte[] bytes = new byte[1024];//创建缓冲区
            while((fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes);
                System.out.println(bytes);
            }
            System.out.println("复制完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
