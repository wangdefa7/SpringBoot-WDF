package com.wdf.test.javabasic.String;

/**
 * @ClassName: Zifu
 * @Author WDF
 * @Description 测试 & || 等关键字符
 * @Date 2021/1/6 10:32
 * @Copyright Dareway 2021/1/6
 * @Version 1.0
 **/
public class Zifu {

    public static void main(String[] args) {
        qudizhifu_alone();
    }

    /**
     * @Author WDF
     * @Description 单个取地址符的运算
     * 1&0:0
     * 2&0:0
     * 1&1:1
     * 1&2:0
     * @Date 2021/1/6 10:34
     * @Param []
     * @return void
     **/
    public static  void qudizhifu_alone(){
        int a = 1;
        int b = 2;
        System.out.println("1&0:" + (a & 0));
        System.out.println("2&0:" + (b & 0));
        System.out.println("1&1:" + (a & 1));
        System.out.println("1&2:" + (a & 2));
    }
}
