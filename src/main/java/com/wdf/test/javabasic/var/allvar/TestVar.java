package com.wdf.test.javabasic.var.allvar;

/**
 * @ClassName: TestVar
 * @Author WDF
 * @Description 变量测试
 * @Date 2020/10/23 9:17
 * @Copyright Dareway 2020/10/23
 * @Version 1.0
 **/
public class TestVar {

    String a = "test";

    public static void main(String[] args) {
        TestVar testVar = new TestVar();
        //String a = a;//局部与全局变量名相同，会重新初始化

    }

    public void  test(){
        System.out.println(a);
        //String a = a;//局部与全局变量名相同，会重新初始化

    }
}
