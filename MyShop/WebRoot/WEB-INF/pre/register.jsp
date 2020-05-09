<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>MyShop 用户注册</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" /> 
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/register.css" /> 
</head> 
<body>  
		<!--Begin Header Begin-->
		<%@ include file="common/nav.jsp" %>
		<!--End Header End-->  
		<!--Begin Login Begin-->
		<div class="register">	
			<div class="img">
				<img class="img" src="${pageContext.request.contextPath }/static/img/bb_ban.jpg" />
			</div>  
    	
			<div class="form" >
				<div class="title">
					<h2 class="s20">欢迎注册新用户 &nbsp;&nbsp;&nbsp;&nbsp;</h2><span><a href="${pageContext.request.contextPath }/pre/login">我要登陆</a></span>
				</div>
				<form id="register" name="register" action="${pageContext.request.contextPath }/pre/registe" method="post"
					enctype="multipart/form-data" onsubmit="return fun_pre_register()">
					<table border="0" width="600px" height="500px">
					  <input type="hidden" value="3" id="userRole" name="userRole" required="required"/>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
						<td class="input">
							<input type="text" id="userCode" name="userCode"
								onblur="fun_userCode()" required="required" value="${user.userCode }" class="l_user" /> 	 	 
						</td>
						<td class="msg"><span id="userCodeMsg"></span></td>
					</tr>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
						<td class="input">
								<input class="l_pwd" type="password" id="userPassword" name="userPassword"
							required="required" onblur="fun_userPassword()" 
							value="${user.userPassword}" />
						</td>
						<td class="msg"><span id="userPasswordMsg"></td>
					</tr>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
						<td class="input">
								<input type="password"  class="l_pwd"
			                	type="password" id="userRePassword" name="userRePassword"
								required="required" onblur="fun_reUserPassword()" 
								value="" />
						</td>
						<td class="msg"><span  id="userRePasswordMsg" ></span></td>
					</tr>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>真实姓名 &nbsp;</td>
						<td class="input">
							<input type="text"  class="l_mem" type="text" id="realName" name="realName"
								onblur="fun_realName()" required="required"	 value="${user.realName}" />	
						</td>
						<td class="msg"><span id="realNameMsg"></span></td>
					</tr>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>身份证号 &nbsp;</td>
						<td class="input">
							<input type="text" class="l_num"   id="idCard" name="idCard" 
								required onblur="fun_idCard()"
								value="${user.idCard}" />
						</td>
						<td class="msg"><span id="idCardMsg"></span></td>
					</tr>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
						<td class="input">
								<input type="text" id="email" name="email" onblur="fun_email()"
									value="${user.email }" class="l_email" required/>
						</td>
						<td class="msg"><span id="emailMsg"></span></td>
					</tr>
					<tr>
						<td class="label" align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
						<td class="input">
								<input type="text" id="phone" name="phone" onblur="fun_phone()"
									required  value="${user.phone }"class="l_tel" />
						 </td>
						<td class="msg"><span id="phoneMsg"> </span></td>
					</tr>
					<tr>
                    	<td class="label" align="right"> <font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>
						<td class="input" > 
							 <input type="text" style="width: 100px;display: inline-block;vertical-align: middle;" name="imageCode" class="l_ipt" required/>
							   <input type="image" style="vertical-align: middle;" id="imageCode"  src="<%=request.getContextPath() %>/image/image.do" disabled="disabled"/>
							 <a href="javascript:void(0)"  onclick="fun_image()" style="font-size:12px;vertical-align: middle; font-family:'宋体';">换一张</a>
						 </td>
						<td class="msg"><span id="imageCodeMsg">${imageCodeMsg}</span></td>
					</tr>
					<tr>
						<td class="label"></td>
						 <td class="input" style="font-size:12px; padding-top:20px;">
		                	<span style="font-family:'宋体';" class="fl">
		                    	<label class="r_rad">
		                    	<input id="checkbox" type="checkbox" /></label><label for="checkbox" class="r_txt">我已阅读并接受</label><a hre="#">《用户协议》</a>
		                    </span>
		                </td>
						<td class="msg"></td>
					</tr>
					<tr>
						<td class="label"></td>
						<td><input type="submit" value="立即注册" class="log_btn" /></td> 
					</tr> 
				</table> 
				</form> 
				<!--Begin Footer Begin-->
				<div class="foot" style="width: 500px;text-align: center;">
		        	备案/许可证编号：-1-www.dingguagua.com   Copyright © 2015-2018 All Rights Reserved. 
		     	</div>
			<!--End Footer End --> 
			</div> 
        </div>  
<!--End Login End--> 
   

</body>
   <!-- 自定义用户验证 -->
  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.11.1.min_044d0927.js"></script>
    <!-- Local userCode Scripts -->
  <script src="${pageContext.request.contextPath }/static/js/localcode.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/image.js"></script>
  
</html>
