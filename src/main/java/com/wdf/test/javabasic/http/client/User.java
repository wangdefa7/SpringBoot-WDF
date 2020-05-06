package com.wdf.test.javabasic.http.client;

/**
 * 
 * @Package: com.wdf.test.javabasic.http.client
 * @ClassName: User
 * @Description: 实体类（post方法）
 * @author: WDF
 * @date: 2020年5月6日 上午10:06:26
 * @version: V1.0
 */
public class User {
	
	private String name;
	private int age;
	private String gender;
	private String motto;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", gender=" + gender + ", motto=" + motto + "]";
	}

	
	

}
