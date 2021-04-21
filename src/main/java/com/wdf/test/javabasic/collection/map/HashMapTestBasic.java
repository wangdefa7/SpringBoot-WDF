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
        main.testMap1();
    }

    private void testMap1() {
        Map map = new HashMap<>();
        map.put("a","a");
        Map map2 = new HashMap<>();
        map2 = (Map) map.get("data");
        System.out.println(map2);

    }
}
