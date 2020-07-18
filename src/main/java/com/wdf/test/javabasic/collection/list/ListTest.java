package com.wdf.test.javabasic.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Package: com.wdf.test.javabasic.collection.list
 * @ClassName: ListTest
 * @Description: List的测试
 * @author: WDF
 * @date: 2020年7月18日 下午1:21:16
 * @version: V1.0
 */
public class ListTest {
	
	public static void main(String[] args) {
		ListTest listTest  = new ListTest();
		listTest.removeElement();
	}
	
	public void removeElement() {
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			list.add(i+"");
		}
		
		for (int i = list.size()-1; i >= 0; i--) {
			System.out.println(i);
			if (list.get(i).equals("4") ||list.get(i).equals("0")) {
				list.remove(i);
			}
		}
		System.out.println("------------------");
		for (String string : list) {
			System.out.println(string);
		}
	}

}
