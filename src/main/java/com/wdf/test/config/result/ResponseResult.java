package com.wdf.test.config.result;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author WDF
 * @Description
 * 1、定义一个注解@ResponseResult，表示这个接口返回的值需要包装一下
 * 2、拦截请求，判断此请求是否需要被@ResponseResult注解
 * 3、核心步骤就是实现接口ResponseBodyAdvice和@ControllerAdvice，判断是否需要包装返回值，如果需要，就把Controller接口的返回值进行重写。
 * @Date 2020/11/25 9:30
 * @Param
 * @return
 **/
@Retention(RUNTIME)
@Target({TYPE,METHOD})
@Documented
public @interface ResponseResult {
    Class<? extends Result>  value() default Result.class;

}
