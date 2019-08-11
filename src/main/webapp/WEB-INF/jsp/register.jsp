<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form  id="userLogin" action=${pageContext.request.contextPath}/show.jsp  target="_self" method="post">
			<div class="lgD">
				<img src=${pageContext.request.contextPath}/img/logName.jpg width="20" height="20" alt=""/>
				<input type="text" name="uname" placeholder="输入用户名"  v-model="uname"/>
			</div>
			
			<div class="lgD">
			<img src=${pageContext.request.contextPath}/img/logPwd.jpg width="20" height="20" alt=""/>			
				<input type="password" name="upassword" placeholder="输入用户密码" v-model="upassword"/>
			</div>
			
			<div class="logC">
			<input v-bind:class="compClass" type="submit" value="登 录"  v-bind:disabled="!uname||!upassword">
				<!--  <a href="index.html" target="_self"><button>登 录</button></a>-->
			</div>
			</form> 
		</div>
</div>
	<!-- vue -->
		<script>
			let vm=new Vue({
				el:'#userLogin',
			data:{
				uname:"",
			    upassword:"",
				disabled:"true",
				submit:"submit",
				submitchangColor:"submitchangColor"
			   
			},
			computed:{
				<!--計算backgroundcolor-->
				compClass:function(){
				if(this.uname&&this.upassword){
					return this.submitchangColor;
				}else{
					return this.submit;
				}
				}
			}
			});
			
		</script>
	<!-- end -->
	</body>
</html>