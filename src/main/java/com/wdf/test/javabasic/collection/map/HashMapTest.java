package com.wdf.test.javabasic.collection.map;

import java.util.HashMap;

public class HashMapTest {

    public static final HashMap<String, String> firstHashMap = new HashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {
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
        Thread.currentThread().sleep(1000);
        for (int l = 0; l < 500; l++) {
            //System.out.println(String.valueOf(l) + ":" + firstHashMap.get(String.valueOf(l)));
            if (!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))) {
                System.out.println(String.valueOf(l) + ":" + firstHashMap.get(String.valueOf(l)));
            }
        }
    }
}
