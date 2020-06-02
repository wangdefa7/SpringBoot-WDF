package com.wdf.test.sql.mybatis.domain;
/**
 * @Package: com.wdf.test.sql.mybatis.domain
 * @ClassName: package-info
 * @Description: 
 * @author: WDF
 * @date: 2020年6月2日 下午3:59:26
 * @version: V1.0
 */

public class User {
	
	private String id;
	private String name;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}