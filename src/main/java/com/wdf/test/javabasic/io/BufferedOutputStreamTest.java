package com.wdf.test.javabasic.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @Package: com.wdf.test.javabasic.io
 * @ClassName: BufferedOutputStreamTest
 * @Description: BufferedOutputStream测试写入内容到文件
 * @author: WDF
 * @date: 2020年4月29日 下午5:03:32
 * @version: V1.0
 */
public class BufferedOutputStreamTest {
	
	/**
	 * 
	 * @Title: main
	 * @author: WDF
	 * @Description: BufferedOutputStream需要一个输出流作为实例化参数。
	 * FileOutputStream是用于写文件的输出流，所以它需要一个文件作为实例化参数，
	 * 	这个文件可以是File对象，也可以是文件路径字符串。
	 * @date: 2020年4月29日 下午5:07:05
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutputStream fileOutputStream;
		
		try {
			fileOutputStream = new FileOutputStream("E:\\test.txt");
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			bufferedOutputStream.write("BufferedOutputStream测试数据写入".getBytes());
			bufferedOutputStream.close();
			fileOutputStream.close();
			System.out.println("------");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
