package com.userRegister.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	/*
	 *查询登录用户
	 */
	@Override
	public User selectUserOne(String code, String password) {		
		return userMapper.selectUserOne(code, password);
	}


	/*
	 * 分页查找用户
	 */
	@Override
	public Page<User> selectUserPage(String queryParameter, int pageNum, int pageSize) {
		Page<User> page=PageHelper.startPage(pageNum, pageSize);
		//userMapper.selectUserPage(queryParameter);	
		//add 2019 08 28
		int count=userMapper.queryUserCount(queryParameter);
		if(count>0) {
			List<User> listuser= userMapper.queryUserPage(queryParameter,(pageNum-1)*pageSize,pageSize);	                 			
			page.addAll(listuser);
			page.setTotal(count);
		}
		//end
		return page;
	}

	/**
	 * 新增用户
	 */
	@Override
	public int addUser(User user) {		
		return userMapper.addUser(user);
	}

	/**
	 * 修改用户
	 */
	@Override
	public int updateUser(User user) {		
		return userMapper.updateUser(user);
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteUser(String id) {
		return userMapper.deleteUser(id);
	}


}
