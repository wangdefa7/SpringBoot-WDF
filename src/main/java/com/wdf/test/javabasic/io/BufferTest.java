package com.wdf.test.javabasic.io;

import java.io.*;

/**
 * Buffer缓冲区的操作 - 必须要关闭之后才能实现输出操作
 */
public class BufferTest {

    public static void main(String[] args) {
        try {
            //创建内容
            BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\test.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\test-buffer.txt"));
            //如果一个文件还没有被操作，就被另一个占用了。则读不到东西

            //读入内容
            System.out.println(bufferedReader.readLine());
            bufferedWriter.write("bufferwriter");
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
