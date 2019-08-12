package com.userRegister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userRegister.pojo.User;
import com.userRegister.service.UserService;

/**
 *   登录
 * @author ZZ
 * 2019 08 07
 */
@Controller
public class RegisterController {
	@RequestMapping("/register")
     public String register() {	
    	 return "register";
     }
	
//	@Autowired
//	private UserMapper userMapper;
	@Autowired
	private UserService userServiec;
	@RequestMapping("/check")
	public String checkUser(HttpServletRequest request,HttpServletResponse response) {
		String code=request.getParameter("uname");
		String password=request.getParameter("upassword");
		User user =userServiec.selectUserOne(code, password);		
		return "show";
	}
}
