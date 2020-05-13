package com.wdf.test.page.photo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @Package: com.wdf.test.page.photo
 * @ClassName: PhotoController
 * @Description:  照片的处理类
 * @author: WDF
 * @date: 2020年5月12日 上午11:31:15
 * @version: V1.0
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {
	
	/**
	 * 
	 * @Title: openPhotoCropPage
	 * @author: WDF
	 * @Description: 打开图片放大缩小的页面
	 * @date: 2020年5月12日 上午11:34:15
	 * @return
	 */
	@RequestMapping("/1")
	public String openPhotoCropPage() {
		return "/photo/photo_crop";
	}
	
	/**
	 * 
	 * @Title: openPhotoPage_ruoyi
	 * @author: WDF
	 * @Description: 若依图片页面
	 * @date: 2020年5月13日 上午6:54:29
	 * @return
	 */
    @RequestMapping("/openPhotoPage_ruoyi")
    public String openPhotoPage_ruoyi(){
        System.out.println("进入openPhotoPage");
        return "/photo/photo_ruoyi";
    }

    /**
     * 
     * @Title: uploadPhoto
     * @author: WDF 
     * @Description: 若依图片上传功能
     * @date: 2020年5月13日 上午6:55:00
     * @param file
     * @return
     * @throws IOException 
     */
    @RequestMapping("/uploadPhoto_ruoyi")
    @ResponseBody
    public String uploadPhoto_ruoyi(@RequestParam MultipartFile file) throws IOException{
    	System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		InputStream inputStream = file.getInputStream();
		FileInputStream fileInputStream = (FileInputStream) inputStream;
		//inputStream = new FileInputStream();
		FileOutputStream fileOutputStream = new FileOutputStream("E:\\file.jpg");
        byte[] bytes = new byte[1024];
        int i= 0;
        while((i=inputStream.read(bytes))!=-1) {
        	fileOutputStream.write(bytes, 0, i);
        	System.out.println(bytes);
        	fileOutputStream.flush();
        	
        }
        fileOutputStream.close();
        inputStream.close();
		return file.getName()+"操作OK";
    }

	/**
	 * 
	 * @Title: uploadPhoto
	 * @author: WDF
	 * @Description: 图片上传方法
	 * @date: 2020年5月12日 下午1:16:52
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/uploadPhoto")
	@ResponseBody
	public String uploadPhoto(@RequestBody MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		InputStream inputStream = file.getInputStream();
		FileOutputStream fileOutputStream = new FileOutputStream("E:\\file.jpg");
        byte[] bytes = new byte[1024];
        int i= 0;
        while((i=inputStream.read(bytes))!=-1) {
        	fileOutputStream.write(bytes, 0, i);
        	fileOutputStream.flush();
        	
        }
        fileOutputStream.close();
        inputStream.close();
		return file.getName()+"操作OK";
	}

}
