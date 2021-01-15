package com.wdf.test.javabasic.reflectClass.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @ClassName: GetAnnotationTest
 * @Author WDF
 * @Description //TODO
 * @Date 2021/1/14 13:08
 * @Copyright Dareway 2021/1/14
 * @Version 1.0
 **/
@Slf4j
@TestClassAnnotation(key = "key",value = "value")
public class GetAnnotationTest {

    @TestFieldAdnnotation(value = {1, 2})
    public String fieldInfo = "FiledInfo";

    @TestFieldAdnnotation(value = {10086})
    public int i = 100;

    @TestMethodAnnotation(name = "BlueBird", data = "Big")
    public static String getMethodInfo() {
        return GetAnnotationTest.class.getSimpleName();
    }


    //类中存在这样的注释，则使用java.lang.Class类的getAnnotation()方法来获取指定注释类型的注释。该方法以对象的形式返回该类。
    //
    //用法:
    //
    //public T getAnnotation(Class<T> annotationClass)
    //参数：此方法接受参数注释类，它是要获取的注释的类型。
    //
    //
    //返回值：此方法返回注释类的指定对象。
    public static void main(String[] args) {

        Class a = GetAnnotationTest.class;
        System.out.println("类名：" + a.toString());
        System.out.println("Slf4j:" + a.getAnnotation(Slf4j.class));
        System.out.println("TestAnnotation:" + a.getAnnotation(TestClassAnnotation.class));
        new GetAnnotationTest()._testRuntimeAnnotation();
    }


    /**
     * 测试运行时注解
     */
    private void _testRuntimeAnnotation() {
        StringBuffer sb = new StringBuffer();
        Class<?> cls = GetAnnotationTest.class;
        Constructor<?>[] constructors = cls.getConstructors();
        // 获取指定类型的注解
        sb.append("Class注解：").append("\n");
        TestClassAnnotation classInfo = cls.getAnnotation(TestClassAnnotation.class);
        if (classInfo != null) {
            sb.append(Modifier.toString(cls.getModifiers())).append(" ")
                    .append(cls.getSimpleName()).append("\n");
            sb.append("注解值: ").append(classInfo.value()).append("\n\n");
        }

        sb.append("Field注解：").append("\n");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            TestFieldAdnnotation fieldInfo = field.getAnnotation(TestFieldAdnnotation.class);
            if (fieldInfo != null) {
                //java.lang.Class.getModifiers() 返回这个类活接口的修饰符，
                //返回类型是一个整数，public int getModifiers()，该数字代表的就是Java虚拟机的常数如public, protected, private, final, static, abstract 和 interface等;
                sb.append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ")
                        .append(field.getName()).append("\n");
                sb.append("注解值: ").append(Arrays.toString(fieldInfo.value())).append("\n\n");
            }
        }

        sb.append("Method注解：").append("\n");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            TestMethodAnnotation methodInfo = method.getAnnotation(TestMethodAnnotation.class);
            if (methodInfo != null) {
                sb.append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("\n");
                sb.append("注解值: ").append("\n");
                sb.append("name: ").append(methodInfo.name()).append("\n");
                sb.append("data: ").append(methodInfo.data()).append("\n");
                sb.append("age: ").append(methodInfo.age()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
