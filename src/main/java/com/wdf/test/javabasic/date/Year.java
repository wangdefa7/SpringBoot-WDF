package com.wdf.test.javabasic.date;

import java.time.LocalDate;

/**
 * @ClassName: Year
 * @Author WDF
 * @Description 年处理 闰年等
 * @Date 2021/2/5 9:50
 * @Copyright Dareway 2021/2/5
 * @Version 1.0
 **/
public class Year {

    public static void main(String[] args) {
        // 获取今年的天数
        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear);
        // 获取指定某年的天数
        int days = LocalDate.of(2011, 1, 1).lengthOfYear();
        System.out.println(days);
    }
}
