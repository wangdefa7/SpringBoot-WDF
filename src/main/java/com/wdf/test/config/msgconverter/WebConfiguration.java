package com.wdf.test.config.msgconverter;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@Configuration
//@Order(-2147483648)
@Order(10)
public class WebConfiguration implements WebMvcConfigurer, ServletContextInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfiguration.class);


    public WebConfiguration() {
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (factory) -> {
            ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/framework/error/404");
            factory.addErrorPages(page404);
        };
    }

    @Bean
    public HttpMessageConverter json2DataObjectConverter() {
        return new JSON2DataObjectConverter();
    }

    @Bean
    public HttpMessageConverter form2DataObjectConverter() {
        return new Form2DataObjectConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.json2DataObjectConverter());
        converters.add(this.form2DataObjectConverter());
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info("onStartup--------");
    }
}
