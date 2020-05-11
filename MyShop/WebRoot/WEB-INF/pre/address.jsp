<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${sessionUser.userName }的收货地址</title>  
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />	
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/order.css" />		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/address.css" />
				
	</head>
	<body>
		<!-- nav -->
		<%@ include file="common/nav.jsp" %>
		<!-- nav left-->
		<%@ include file="common/nav_left.jsp" %>
		<div class="main">
				<div class="new_add">
					<div class="h1" style="padding: 10px;font-size: 18px">
								<c:if test="${address.id !=null }">
									<b>编辑收货地址</b>
								</c:if>
								<c:if test="${address.id ==null }">
									<b>添加收货地址</b>
								</c:if> 
					</div>
					<div class="table">
					  <form action="${pageContext.request.contextPath }/pre/address/add" method="post" onsubmit="return tel()">
						<table border="0" width="700" height="250">
						 
							<tr>
								<td width="100"><span>*</span>地址信息:</td>
								<td colspan="2">
									<select name="city1" id="city1" required>
										<option value="">-------</option>
									</select>
									<select name="city2" id="city2" required>
										<option value="">-------</option>
									</select>
									<select name="city3" id="city3" required>
										<option value="">-------</option>
									</select>
								 </td>
								<td class="msg" width="300"><span></span> </td>
							</tr>
							<tr>
								<td width="100"><span>*</span>详细地址:</td>
								<td colspan="2"><input type="text" name="address" id="address" value="${address.address }" required/> </td>
								<td class="msg" width="300"><span id="addressMsg">${addressMsg }</span> </td>
							</tr>
							<tr>
								<td width="100"><span>*</span>邮政编码:</td>
								<td colspan="2"><input type="text" value="000000" readonly /> </td>
								<td class="msg" width="300"><span ></span> </td>
							</tr>
							<tr>
								<td width="100"><span>*</span>收货人姓名:</td>
								<td colspan="2"><input type="text" name="name" id="name"  value="${address.name }" required/> </td>
								<td class="msg" width="300"><span id="nameMsg">${nameMsg }</span> </td>
							</tr>
							<tr>
								<td width="100"><span>*</span>手机号码:</td>
								<td >
									<select>
										<option>中国大陆+86</option>
									</select>
								</td>
								<td colspan=""><input type="tel" name="phone" id="phone" value="${address.phone }" /> </td>
								<td class="msg" width="300"><span id="phoneMsg">${phoneMsg }</span> </td>
							</tr> 
							<tr>
								<td width="100">
								</td> 
								<td colspan="2">
									<input type="checkbox" id="default" name="default" 
										<c:if test="${address.isDefault==1 }">checked</c:if> />
									<label for="default">设置为默认地址</label>
								</td> 
							</tr>
							<tr>
								<td width="100">
								</td> 
								<td width="100">
									<input type="submit" value="保存" />
								 <input type="hidden" name="id" value="${address.id }" />
								</td> 
							</tr>
						</table>
						</form>
					</div> 
				</div>
				<div class="list">
					<table border="0" width="940"  >
						<tr class="title">
							<td width="150">收货人</td>
							<td width="150">所在地区</td>
							<td width="200">详细地址</td>
							<td width="100"> 邮编</td>
							<td width="100">电话</td>
							<td width="100">操作</td>
							<td width="140"></td>
						</tr> 
						<c:forEach items="${addressList }" var="address" >
								<tr class="user_adr">
									<td width="150">${address.name }</td>
									<td width="150" class="city">
										<span>${address.c1.cityName }&nbsp;</span> 
										<span>${address.c2.cityName }</span> 
										<span>${address.c3.cityName }</span> 
									</td>
									<td width="200">${address.address }</td>
									<td width="100">0000</td>
									<td width="100">${address.phone }</td>
									<td width="100">
										<a href="${pageContext.request.contextPath }/pre/address/delete/${address.id}">删除</a> | 
										<a href="${pageContext.request.contextPath }/pre/address/update/${address.id}">修改</a>  
									</td>
									<td width="140">
										<c:if test="${address.isDefault==1 }"> 
											<span class="default" style=""> 
												默认地址
											</span>
										</c:if>
										<c:if test="${address.isDefault==0}">
											<a href="${pageContext.request.contextPath }/pre/address/default/${address.id}">设置为默认</a>	
										</c:if>
									</td>
								</tr> 
						</c:forEach>
						
						
					</table>
				</div> 
		</div> 
		
		<!-- footer -->
		<%@ include file="common/btm.jsp" %>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/city.js" ></script>
	</body>
</html>
