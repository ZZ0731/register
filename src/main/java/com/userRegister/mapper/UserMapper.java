package com.userRegister.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.userRegister.pojo.User;

/** 
 * @author 钟忠: 
 * @version 创建时间：2019年8月12日 下午11:16:42 
 * 类说明DAO层 mapper接口和UserMapper文件对应
 */
public interface UserMapper {
	public User selectUserOne(String code,String password);
	public List<User> selectUserPage(String parameter);
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(String id);
}
