package com.example.service.sys.impl;

import com.example.mapper.sys.UserMapper;
import com.example.pojo.sys.User;
import com.example.pojo.sys.UserRole;
import com.example.service.sys.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	@Transactional
	public int addUser(User user){
		boolean flag = true;
		int result = userMapper.addUser(user);
		return result;
	}

	@Override
	public UserRole getUserRoleById(Integer userId) {
		return userMapper.getUserRoleById(userId);
	}

	@Override
	public User findUserByName(String username, String password) {
		return userMapper.findUserByName(username,password);
	}

	@Override
	public List<User> getList(User user) {
		return userMapper.getList(user);
	}

	@Override
	public int getCount(User user) {
		return userMapper.getCount(user);
	}

	public List<User> findAllUser() {
		List<User> list = userMapper.getAll();
		return list;
	}


	//@Override
	//public Map<String, Object> redisMap() {
		//jedisCluster.set("user", "张三丰");
		//设置完毕，获取之
		//String value = jedisCluster.get("user");
		//Map<String, Object> maps = new HashMap<String, Object>();
		//maps.put("redis", value);
		//return maps;
	//}

}
