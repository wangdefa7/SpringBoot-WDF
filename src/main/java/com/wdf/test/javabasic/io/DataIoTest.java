package com.wdf.test.javabasic.io;

import java.io.*;

/*
二进制流的读取
 */
public class DataIoTest {

    public static void main(String[] args) {

        try {
            //创建输入流
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("E:\\test.txt"));
            //创建输出流
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("E:\\test2.txt"));

            //使用流复制
            int r;
            while((r=dataInputStream.read())!=-1){
                dataOutputStream.write(r);
            }
            System.out.println("复制完成");

            //关闭流
            dataInputStream.close();
            dataOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
