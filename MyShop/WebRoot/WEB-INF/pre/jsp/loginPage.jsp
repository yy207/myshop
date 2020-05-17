<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath}/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath}/statics/css/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->
<!-- <link href="https://colorlib.com/polygon/gentelella/statics/css/animate.min.css" rel="stylesheet">
 -->
<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath}/statics/css/custom.min.css"
	rel="stylesheet">
</head>
<body class="login">
	<div>
		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form action="dologin" method="post">
						<h1>welcome login</h1>
						<div> 
							<input name="userCode" id="userCode" required type="text" class="form-control" placeholder="Username"/>
						</div>
						<div> 
							<input name="userPassword" id="userPassword" required type="password" class="form-control" placeholder="Password"/> 
						</div>
						<p style="color:red; text-align: left;">&nbsp;${error}</p>
						<div>   
							<input class="btn btn-success" value="Login " type="submit" style="margin-left:70px;" >
							<input class="btn btn-default" value="cancel" type="reset" >
						</div>  
						<div class="separator">©2020-03-07 All Rights Reserved. yy207</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>