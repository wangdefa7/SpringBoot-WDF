package com.wdf.test.javabasic.collection.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *                 当多个线程同时检测到总数量超过门限值的时候就会同时调用resize操作，各自生成新的数组并rehash后赋给该map底层的数组table，
 *                 结果最终只有最后一个线程生成的新数组被赋给table变量，其他线程的均会丢失。而且当某些线程已经完成赋值而其他线程刚开始的时候，
 *                 就会用已经被赋值的table作为原始数组，这样也会有问题。
 */
public class HashMapTest {

    //public static final HashMap<String, String> firstHashMap = new HashMap<String, String>();
    public static final ConcurrentHashMap<String,String> firstHashMap = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {
        //测试map的并发问题
        concurrent();
    }

    public static void concurrent() throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 250; i++) {
                    firstHashMap.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int j = 250; j < 500; j++) {
                    firstHashMap.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };
        t1.start();
        t2.start();
        Thread.sleep(1000);
        for (int l = 0; l < 500; l++) {
            //System.out.println(String.valueOf(l) + ":" + firstHashMap.get(String.valueOf(l)));
            if (!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))) {
                System.out.println(l + ":" + firstHashMap.get(String.valueOf(l)));
            }
        }
    }
}
