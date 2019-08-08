package com.userRegister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
