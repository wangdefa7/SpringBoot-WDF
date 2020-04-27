package com.wdf.test.javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {


    public static void main(String[] args) {
        FileInputStream fileInnputStream = null;
        try {
            //创建
            fileInnputStream = new FileInputStream("E:\\text.txt");
            //使用
            System.out.println(fileInnputStream.read());
            System.out.println(fileInnputStream.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭流，因为流在最后执行，所以也会抛异常。并不与try里面的一致
                fileInnputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
