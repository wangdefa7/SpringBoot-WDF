package com.wdf.test.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义一个Realm类，继承AuthorizingRealm类的两个泛型方法。并实现其中的功能。
 */
public class UserRealm extends AuthorizingRealm {

    /***
     * 授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权方法执行");
        return null;
    }

    /***
     * 认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     * 
     * 进行用户登录逻辑的处理判断
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证方法执行");
        //数据库的账号密码（模拟）
        String name = "wdf";
        String password  = "wdfwdf";
        
        //将收到的用户名密码重新转换成UsernamePasswordToken类
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        
        //用户名的校验,如果用户名不一致，则返回null,subject.login方法会报UnknownAccountException异常
        if (!token.getUsername().equals(name)) {
			return null;
		}
        //进行密码的校验并返回值。这个地方的密码校验逻辑还需再深入的看一下，涉及到加密
        /**
         * 
         * 
         */
        return new SimpleAuthenticationInfo("",password,"");
    }
}
