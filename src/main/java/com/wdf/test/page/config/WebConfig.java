package com.wdf.test.page.config;



import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

/**
 * 配置web路径文件访问的配置类
 */


public class WebConfig extends WebMvcAutoConfiguration {

    // 实现  addResourceHandlers 方法添加对静态资源访问的路径
/*
    public void  addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/")
//                .addResourceLocations("classpath:/resources/")

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/")
                .resourceChain(false)
                .addResolver(new WebJarsResourceResolver())
                .addResolver(new PathResourceResolver());;
        super.addResourceHandlers(registry);
    }
*/

}
