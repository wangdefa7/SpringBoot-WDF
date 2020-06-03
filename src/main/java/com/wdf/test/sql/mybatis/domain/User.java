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
	private String perms;
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
	public String getPerms() {
		return perms;
	}
	public void setPerms(String perms) {
		this.perms = perms;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", perms=" + perms + "]";
	}
	
}