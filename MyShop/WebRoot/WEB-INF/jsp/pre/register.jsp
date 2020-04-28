<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/localcss/easystyle.css" />
  
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/menu.js"></script>    
    
	   
    <style type="">
    	#register tr td span[id*='Msg']{
    		color:red;
    	}
    </style>
    
<title>MyShop 用户注册</title>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou"> 
        <span class="fr"> <span class="fl">你好, 
			<c:if test="${sessionUser==null }">
				<a href="<%=request.getContextPath() %>/main/login"  style="color:#ff4e00;" >请登录</a>&nbsp; 
			</c:if>
			<c:if test="${sessionUser!=null }">
				${sessionUser.userName }
			</c:if> 
			 <a	href="<%=request.getContextPath() %>/main/register"	style="color:#ff4e00;">免费注册</a> </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="${pageContext.request.contextPath }/statics/localimg/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<!--End Header End--> 
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="${pageContext.request.contextPath }/main/index"><img src="${pageContext.request.contextPath }/statics/localimg/logo.png" /></a></div>
    </div>
	<div class="regist">
    	<div class="log_img"><img src="${pageContext.request.contextPath }/statics/localimg/l_img.png" width="611" height="425" /></div>
		<div class="reg_c">
        	<form id="register" name="register" action="${pageContext.request.contextPath }/pre/registe" method="post"
					enctype="multipart/form-data" onsubmit="return fun_pre_register()">
            <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="95">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">注册</span>
                    <span class="fr">已有商城账号，<a href="<%=request.getContextPath() %>/main/login" style="color:#ff4e00;">我要登录</a></span>
                </td>
              </tr>
              <input type="hidden" value="3" id="userRole" name="userRole" required="required"/>
              
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                <td><input type="text" id="userCode" name="userCode"
					onblur="fun_userCode()" required="required" value="${user.userCode }" class="l_user" />
					<span id="userCodeMsg"></span>
				</td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                <td><input class="l_pwd" type="password" id="userPassword" name="userPassword"
					required="required" onblur="fun_userPassword()" 
					value="${user.userPassword}" />
					<span id="userPasswordMsg"></span>
				</td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                <td><input type="password"  class="l_pwd"
                	type="password" id="userRePassword" name="userRePassword"
					required="required" onblur="fun_reUserPassword()" 
					value="" />
					<span id="userRePasswordMsg"></span>	
				</td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>真实姓名 &nbsp;</td>
                <td><input type="text"  class="l_mem" type="text" id="realName" name="realName"
					onblur="fun_realName()" required="required"	 value="${user.realName}" />
					<span id="realNameMsg"></span>
			 	</td> 
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>身份证号 &nbsp;</td>
                <td><input type="text" class="l_num"   id="idCard" name="idCard" 
					required onblur="fun_idCard()"
					value="${user.idCard}" />
					<span id="idCardMsg"></span>
				</td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                <td><input type="text" id="email" name="email" onblur="fun_email()"
					value="${user.email }" class="l_email" />
					<span id="emailMsg"></span>
				</td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                <td><input type="text" id="phone" name="phone" onblur="fun_phone()"
					required="required" 
					value="${user.phone }"class="l_tel" />
					<span id="phoneMsg"> </span>
				</td>
              </tr>
              
              <tr height="50">
                <td align="right"> <font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>
                <td>
                    <input type="text" name="imageCode" class="l_ipt" required/> 
                    <input type="image" id="imageCode"  src="<%=request.getContextPath() %>/image/image.do" disabled="disabled"/>
                   
                    <a href="javascript:void(0)" onclick="fun_image()" style="font-size:12px; font-family:'宋体';">换一张</a>
                	 <span id="imageCodeMsg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${imageCodeMsg}</span>
                </td>
              </tr>
              <tr>
              	<td>&nbsp;</td>
                <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad">
                    	<input id="checkbox"    type="checkbox" /></label><label for="checkbox" class="r_txt">我已阅读并接受<a hre=""> </label>《用户协议》</a>
                    </span>
                </td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="submit" value="立即注册" class="log_btn" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
    
    
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="${pageContext.request.contextPath }/statics/localimg/b_1.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/localimg/b_2.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/localimg/b_3.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/localimg/b_4.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/localimg/b_5.gif" width="98" height="33" /><img src="${pageContext.request.contextPath }/statics/localimg/b_6.gif" width="98" height="33" />
    </div>    	
</div>
<!--End Footer End -->    

</body>
   <!-- 自定义用户验证 -->
    <!-- Local userCode Scripts -->
    <script src="${pageContext.request.contextPath }/statics/localjs/localcode.js"></script>
    
  <script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/jquery-1.11.1.min_044d0927.js"></script>
	
  <script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/image.js"></script>
  
</html>
