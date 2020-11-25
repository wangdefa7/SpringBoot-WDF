package com.wdf.test.javabasic.collection.list;

import java.util.*;

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
		listTest.listIncludeMap();
	}
	
	public void removeElement() {
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			list.add(i+"a");
		}
		
		for (int i = list.size()-1; i >= 0; i--) {
			//System.out.println(i);
			if (i==4 || i==0) {
				System.out.println(list.remove(i));
			}
		}
		System.out.println("------------------");
		System.out.println(list.toString());
		/*for (String string : list) {
			System.out.println(string);
		}*/
	}

	/**
	 * @Author WDF
	 * @Description list包含map
	 * @Date 2020/11/13 9:49
	 * @Param []
	 * @return void
	 **/
	public void listIncludeMap(){
		Map map = new HashMap();
		map.put("key1","value1");
		map.put("key2","value2");
		List list = new LinkedList();
		list.add(map);
		map.clear();
		map.put("key3","value3");
		map.put("key4","value4");
		list.add(map);
		System.out.println(list.toString());
	}

}
