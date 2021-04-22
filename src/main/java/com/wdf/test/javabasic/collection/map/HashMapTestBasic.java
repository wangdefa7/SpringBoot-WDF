package com.wdf.test.javabasic.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: HashMapTestBasic
 * @Author WDF
 * @Description 基础Map测试
 * @Date 2021/4/2 14:25
 * @Copyright Dareway 2021/4/2
 * @Version 1.0
 **/
public class HashMapTestBasic {

    public static void main(String[] args) {
        HashMapTestBasic main = new HashMapTestBasic();
        //main.testMap1();
        main.testMap2();
    }

    private void testMap1() {
        Map map = new HashMap<>();
        map.put("a","a");
        Map map2 = new HashMap<>();
        map2 = (Map) map.get("data");
        System.out.println(map2);

    }

    /**
     * @Author WDF
     * @Description HashCode
     * @Date 2021/4/21 16:47
     * @Param []
     * @return void
     **/
    private void testMap2() {
       StringBuilder s1 = new StringBuilder();
       StringBuilder s2 = new StringBuilder();
       System.out.println(s1.hashCode());
       s1 = new StringBuilder();
       System.out.println(s1.hashCode());
       System.out.println(s2.hashCode());

    }

}
