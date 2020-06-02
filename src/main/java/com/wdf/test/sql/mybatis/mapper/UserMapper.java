package com.wdf.test.sql.mybatis.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
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
@Repository
public interface UserMapper {

	public List<User> Select();
	
	public int insert();
	
	public User selectByName(String name);
	
	public int update(User user);
	
	public int delete(User user);
}
