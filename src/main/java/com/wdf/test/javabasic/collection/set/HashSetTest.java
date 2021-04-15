package com.wdf.test.javabasic.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: HashSetTest
 * @Author WDF
 * @Description 测试HashSet
 * @Date 2021/3/9 13:20
 * @Copyright Dareway 2021/3/9
 * @Version 1.0
 **/
public class HashSetTest {

    public static void main(String[] args) {

        /**
         *
         * HashSet
         **/
        Set hashSet = new HashSet();
        System.out.println(hashSet.add(1));//true
        System.out.println(hashSet.add(1));//false
    }
}
