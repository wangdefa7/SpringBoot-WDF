package com.wdf.test.javabasic.collection.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @Package: com.wdf.test.javabasic.collection.map
 * @ClassName: TreeMapTest
 * @Description: TreeMap测试  修改比较器
 * @author: WDF
 * @date: 2020年8月10日 下午2:02:49
 * @version: V1.0
 */
public class TreeMapTest {
	
	//public static void main(String[] args) {
	public static void main(String... b) {
		Map<String, String> map = new TreeMap<String,String>(new Comparator<String>() {
			public int compare(String a, String b) {
				//return a.compareTo(b);//a.compareTo(b)正序排列  ，反之为倒叙
				return b.compareTo(a);
			}
		});
//		map.put("a", "b");
//		map.put("b", "b");
//		map.put("c", "b");
		map.put("1", "1");
		map.put("3", "3");
		map.put("2", "2");
		System.out.println(map);
	}

}
