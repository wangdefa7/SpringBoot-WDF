package com.wdf.test.javabasic.lambda;

import java.util.*;

/**
 * @ClassName: LambdaTest
 * @Author WDF
 * @Description Lambda表达式的一些用法
 * @Date 2021/4/26 13:26
 * @Copyright Dareway 2021/4/26
 * @Version 1.0
 **/
public class LambdaTest {


    /**
     * @Author WDF
     * @Description 重新排序方法
     * @Date 2021/4/26 13:28
     * @Param []
     * @return void
     **/
    public void test1(){
        // 定义字符串数组
        String[] strArr = { "abc", "cd", "abce", "a" };

        // 传统方法
        // 匿名内部类
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });
        // 输出排序结果
        for (String s : strArr) {
            System.out.println(s);
        }
        System.out.println("---------------------");
        // Lambda表达式
        Arrays.sort(strArr, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        // 输出
        for (String s : strArr) {
            System.out.println(s);
        }
    }
    /**
     * @Author WDF
     * @Description 实现多线程
     * @Date 2021/4/26 13:30
     * @Param []
     * @return void
     **/
    public void  test2(){
        // Lambda表达式
        new Thread(() -> System.out.println(1 + "hello world")).start();

        System.out.println("----------------");

        // 方法体
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + "hello world");
            }
        }).start();
    }

    /**
     * @Author WDF
     * @Description 遍历集合
     * @Date 2021/4/26 13:57
     * @Param []
     * @return void
     **/
    public void test3(){
        Map<String,String> map = new HashMap();
        map.put("a","a");
        map.put("b","b");
        map.forEach((k,v)->  {
            System.out.println("k:" + k + " v:" + v);
        });

        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.forEach( object->{
            System.out.println(object);
        });
    }

    /**
     * @Author WDF
     * @Description 接口实现更简洁的表现
     * @Date 2021/4/26 14:32 
     * @Param []
     * @return void
     **/
    public void test4(){
        //实现接口的方法
        LambdaInterface b = (a) ->{
            System.out.println(a);
        };
        //调用接口
        b.doSomething(555);
    }

    interface LambdaInterface{
        void doSomething(int s);
        //void doSomething1(String s,String b);
    }

    public static void main(String[] args) {
        LambdaTest main = new LambdaTest();
        //main.test1();
        //main.test2();
        //main.test3();
        main.test4();
    }
}
