package com.wdf.test.javabasic.collection.list;

import org.junit.jupiter.api.Test;

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

	/**
	 * @Author WDF
	 * @Description 测试arrayList的长度
	 * @Date 2021/2/20 11:06
	 * @Param []
	 * @return void
	 **/
	@Test
	public void testLen(){

		int len = 500000;//40万
		List list1 = new ArrayList();
		for (int i = 0; i < len; i++) {
			Map map = new HashMap();
			map.put("id",i+"");
			list1.add(map);
		}
		System.out.println("1");
		for (int i = 0; i < list1.size(); i++){
			System.out.println(i);
			Map map = (Map) list1.get(i);
			for (int j = 0; j < list1.size(); j++) {
				Map map2 = (Map) list1.get(i);
				if (map.get("id").equals(map2.get("id")) && map2.equals("500000")){
					System.out.println(map2);
				}
			}
		}
	}

}
