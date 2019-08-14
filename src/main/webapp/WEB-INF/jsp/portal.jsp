<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<title>门户</title>
</head>
<body>
	
	   <div id="header">
	   		<%
	   		for(Cookie cookie:request.getCookies()){
				if("uname".equals(cookie.getName())){
					
						%>
						<span><%cookie.getValue();%>你好</span>
						<%
					
					//删除cookie					
					 cookie = new Cookie("uname", "");  
					// 新建Cookie  
					cookie.setMaxAge(0);                            // 
					//设置生命周期为0，不能为负数  
					response.addCookie(cookie); 
					break;
				}
			}
	   		%>
	   </div>
	
			
	
	
</body>
</html>