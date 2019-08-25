package com.userRegister.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.userRegister.pojo.User;
import com.userRegister.service.UserService;

/**
 *   登录
 * @author ZZ
 * 2019 08 07
 */
@RestController
public class RegisterController {
	final static Logger logger = LoggerFactory.getLogger("RegisterController.class"); 
	@RequestMapping("/register")
	public String register() {	
		return "register";
	}


	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public Object  checkUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> result = new HashMap<String, Object>();
		String code=request.getParameter("cUsername");
		String password=request.getParameter("cPwd");
		User user =userService.selectUserOne(code, password);    
		if(user!=null) {
			result.put("code", 200);
			result.put("msg", "登录成功");
			result.put("token", user.getName());
			result.put("userid", user.getId());
			return result;			
		}else {
			result.put("code", 500);
			result.put("msg", "账户或密码错误！");
			return result;

		}

	}
	/*分页查询
	 */
	@RequestMapping(value="/queryUserPage",method=RequestMethod.POST)
	public Map<String,Object> queryUserPage(HttpServletRequest request,HttpServletResponse response){

		String queryParameter=request.getParameter("queryParameter")==null?"":request.getParameter("queryParameter");
		int pageNum=request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));
		int pageSize=request.getParameter("pageSize")==null?10:Integer.parseInt(request.getParameter("pageSize"));
		Map<String,Object> userMap=new HashMap<String,Object>();
		Page<User> page=userService.selectUserPage(queryParameter,pageNum,pageSize);	
		userMap.put("userPageData", page.getResult());
		userMap.put("userTotal", page.getTotal());
		return userMap;

	}
	/*
	 * 新增用户
	 */
	@SuppressWarnings("finally")
	@RequestMapping("/add")
	public Object addUser(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> result = new HashMap<String, Object>();
		String msgCode="200";
		try {
			User user=new User();	
			String code =request.getParameter("code")==null||"".equals(request.getParameter("code").trim())?"":request.getParameter("code");
			String name =request.getParameter("name")==null||"".equals(request.getParameter("name").trim())?"":request.getParameter("name");
			String address =request.getParameter("address")==null||"".equals(request.getParameter("address").trim())?"":request.getParameter("address");
			String pass =request.getParameter("pass")==null||"".equals(request.getParameter("pass").trim())?"":request.getParameter("pass");
			String age =request.getParameter("age")==null||"".equals(request.getParameter("age").trim())?"":request.getParameter("age");
			String sex =request.getParameter("sex")==null||"".equals(request.getParameter("sex").trim())?"":request.getParameter("sex");
			String creator =request.getParameter("creator")==null||"".equals(request.getParameter("creator").trim())?"":request.getParameter("creator");
			Date create_date =new Date();
			user.setAddress(address);
			user.setAge(age);
			user.setCode(code);
			user.setCreate_date(create_date);
			user.setName(name);
			user.setPassword(pass);
			user.setSex(sex);	
			user.setSex(creator);	
			int i=userService.addUser(user);
			if(i!=1) {
				msgCode="500";
			}
		}catch(Exception e) {
			msgCode="500";
			logger.error(e.getMessage());
		}finally {
			result.put("msgCode",msgCode);	
			return result;
		}

	}
	/**
	 * 修改用户
	 * @return Object
	 */
	@SuppressWarnings("finally")
	@RequestMapping("/update")
	public Object updateUser(HttpServletRequest request,HttpServletResponse response) {	
		Map<String,Object> result = new HashMap<String, Object>();
		String msgCode="200";
		try {
			User user=new User();	
			String code =request.getParameter("code")==null||"".equals(request.getParameter("code").trim())?"":request.getParameter("code");
			String name =request.getParameter("name")==null||"".equals(request.getParameter("name").trim())?"":request.getParameter("name");
			String address =request.getParameter("address")==null||"".equals(request.getParameter("address").trim())?"":request.getParameter("address");
			String pass =request.getParameter("pass")==null||"".equals(request.getParameter("pass").trim())?"":request.getParameter("pass");
			String age =request.getParameter("age")==null||"".equals(request.getParameter("age").trim())?"":request.getParameter("age");
			String sex =request.getParameter("sex")==null||"".equals(request.getParameter("sex").trim())?"":request.getParameter("sex");		
			if(request.getParameter("id")==null||"".equals(request.getParameter("id").trim())) {
				throw new Exception("未找到用户id");
			}else {
				user.setId(Integer.parseInt(request.getParameter("id")));	
			}			
			user.setAddress(address);
			user.setAge(age);
			user.setCode(code);			
			user.setName(name);
			user.setPassword(pass);
			user.setSex(sex);				
			int i=userService.updateUser(user);
			if(i!=1) {
				msgCode="500";
			}
		}catch(Exception e) {
			msgCode="500";
			logger.error(e.getMessage());
		}finally {
			result.put("msgCode",msgCode);	
			return result;
		}
	}
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @return Object
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value="/delete" ,method=RequestMethod.GET)
	public Object deleteUser(HttpServletRequest request,HttpServletResponse response) {	
		Map<String,Object> result = new HashMap<String, Object>();
		String msgCode="200";
		try {					
			if(request.getParameter("id")==null||"".equals(request.getParameter("id").trim())) {
				throw new Exception("未找到用户id");
			}else {
				int i=userService.deleteUser(request.getParameter("id"));
				if(i!=1) {
					msgCode="500";
				}	
			}		
		}catch(Exception e) {
			msgCode="500";
			logger.error(e.getMessage());
		}finally {
			result.put("msgCode",msgCode);	
			return result;
		}
	}
	@RequestMapping("/portal")
	public String registerSuccess() {	
		//		@SuppressWarnings("unused")
		//		List<User> userList=userServiec.selectAllUser();

		return "portal";
	}
}
