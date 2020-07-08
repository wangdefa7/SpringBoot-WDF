package com.wdf.test;

import org.junit.jupiter.api.Test;

/**
 * 
 * @Package: com.wdf.test
 * @ClassName: ShiroTest
 * @Description: 测试shiro 不包括springBoot的配置
 * @author: WDF
 * @date: 2020年5月22日 上午10:58:17
 * @version: V1.0
 */
public class ShiroTest {

	@Test
	void test() {
		System.out.println("环境测试");
	}
	 
	
    /**
     * 
     * @Title: testHelloworld
     * @author: WDF
     * @Description: 测试shiro权限
     * @date: 2020年5月22日 上午10:49:20
     */
/*    @Test
    public void testHelloworld() {
    	String relativelyPath=System.getProperty("user.dir")+"/src/main/resources/static/";
    	String shiroPathString = relativelyPath+"/shiro/shiro.ini";
    	System.out.println(shiroPathString);
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
    	Factory<org.apache.shiro.mgt.SecurityManager> factory = 
    			new IniSecurityManagerFactory(shiroPathString);
        //2、得到SecurityManager实例 并绑定给SecurityUtils   
    	org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
        	
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("OK");
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }*/

}
