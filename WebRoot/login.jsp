<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
body {
	font-family: 微软雅黑;
	background-image: url("Image/background.jpg");
}

#login-form {
	margin-top: 265px;
	margin-left: 690px;
	width: 520px;
	height: 325px;
	background-image: url("Image/background2.jpg");
}

#login-form label {
	font-size: 20px;
	display: inline-block;
	width: 100px;
	text-align: center;
	font-size: 9px;
	color: white;
}

#login-form input {
	height: 20px;
	margin-top: 10px;
}

#btn {
	position: absolute;
	margin-top: 210px;
	margin-left: 220px;
}

#lab {
	position: absolute;
	margin-top: 100px;
	margin-left: 190px;
}

#imgs {
	position: absolute;
	margin-top: 12px;
	width: 60px;
	height: 20px;
}
</style>
</head>

<body>
	<div id="login-form">
		<form action="login" method="post" name="login">
			<div id="lab">
				<label id="lable1">用户名：</label> <input type="text"
					name="student.sid" id="username" /><br> <label
					id="label2">密码:</label> <input type="password"
					name="student.password" id="password" /><br>
			</div>
			<div id="btn">
				<button type="submit" name="btn-login" id="btn-login"
					onClick="IMG1_onclick2()">登录</button>
				<button type="button" name="btn-register" id="btn-register"
					onclick="location.href = 'register.html'">注册</button>
			</div>
		</form>
	</div>

</body>

</html>
