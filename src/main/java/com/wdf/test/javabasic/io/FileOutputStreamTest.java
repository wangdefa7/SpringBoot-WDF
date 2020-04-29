package com.wdf.test.javabasic.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @Package: com.wdf.test.javabasic.io
 * @ClassName: FileOutputStreamTest
 * @Description: 测试数据直接写入到文件。如果文件不存在，那么将自动创建
 * @author: WDF
 * @date: 2020年4月29日 下午5:02:08
 * @version: V1.0
 */
public class FileOutputStreamTest {
	
	/**
	 * 
	 * @Title: main
	 * @author: WDF
	 * @Description: FileOutputStream是用于写文件的输出流，所以它需要一个文件作为实例化参数，
	 * 	这个文件可以是File对象，也可以是文件路径字符串。
	 * @date: 2020年4月29日 下午5:01:05
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileOutputStream fileOutPutSream = new FileOutputStream("E:\\\\test.txt");
			fileOutPutSream.write("测试数据写入".getBytes());
			fileOutPutSream.close();
			System.out.println("end");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
