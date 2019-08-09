<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<link rel="stylesheet" type="text/css"  href=${pageContext.request.contextPath}/css/register.css >
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
			<form action=${pageContext.request.contextPath}/jsp/show.jsp  target="_self" method="post">
			<div class="lgD">
				<img src=${pageContext.request.contextPath}/img/logName.jpg width="20" height="20" alt=""/>
				<input type="text" name="uname" placeholder="输入用户名" />
			</div>
			
			<div class="lgD">
			<img src=${pageContext.request.contextPath}/img/logPwd.jpg width="20" height="20" alt=""/>			
				<input type="password" name="upassword" placeholder="输入用户密码"/>
			</div>
			
			<div class="logC">
			<input class="submit" type="submit" value="登 录">
				<!--  <a href="index.html" target="_self"><button>登 录</button></a>-->
			</div>
			</form> 
		</div>
</div>
	</body>
</html>