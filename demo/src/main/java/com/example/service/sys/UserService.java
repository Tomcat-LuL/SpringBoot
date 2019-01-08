package com.example.service.sys;

import com.example.pojo.sys.User;
import com.example.pojo.sys.UserRole;

import java.util.List;


public interface UserService {
	
	/**根据接口查询所用的用户*/
	public List<User> findAllUser();
	/**分页查询*/
	List<User> getList(User user);
	/**获取数量*/
	int getCount(User user);
	/**查询用户*/
	User findUserByName(String username, String password);

	/**根据用户Id查询所拥有的角色*/
	UserRole getUserRoleById(Integer userId);

	/**添加用户*/
	int addUser(User user);
}
