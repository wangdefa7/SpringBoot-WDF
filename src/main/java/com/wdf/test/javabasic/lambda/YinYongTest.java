package com.wdf.test.javabasic.lambda;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: YinYongTest
 * @Author WDF
 * @Description 两个冒号表示引用
 * @Date 2021/4/26 15:02
 * @Copyright Dareway 2021/4/26
 * @Version 1.0
 **/
public class YinYongTest {

    /**
     * 方法引用通过方法的名字来指向一个方法。
     *
     * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
     *
     * 方法引用使用一对冒号 :: 。
     **/
    public static void main(String[] args) {
        YinYongTest main = new YinYongTest();
        main.test1();
    }

    /**
     * @Author WDF
     * @Description  System.out::println 方法作为静态方法来引用。
     * @Date 2021/4/26 15:04 
     * @Param []
     * @return void
     **/
    public void test1(){
        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
