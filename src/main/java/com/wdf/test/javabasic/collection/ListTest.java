package com.wdf.test.javabasic.collection;

import java.util.*;

public class ListTest {

	//@SupressWarnings("unchecked")
	public static void main(String[] args) {

		int len = 500000;//
		List<Map<String,String>> list1 = new ArrayList<Map<String,String>>();
		for (int i = 0; i < len; i++) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("id",i+"");
			list1.add(map);
		}
		System.out.println("1");
		for (int i = 0; i < list1.size(); i++){
			System.out.println(i);
			Map<String,String> map = (Map<String,String>) list1.get(i);
			for (int j = 0; j < list1.size(); j++) {
				Map<String,String> map2 = (Map<String,String>) list1.get(i);
				if (map.get("id").equals(map2.get("id")) && map2.equals("500000")){
					System.out.println(map2);
				}
			}
		}
	}
}