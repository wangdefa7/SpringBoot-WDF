package com.wdf.test.javabasic.reflectClass.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author WDF
 * @Description 方法注解，加在方法上面
 * @Date 2021/1/14 13:28
 * @Param
 * @return
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestMethodAnnotation {

    String name() default "long";
    String data();
    int age() default 27;
}


