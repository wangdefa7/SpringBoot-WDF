package com.wdf.test.javabasic.http.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdf.test.javabasic.http.client.User;

/**
 * 
 * @Package: com.wdf.test.javabasic.http.server
 * @ClassName: ServerController
 * @Description: 测试httpClient
 * @author: WDF
 * @date: 2020年5月6日 上午9:43:09
 * @version: V1.0
 */
@Controller
public class ServerController {
	
	public String msg = "wdf";
	
	/**
	 * 
	 * @Title: doGetControllerOne
	 * @author: WDF
	 * @Description: get无参请求的测试
	 * @date: 2020年5月6日 上午9:49:39
	 * @return
	 */
	@RequestMapping("/doGetControllerOne")
	@ResponseBody
	public String doGetControllerOne(){
		System.out.println("进入 doGetControllerOne");
		return msg;
	}
	
	/**
	 * 
	 * @Title: doGetControllerTwo
	 * @author: WDF
	 * @Description: get有参数请求测试
	 * @date: 2020年5月6日 上午9:49:59
	 * @return
	 */
	@RequestMapping("/doGetControllerTwo")
	@ResponseBody
	public String doGetControllerTwo(String name,String age){
		System.out.println("进入 doGetControllerTwo");
		System.out.println("name:"+name+" age: "+age);
		return msg+":"+name+age;
	}
	
	/**
	 * 
	 * @Title: doPostControllerOne
	 * @author: WDF
	 * @Description: post的无参数测试
	 * @date: 2020年5月6日 上午10:18:09
	 * @return
	 */
	@RequestMapping(value = "/doPostControllerOne",method = RequestMethod.POST)
	@ResponseBody
	public String doPostControllerOne() {
		System.out.println("进入  doPostControllerOne");
		return msg;
	}
	
	/**
	 * 
	 * @Title: doPostControllerOne
	 * @author: WDF
	 * @Description: post有参测试请求
	 * @date: 2020年5月6日 上午10:16:45
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/doPostControllerThree", method = RequestMethod.POST)
	@ResponseBody
	public String doPostControllerThree(@RequestBody User user,Integer flag, String meaning) {
		System.out.println("doPostControllerOne");
		System.out.println("flag:"+flag+" meaning:"+meaning);
		System.out.println(user.toString());
		return msg+user.toString();
	}

}
