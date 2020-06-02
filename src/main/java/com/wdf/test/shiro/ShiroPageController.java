package com.wdf.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * 测试shiro
     * @return
     */
    @RequestMapping("/shiro")
    public String shiro() {
        logger.info("测试shiro的权限控制，这是一个无权限的测试页面");
        return "/shiro/shiroAuthc";
    }
    
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
    public String login(String name,String password,Model model) {
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
			model.addAttribute("msg", "登陆成功");
			return "/shiro/shiroLoginSuccess";
		} catch (UnknownAccountException e) {
			// 登录失败，用户不存在
			e.printStackTrace();
			logger.error("登录失败，用户不存在");
			model.addAttribute("msg", "登录失败，用户不存在");
			return "/loginPage";
		}catch (IncorrectCredentialsException e) {
			// 登录失败，密码错误
			e.printStackTrace();
			logger.error("登录失败，密码错误");
			model.addAttribute("msg", "登录失败，密码错误");
			return "/loginPage";
		}
    }
    

}
