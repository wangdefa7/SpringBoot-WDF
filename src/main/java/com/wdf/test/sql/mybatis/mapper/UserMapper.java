package com.wdf.test.sql.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wdf.test.sql.mybatis.domain.User;
/**
 * 
 * @Package: com.wdf.test.sql.mybatis.mapper
 * @ClassName: UserMapper
 * @Description: mybatis的mapper接口文件
 * @author: WDF
 * @date: 2020年6月2日 下午4:12:08
 * @version: V1.0
 */
@Mapper
public interface UserMapper {

	List<User> select();
	
	int insert();
	
	User selectByName(String name);
	
	int update(User user);
	
	int delete(User user);
	
	/**
	 * 
	 * @Title: selectPerms
	 * @author: WDF
	 * @Description: 查询权限
	 * @date: 2020年6月3日 上午11:29:12
	 * @param id
	 * @return
	 */
	List<String> selectPerms(String id);
}
