package com.wdf.test.javabasic.diaoyong;

/**
 * 传值调用和引用调用
 * 2020/9/10 7：00
 * wdf
 */
public class DiaoYongTest {

    public static void main(String[] args) {
        int i = 1;
        StringBuffer stringBuffer = new StringBuffer("123");
        //int为基本类型为传值调用，StringBuffer为对象的引用调用，值会在无参方法改变
        test(i,stringBuffer);
        System.out.println("main-----");
        System.out.println(i +" "+stringBuffer);
        System.out.println("main-----");
        //在引用调用的过程中，没有改变原对象的值而是new了一个新对象，不会改变值
        test1(stringBuffer);
        System.out.println(stringBuffer);
    }

    public static void test(int i,StringBuffer stringBuffer){
        System.out.println("test-------");
        System.out.println(stringBuffer);
        stringBuffer.append("456");
        i++;
    }
    public static void test1(StringBuffer stringBuffer){
        stringBuffer = new StringBuffer("456");
    }
}
