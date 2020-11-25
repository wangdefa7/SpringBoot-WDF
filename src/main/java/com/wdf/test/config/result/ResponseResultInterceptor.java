package com.wdf.test.config.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName: ResponeResultIntercepter
 * @Author WDF
 * @Description //TODO
 * @Date 2020/11/25 9:35
 * @Copyright Dareway 2020/11/25
 * @Version 1.0
 **/
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor{
    public static final String RESPONESE_RESULT_ADM = "RESPONESE_RESULT_ADM";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod= (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            //是否在类对象上加了注解
            if (clazz.isAnnotationPresent(ResponseResult.class)){
                //设置请求返回体，需要包装往下传递。在ResponseBodyAdvice接口进行判断
                request.setAttribute(RESPONESE_RESULT_ADM,clazz.getAnnotation(ResponseResult.class));
            }else if (method.isAnnotationPresent(ResponseResult.class)){//判断方法体上是否注解
                request.setAttribute(RESPONESE_RESULT_ADM,method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }

}
