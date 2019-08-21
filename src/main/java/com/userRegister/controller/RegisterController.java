package com.userRegister.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.userRegister.pojo.User;
import com.userRegister.service.UserService;

/**
 *   登录
 * @author ZZ
 * 2019 08 07
 */
@RestController
public class RegisterController {
	@RequestMapping("/register")
     public String register() {	
    	 return "register";
     }
	

	@Autowired
	private UserService userServiec;
	@RequestMapping("/login")
	public Object  checkUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 Map<String,Object> result = new HashMap<String, Object>();
		String code=request.getParameter("cUsername");
		String password=request.getParameter("cPwd");
		User user =userServiec.selectUserOne(code, password);    
		if(user!=null) {
			result.put("code", 200);
            result.put("msg", "登录成功");
            result.put("token", user.getName());
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
		Page<User> page=userServiec.selectUserPage(queryParameter,pageNum,pageSize);	
		userMap.put("userPageData", page.getResult());
		userMap.put("userTotal", page.getTotal());
		return userMap;
		
	}

	@RequestMapping("/portal")
    public String registerSuccess() {	
//		@SuppressWarnings("unused")
//		List<User> userList=userServiec.selectAllUser();
		
   	 return "portal";
    }
}
