package com.example.mapper.sys;

import com.example.pojo.sys.User;
import com.example.pojo.sys.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	List<User> getAll();
	User findUserByName(@Param("username") String username, @Param("password") String password);
	/**分页查询*/
	List<User> getList(User user);
	/**获取数量*/
	int getCount(User user);

	/**根据用户Id查询所拥有的角色*/
	UserRole getUserRoleById(@Param("userId") Integer userId);

	int addUser(User user);
}
