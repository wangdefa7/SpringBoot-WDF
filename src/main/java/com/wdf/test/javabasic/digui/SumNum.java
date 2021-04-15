package com.wdf.test.javabasic.digui;

/**
 * @ClassName: SumNum
 * @Author WDF
 * @Description 递归求和
 * @Date 2021/2/7 16:45
 * @Copyright Dareway 2021/2/7
 * @Version 1.0
 **/
public class SumNum {
    public static void main(String[] args) {
        System.out.println(new SumNum().sum(3));
    }

    public int sum(int num){
        if (num == 0){
            return num;
        }
        return num + sum(num - 1);
    }
}
