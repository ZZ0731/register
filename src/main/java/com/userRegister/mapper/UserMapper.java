package com.userRegister.mapper;

import com.userRegister.pojo.User;

/** 
 * @author 钟忠: 
 * @version 创建时间：2019年8月12日 下午11:16:42 
 * 类说明DAO层 mapper接口和UserMapper文件对应
 */
public interface UserMapper {
	public User selectUserOne(String code,String password);
}