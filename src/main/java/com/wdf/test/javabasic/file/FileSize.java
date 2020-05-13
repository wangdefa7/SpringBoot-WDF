package com.wdf.test.javabasic.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileSize {
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File picture=new File("E:\\\\photo\\signature_wdf.jpg");
		BufferedImage sourceImg=ImageIO.read(new FileInputStream(picture));
		int width,height;
		width = sourceImg.getWidth();//单位是像素px
		height = sourceImg.getHeight();
		System.out.println(width+"  "+height);
	}

}
