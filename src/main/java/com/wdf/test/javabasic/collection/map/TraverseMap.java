package com.wdf.test.javabasic.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 遍历map
 */
public class TraverseMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "我有一本书");
        map.put(2, "我有两本书");
        map.put(3, "我有三本书");


//第一种方法,先得到key,再通过key去获得value
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            System.out.println(integer + "的对应值为:" + map.get(integer));
        }

//第二种方法,通过map.values遍历所有的value
        for (String value : map.values()) {
            System.out.println("value:" + value);
        }

//第三种方法,遍历map entrySet,可同时拿到key和value
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }

        //第四种方法,使用Iterator迭代器和Map,entrySet
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Iterator方法的key:" + entry.getKey() + ", value:" + entry.getValue());
        }

//第五种方法为java的lambda表达式
        map.forEach((key, value) -> {
            System.out.println("lambda表达式: " + key + ":" + value);
        });
    }
}
