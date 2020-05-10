<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/easyui.css"> 
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/demo.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/nav.css" />	
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/order.css" />		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/account.css" />
		<style type="text/css">
			/*{border: 1px solid red;} */
		</style>
	</head>
	<body>
	
		<%@ include file="common/nav.jsp" %>
		<!-- nav -->
		<%@ include file="common/nav_left.jsp" %>
		
		<div class="main">
			<div class="easyui-tabs" style="width:900px; border: 0px ;">
				<div title="个人资料" style="padding:10px" >
					<!--个人信息表单-->
					<form action="${pageContext.request.contextPath }/pre/user/userName" method="post">
					 	<table class="my_account" width="880" height="400px">
					 	<tr>
					 		<td colspan="2">亲爱的 &nbsp;${sessionUser.userName }</td>
					 	</tr>
						<tr> 
							<td>当前头像</td>
							<td><img width="100" height="100" src="${pageContext.request.contextPath }/static/img/${sessionUser.userPic}" /> </td>
						</tr>	
						<tr>
							<td>账户:</td>
							<td><label> ${sessionUser.userCode }</label></td>
						</tr> 
						<tr>
							<td>真实姓名:</td>
							<td><label> ${sessionUser.realName }</label> </td> 
						</tr>
						<tr>
							<td>昵称:</td>
							<td><input type="text" name="userName" value="${sessionUser.userName }" /> </td>
							<td><span id="userNameMsg">${userNameMsg }</span> </td>
						</tr>
						<tr>
						<!-- 	<td>居住地：</td>
							<td>
								<select>
									
								</select>
								<select>
									
								</select>
								<select>
									
								</select>
							</td> -->
						</tr>
						<tr id="f">
							<td> 
								<input  type="submit" value="保存" />
							</td>
						</tr>
					 </table>
					 </form>
				</div> 
				
				<div title="头像照片" style="padding:10px" >
					<div class="my_image">
						<form  action="${pageContext.request.contextPath }/pre/user/image" method="post" enctype="multipart/form-data">
							<div class="img_file">
								<input type="file" name="userImage" id="imgObj" onchange="readURL(this)" accept="image/jpeg,image/png"/>
								<div class="my_phone"><span id="imageMsg">${imageMsg }</span> </div>
							</div> 
							<div>
								<h3>大图预览</h3>
							</div>
							<div class="img_src"> 
								<div>
									<img src="${pageContext.request.contextPath }/static/img/${sessionUser.userPic}" id="imgId" width="200" height="200"  />
								</div>
							</div>
							<div class="submit"> 
								<input type="submit" value="保存" />
							</div>
						</form> 
					</div>	 
				</div>
				
				<div title="安全设置" style="padding:10px" >
					<div class="my_safe">
						<table class="my_basc_info" width="500">
							<tr>
								<td width="100">您的基本信息 </td>
							</tr>
							<tr>
								<td>绑定邮箱 : </td>
								<td><label>${sessionUser.email }</label> </td>
							</tr>
							<tr>
								<td>绑定手机 :</td>
								<td><label>${sessionUser.phone }</label> </td>
							</tr> 
						</table>
						<hr />
						 <table class="my_pwd" height="200">
						 	<form action="${pageContext.request.contextPath }/pre/user/pwd" method="post">
						 		<tr>
						 			<td>修改密码</td>
						 		</tr>
						 		<tr>
						 			<td width="100">原密码 ：</td>
						 			<td width="150"><input type="text" name="oldPwd" id="oldPwd" value="" /></td>
						 			<td width="200"><span id="oldPwdMsg"></span> </td>
						 		</tr>
						 		<tr>
						 			<td width="100">新密码 ：</td>
						 			<td width="150"><input type="password" name="userPassword" id="userPassword" value="" /></td>
						 			<td width="200"><span id="userPasswordMsg"></span> </td>
						 		</tr>
						 		<tr>
						 			<td width="100">确认密码 ：</td>
						 			<td width="150"><input type="password" name="userRePassword" id="userRePassword" value="" /></td>
						 			<td width="200"><span id="userRePasswordMsg">${userPasswordMsg}</span> </td>
						 		</tr>
						 		<tr>  
						 			<td><input  type="submit" value="保存" /></td>
						 			
						 		</tr>
						 	</form>
					 	</table>
					 	<hr />
						 <table class="my_phone" height="160">
						 	<form action="${pageContext.request.contextPath }/pre/user/phone" method="post">
						 		<tr>
						 			<td>修改手机</td>
						 		</tr>
						 		<tr>
						 			<td width="100">新手机 ：</td>
						 			<td width="150"><input type="text" name="phone" id="phone" value="" /></td>
						 			<td width="200"><span id="phoneMsg">${phoneMsg}</span> </td>
						 		</tr>
						 		<tr>  
						 			<td><input  type="submit" value="保存" /></td>
						 		</tr>
						 	</form>
					 	</table>
					 	<hr />
						 <table class="my_phone" height="120">
						 	<form action="${pageContext.request.contextPath }/pre/user/email" method="post">
						 		<tr>
						 			<td>修改邮箱</td>
						 		</tr>
						 		<tr>
						 			<td width="100">新邮箱 ：</td>
						 			<td width="150"><input type="text" name="email" id="email" value="" /></td>
						 			<td width="200"><span id="emailMsg">${emailMsg}</span> </td>
						 		</tr>
						 		<tr>  
						 			<td><input  type="submit" value="保存" /></td>
						 			
						 		</tr>
						 	</form>
					 	</table>
					</div>
				</div>
			</div>
		</div> 
		
		<!-- footer -->
		<%@ include file="common/btm.jsp" %>
	</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/file.js" ></script>
 