package com.wdf.test.config;

import com.wdf.test.config.result.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: InterceptorConfig
 * @Author WDF
 * @Description 拦截器
 * @Date 2020/11/25 13:30
 * @Copyright Dareway 2020/11/25
 * @Version 1.0
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        //响应结果控制拦截
        registry.addInterceptor(responseResultInterceptor).addPathPatterns(apiUri);
    }

}
