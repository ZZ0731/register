package com.userRegister.service;

import com.userRegister.pojo.User;

/** 
* @author 钟忠: 
* @version 创建时间：2019年8月12日 下午10:40:55 
* 类说明 user的service层
*/

public interface UserService {
   //添加用户
	//void addUser(User user);
	//查找登录用户
	User selectUserOne(String code,String password);
    //分页查找用户
	//List<User> findUsers(int page,int rows);
}