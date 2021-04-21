package com.wdf.test.javabasic.date;

import java.util.Date;

/**
 * @ClassName: TimeMillesTest
 * @Author WDF
 * @Description 精确的时间
 * @Date 2021/4/21 13:45
 * @Copyright Dareway 2021/4/21
 * @Version 1.0
 **/
public class TimeMillesTest {
    public static void main(String[] args) {
        TimeMillesTest main = new TimeMillesTest();
        main.testMilles();
    }

    /**
     * System.currentTimeMillis(); 而不是 new Date().getTime()。
     * 说明：如果想获取更加精确的纳秒级时间值，使用 System.nanoTime 的方式。
     **/
    private void testMilles(){
        long sys = System.currentTimeMillis();
        long date = new Date().getTime();
        //纳秒
        long nano =System.nanoTime();
        System.out.println(sys);
        System.out.println(date);
        System.out.println(nano);
    }
}
