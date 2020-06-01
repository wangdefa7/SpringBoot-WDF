package com.wdf.test.shiro.config;


import com.wdf.test.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 权限控制的配置
 */
@Configuration
public class ShiroConfig {

    /**
     * shiro常用的过滤器：
     * anon:例子/admins/**=anon 没有参数，表示可以匿名使用。
     * authc:例如/admins/user/**=authc表示需要认证(登录)才能使用，没有参数
     * roles：例子/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。
     * perms：例子/admins/user/**=perms[user:add:*],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
     * user:例如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //将权限的过滤器配置放到一个Map当中
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/shiro","authc");//权限访问页面


        //将配置好的权限map放入shiro的过滤器中去
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置没有权限后跳转到指定的页面
        shiroFilterFactoryBean.setLoginUrl("/loginPage");
        //shiroFilterFactoryBean.setLoginUrl("/login");
        return  shiroFilterFactoryBean;
    }

    /**
     * shiro的安全管理器。连接到realm和用户主体Subject。
     * @param userRealm
     * @return
     *
     */
    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return  defaultWebSecurityManager;
    }

    //注入Realm数据的资源 ，关联到安全管理器SecurityManager
    @Bean("userRealm")
    public UserRealm userRealm(){
        return  new UserRealm();
    }

}
