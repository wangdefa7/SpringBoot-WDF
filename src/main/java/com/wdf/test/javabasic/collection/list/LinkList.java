package com.wdf.test.javabasic.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: LinkList
 * @Author WDF
 * @Description //TODO
 * @Date 2021/4/4 13:35
 * @Copyright Dareway 2021/4/4
 * @Version 1.0
 **/
public class LinkList {

    private List list1 = new LinkedList();
    private List list2 = new ArrayList();

    public static void main(String[] args) {
        LinkList main = new LinkList();
        main.testBasicFunction();

    }

    private void testBasicFunction() {
        list1.add("1");
        list1.get(0);
        list2.add("2");
        list2.get(0);
    }
}
