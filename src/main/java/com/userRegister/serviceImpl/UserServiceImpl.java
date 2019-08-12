package com.userRegister.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRegister.mapper.UserMapper;
import com.userRegister.pojo.User;
import com.userRegister.service.UserService;

/** 
* @author 钟忠: 
* @version 创建时间：2019年8月12日 下午10:45:14 
* 类说明service层 userService实现类
*/
@Service
public class UserServiceImpl implements UserService {
   @Autowired
	private UserMapper userMapper;
//	@Override
//	public void addUser(User user) {
//		// TODO Auto-generated method stub
//
//	}

//	@Override
//	public List<User> findUsers(int page, int rows) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/*
	 *查询登录用户
	 */
	@Override
	public User selectUserOne(String code, String password) {		
		return userMapper.selectUserOne(code, password);
	}

}
