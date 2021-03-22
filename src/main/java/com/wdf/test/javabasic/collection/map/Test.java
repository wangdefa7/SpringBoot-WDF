package com.wdf.test.javabasic.collection.map;

import java.util.HashMap;

/**
 * 测试实现情况
 */
public class Test {
    private HashMap<String,Object >  map = new HashMap<>();

    public static void main(String[] args) {
        Test test = new Test();
        test.testMap();
    }

    public  void testMap(){
        String a = "a";
        map.put("a",a);
        System.out.println(map.get("a"));
        a = "b";
        System.out.println(map.get("a"));

        Entity b = new Entity("b");
        map.put("b",b);
        System.out.println(map.get("b").toString());
        b.setName("c");
        System.out.println(map.get("b").toString());

    }

    class Entity{
        private String name;

        public  Entity(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }
}
