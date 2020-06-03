package com.wdf.test.shiro;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @Package: com.wdf.test.shiro
 * @ClassName: ShiroPageController
 * @Description: shiro页面处理
 * @author: WDF
 * @date: 2020年6月1日 下午4:56:43
 * @version: V1.0
 */
@Controller
public class ShiroPageController {

	private Logger logger = LoggerFactory.getLogger(ShiroPageController.class);
	 /**
	  * 
	  * @Title: shiro
	  * @author: WDF
	  * @Description: 一个测试页面（shiro中配置了它没有权限访问）
	  * @date: 2020年6月3日 上午10:40:13
	  * @return
	  */
    @RequestMapping("/shiro")
    public String shiro() {
        logger.info("测试shiro的权限控制，这是一个无权限的测试页面");
        return "/shiro/shiroAuthc";
    }
    
    /**
     * 
     * @Title: unAuth
     * @author: WDF
     * @Description: 未授权跳转到的提示页面
     * @date: 2020年6月3日 上午10:49:20
     * @return
     */
    @RequestMapping("/unAuth")
    public String unAuth() {
        logger.info("测试shiro的权限控制，这是一个  [未授权]  的测试页面");
        return "/shiro/unAuth";
    }
    
    /**
     * 
     * @Title: AuthTest
     * @author: WDF
     * @Description: 有权限跳转的 成功页面
     * @date: 2020年6月3日 下午1:51:05
     * @return
     */
    @RequestMapping("/AuthTest")
    public String AuthTest() {
        logger.info("测试shiro的权限控制，这是一个  [已授权]  的测试页面");
        return "/shiro/AuthTest";
    }
    
    /**
     * 
     * @Title: loginPage
     * @author: WDF
     * @Description: 登录页面
     * @date: 2020年6月3日 上午10:39:47
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage() {
    	logger.info("打开登录页面");
    	return "/login";
    }

    /**
     * 
     * @Title: login
     * @author: WDF
     * @Description:  shiro登录页面
     * @date: 2020年6月1日 下午5:13:34
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/loginMsg")
    public String login(String name,String password,Model model,HttpServletRequest request,
    		ModelMap modelMap) {
        //logger.info("测试shiro的权限控制:这是一个登录逻辑跳转到的 [登录页面]");
        
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
        	/**
        	 * 如果不抛异常则为登录成功
        	 * 
        	 * 调用login方法的时候会调用重写的doGetAuthenticationInfo方法进行登录用户的账号密码的验证。
        	 */
			subject.login(token);
			System.out.println("登录成功");
			/**
			 * Model,ModelMap的先后顺序与代码的顺序有关。
			 * HttpServletRequest的顺序要低于它们
			 */
			modelMap.addAttribute("msg","我是后台返回的数据，你已经登陆成功了-modelMap");
			model.addAttribute("msg", "我是后台返回的数据，你已经登陆成功了-Model");
			request.setAttribute("msg", "我是后台返回的数据，你已经登陆成功了-HttpServletRequest");
			
			return "/shiro/shiroLoginSuccess";
		} catch (UnknownAccountException e) {
			// 登录失败，用户不存在
			e.printStackTrace();
			logger.error("登录失败，用户不存在");
			model.addAttribute("msg", "登录失败，用户不存在");
			return "/login";
		}catch (IncorrectCredentialsException e) {
			// 登录失败，密码错误
			e.printStackTrace();
			logger.error("登录失败，密码错误");
			model.addAttribute("msg", "登录失败，密码错误");
			return "/login";
		}
    }
    

}
