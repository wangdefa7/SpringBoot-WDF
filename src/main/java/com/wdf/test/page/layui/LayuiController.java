package com.wdf.test.page.layui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: LayuiController
 * @Description: layui和使用webjars路径引入的示例
 * @Auther: WDF
 * @Date: 2020/4/1511:36
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/layui")
public class LayuiController {
    Logger log = LoggerFactory.getLogger(LayuiController.class);

    @RequestMapping("/layuiPage")
    public ModelAndView layuiPage(){
        log.info("进入layui界面");
        ModelAndView modelAndView = new ModelAndView("/layui/layui_webjars");
        return modelAndView;
    }
    
    @RequestMapping("/getImg")
    @ResponseBody
    public byte[] getImg(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	System.out.println(request.getParameter("id"));
    	String path = "static\\img\\beautiful.jpg";
    	String relativelyPath=System.getProperty("user.dir");//获得相对路劲 D:\Project\SpringTools\SpringBoot-Test
    	path = relativelyPath+"\\src\\main\\resources\\"+path;
    	System.out.println(path);
/*    	FileImageInputStream inputStream = new FileImageInputStream(new File(path));
    	int fileLength = Integer.parseInt(String.valueOf(inputStream.length()));
    	//System.out.println(inputStream.read());
    	System.out.println(inputStream.length());//文件大小
    	//System.out.println(inputStream.readInt());
    	byte[] bytes = new byte[fileLength];
    	inputStream.read(bytes,0,fileLength);//数据读入byte
    	System.out.println(bytes.length);*/

    	//方法 二 yonng'liu
    	FileInputStream inputStream2 = new FileInputStream(path);
    	System.out.println(inputStream2.available());//文件大小，用于创建指定的byte[]数组
    	byte[] bytes2 = new byte[inputStream2.available()];
    	try {
			inputStream2.read(bytes2, 0, inputStream2.available());
			log.info("输入完毕[{}]",path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bytes2;
    }
}
