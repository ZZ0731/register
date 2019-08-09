package com.userRegister.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @author 钟忠: 
 * @version 创建时间：2019年8月8日 下午9:54:32 
 * 类说明：全局捕获异常类 
 */
@ControllerAdvice(basePackages="com.userRegister.controller")
public class GlobalExceptionHandler {
	   // 日志记录工具
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/*
	 * @ResponseBody 返回json格式	
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String,Object> exceptionHandle(Exception e) {
		 logger.error("Exception", e);
		Map<String,Object> exception=new HashMap<String,Object>();			
		 exception.put("errorMsg",e.toString());
		return exception;
	}
}
