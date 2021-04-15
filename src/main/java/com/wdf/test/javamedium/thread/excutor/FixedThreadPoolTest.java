package com.wdf.test.javamedium.thread.excutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: FixedThreadPoolTest
 * @Author WDF
 * @Description FixedThreadPoolTest
 * @Date 2021/4/4 16:33
 * @Copyright Dareway 2021/4/4
 * @Version 1.0
 **/
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        //Executor executor = Executors.newFixedThreadPool();//提示不安全
        //Executor executor = Executors.newFixedThreadPool(3);
        Executor executor = Executors.newCachedThreadPool();
        Runnable runnable =  () -> {
            for (int j = 0; j < 3; j++) {
                System.out.println("" + j + "--" );

            }
        };
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);


    }
}
