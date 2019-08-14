<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<link rel="stylesheet" type="text/css"  href=${pageContext.request.contextPath}/css/register.css >
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		
		<title>ZZ登录系统</title>
	</head>
	<body>			
<div class="wrap" id="wrap">
	<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
			</div>
			<!-- 输入框 -->		
			<form  id="userLogin" action=${pageContext.request.contextPath}/check  target="_self" method="post">
			<div class="lgD">
				<img src=${pageContext.request.contextPath}/img/logName.jpg width="20" height="20" alt=""/>
				<input type="text" name="uname" placeholder="输入用户名"  v-model="uname"/>
			</div>
			
			<div class="lgD">
			<img src=${pageContext.request.contextPath}/img/logPwd.jpg width="20" height="20" alt=""/>			
				<input type="password" name="upassword" placeholder="输入用户密码" v-model="upassword"/>
			</div>
			
			<div class="logC">
			<input :class="compClass" type="submit" value="登 录"  :disabled="!uname||!upassword">				
			</div>	
			
			<!-- 	<c:forEach items="${pageContext.request.cookies}" var="c">  
			<c:out value="${c.name}"/>	
			<c:out value="${c.value}"/>	
					<c:if test="${c.name eq 'message'  } " var="f">
					 <p>账户或密码错误!</p>					  
					 </c:if>
					<c:out value="${f}"/>	 								  				
				</c:forEach> -->			
				<%			
				for(Cookie cookie:request.getCookies()){
					if("message".equals(cookie.getName())){
						if("1".equals(cookie.getValue())){
							%>
							<span>账户或密码错误!</span>
							<%
						}
						//删除cookie					
						 cookie = new Cookie("message", "");  
						// 新建Cookie  
						cookie.setMaxAge(0);                            // 
						//设置生命周期为0，不能为负数  
						response.addCookie(cookie); 
						break;
					}
				}
				%>								
			</form> 
		</div>
</div>
	<!-- vue -->
		<script src=${pageContext.request.contextPath}/jsp/registerVue.js></script>
	<!-- end -->
	</body>
</html>