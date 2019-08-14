package com.userRegister.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	public void checkUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("uname");
		String password=request.getParameter("upassword");
		User user =userServiec.selectUserOne(code, password);
		Cookie namecookie = new Cookie("uname", "");
		Cookie messagecookie = new Cookie("message","");
		if(user!=null) {
			//request.setAttribute("uname",user.getName());
			namecookie.setValue(user.getName()==null?"":user.getName());
			response.addCookie(namecookie);
			response.sendRedirect("/portal");
			
		}else {
			messagecookie.setValue("1");
			response.addCookie(messagecookie);
			//request.setAttribute("message","1");
			response.sendRedirect("/register");
		}
		
	}
	
	@RequestMapping("/portal")
    public String registerSuccess() {	
   	 return "portal";
    }
}
