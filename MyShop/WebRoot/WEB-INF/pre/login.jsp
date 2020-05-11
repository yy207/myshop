<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<a href="${pageContext.request.contextPath }/pre/index"> 
				<img src="${pageContext.request.contextPath }/static/img/logo.png" width="200" height="80"/>
			</a>
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
					<div class="forms">
						<div class="form_password" id="form_password" 
								<c:if test="${display=='email' }"> style="display: none;"</c:if> >
							<form  action="${pageContext.request.contextPath}/pre/dologin" method="post">
								<div class="name">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/user.png" width="38" height="38" /> </span>
									<input name="userCode" id="userCode" value="${userCode }" required type="text"placeholder="请输入账号"/>
								</div >
								<div class="password">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/lock.png" width="38" height="38" /> </span>
									<input type="password" name="userPassword" id="userPassword" value="" placeholder="请输入密码"/>
								</div>
								<div class="submit">
									<input type="submit" value="登录"/>
								</div>
								<div class="auto">
									<input type="checkbox" name="auto" id="auto" />
									<label for="auto" style="font-size: 12px;">下次自动登录</label>
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
						<div class="form_email" id="form_email" <c:if test="${display=='email' }"> style="display: block;"</c:if> >
							<form action="${pageContext.request.contextPath}/pre/loginemail" method="post" onsubmit="return submitF()">
								<div class="name">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/email.png" width="38" height="38" /> </span>
									<input type="text" name="email" id="email" value="" placeholder="请输入邮箱" required/>
								</div >
								<div class="code">
									<span class="icon"><img src="${pageContext.request.contextPath }/static/img/number.png" width="38" height="38" /> </span>
									<input type="text" name="code" id="code" value="" required />
									<span>
										<img id="load" src="${pageContext.request.contextPath }/static/img/load.png" width="25" height="25" /> 
										<a href="javascript:sendCode();" class="get_code"> 
										 获取验证码</a>
									</span>
								</div> 			
								<div class="submit">
									<input type="submit" value="登录"/>
								</div>
								<span>${msg }</span>
								<div class="send_code">
									<img alt="" src="${pageContext.request.contextPath }/static/img/success.png" width="25" height="25" /> 
									<label for="auto" style="font-size: 12px;">验证码已发送,请注意查收</label>
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
					</div>
				</div>
	</div> 
	<div class="footer">
				<p>
					沪ICP备13044278号 | 合字B1.B2-20130004 | 营业执照
				</p>
				<p>
					Copyright &copy; 1号店网上超市2007-2016 ，AllRights Reserved
				</p>
			</div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js" ></script>
		<script type="text/javascript">
						function sendCode(){ 
							$("#load").css("display","inline-block");
							 $(".get_code").attr("href","javascript:void()");
							var email = $("#email").val();
							var u=document.getElementById("email");	
							var reg = /^\w+@\w+([\.a-zA-Z0-9]{2,3}){1,2}$/;
							if(email==null|| email==''){
								alert("请输入邮箱地址！"); 
							}else if(reg.test(email)==false){
								alert("电子邮箱格式不正确！")
							}else{ 
							$.ajax({
									type:"GET",
									url:"/MyShop/pre/sendemail",
									data:{"email":email},
									dataType:"json",
									success:function(result){   
										 if(result==true){
										 	$(".send_code").show(); 
										 	var count = 60;
											var id = setInterval(function() {
												count--;
												$(".get_code").html(count+"秒后重发");
											}, 1000)
											setTimeout(function() {
												clearInterval(id);
												$(".send_code").hide();
												$(".get_code").html("获取验证码");
											}, 60000) 
											
											$(".get_code").attr("href","javascript:sendCode()");
											$("#load").hide();
										 }else if(result==false){
										 	alert("输入的邮箱地址无效！");
										 	
											$(".get_code").attr("href","javascript:sendCode()");
											$("#load").hide();
										 }else if(result==null){
										 	alert("当前邮箱还未注册账户,请先注册！");
										 	$(".get_code").attr("href","javascript:sendCode()");
											$("#load").hide();
										 }
									},
									error:function(result){
										alert("后台数据请求错误,请联系管理员！");
										$(".get_code").attr("href","javascript:sendCode()");
										$("#load").hide();
									}
								});
							}  
							return  false;
						}
					function submitF(){
							var email = $("#email").val();
							var code = $("#code").val();
							var u=document.getElementById("email");	
							var reg = /^\w+@\w+([\.a-zA-Z0-9]{2,3}){1,2}$/;
							if(email==null|| email==''){
								alert("请输入邮箱地址！"); 
								return false;
							}
							if(reg.test(email)==false){
								alert("电子邮箱格式不正确！")
								return false;
							}
							if(code==null|| code==''){
								alert("请输入验证码！"); 
								return false;
							}
							if(!checkStr(email)){
								alert("检测到您输入了不正确的验证码,请重试！"); 
								return false;
							}
							return true;
					}
					
					
					function checkStr(str){
						$(str).each(function(num,ele){
								if(e!=null&&e!=''){
									return true;
								}
						})
						return false;
					}
					
					
					
					
					
					
					
					
					
					
			
		</script>
	</body>
</html>
