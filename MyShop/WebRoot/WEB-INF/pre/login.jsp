<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title> 
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/login.css" /> 
	</head>
	<body>
		<div class="logo">
			<img src="${pageContext.request.contextPath }/static/img/logo.png" />
		</div>
		<div class="bg" style="position: relative;">
			<div class="img" style="background-image: url(${pageContext.request.contextPath }/static/img/download1.jpg);"></div>
		</div> 
		
		<div class="form-field"> 
				<div class="right">
					<div class="login">
						<p class="title" id="title_pwd" onclick="changeform(1,this)">密码登录</p>
						<p class="title" id="title_email" onclick="changeform(2,this)">邮箱登录</p> 
					</div>
					<div class="form">
						<div class="form_password" id="form_password">
							<form action="" method="post">
								<div class="name">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/user.png" width="38" height="38" /> </span>
									<input type="text" name="userCode" id="userCode" value="" placeholder="请输入账号" />
								</div >
								<div class="password">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/lock.png" width="38" height="38" /> </span>
									<input type="password" name="userPassword" id="userPassword" value="" placeholder="请输入密码"/>
								</div>
								<div class="submit">
									<input type="submit" value="登录"/>
								</div>
								<div class="bottom_a">
									<span class="forget_pwd">
										<a href="">忘记密码？</a>
									</span>
									<span class="resister">
										<a href="">注册用户</a>
									</span>
								</div>
							</form>  
						</div> 
						<div class="form_email" id="form_email">
							<form action="" method="post">
								<div class="name">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/email.png" width="38" height="38" /> </span>
									<input type="text" name="userCode" id="userCode" value="" placeholder="请输入邮箱"/>
								</div >
								<div class="code">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/number.png" width="38" height="38" /> </span>
									<input type="text" name="code" id="code" value="" />
									<span>
										<a href="" class="get_code"> 获取验证码</a>
									</span>
								</div>
								<div class="submit">
									<input type="submit" value="登录"/>
								</div>
								<div class="bottom_a"> 
									<span class="resister">
										<a href="">注册用户</a>
									</span>
								</div>
							</form>  
						</div> 
					</div>
				</div>
	</div> 
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js" ></script>
		
	</body>
</html>
