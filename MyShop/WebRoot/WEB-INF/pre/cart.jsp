<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/nav.css" />
	 	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/cart2.css" />
	</head>
	<body>
		<%@ include file="common/nav.jsp" %>
		 <div class="header">
		 	<div class="logo">
		 		<span><a href="${pageContext.request.contextPath }/pre/index"><img src="${pageContext.request.contextPath }/static/img/taobao_logo.gif" /></a> </span>
		 		<span style="font-size: 20px;font-weight: bolder;">购物车</span>
		 	</div>
		 	<div class="search">
		 		<form  action="${pageContext.request.contextPath }/pre/index" method="post" >
		 			<input class="text" type="text" name="name" value="" placeholder="搜索宝贝" /><input class="submit" type="submit" name="submit" value="搜索" />
		 		</form> 
		 	</div>
		 </div>
		 
		 <div class="title">
		 	<div class="p1">
		 		<span>全部商品 23</span>
		 	</div> 
		 </div>
		 
		 <div class="goods">
		 		<table border="0" cellspacing="" cellpadding="">
		 			<tr> <td width="330">商品信息</td>
		 			<td width="200">属性</td>
		 			<td width="130">单价</td> 
		 			<td width="130">数量</td> 
		 			<td width="130">金额</td> 
		 			<td width="130">操作</td>
		 		</tr>  
		 		</table>
		 		<table width="1050">  
					<c:forEach items="${cartList }" var="cart">
						<tr class="good">
							<td width="330" class="good_info">
								<!-- <span><input type="checkbox" class="good_chk" name="" id="" value="" onchange="Checked(this)" /> </span> -->
								<span><input type="checkbox" class="good_chk" name="" id="" value="" onchange="Checked(this)" /> </span>
								<span><img src="<c:if test="${fn:contains(cart.good.picPath,'http:') }">
																		${cart.good.picPath }
																	</c:if>
																	<c:if test="${!fn:contains(cart.good.picPath,'http:') }">
																		${pageContext.request.contextPath }/static/img/${cart.good.picPath }
																	</c:if>" width="80" height="80" /> </span>
								<span style="width: 180px;height: 80px;">
									<span >${cart.good.name }</span>
									<span>
										<img src="${pageContext.request.contextPath }/static/img/T1EQA5FpVgXXceOP_X-16-16.jpg"width="16" height="16" /> 
										<img src="${pageContext.request.contextPath }/static/img/T1bnR4XEBhXXcQVo..-14-16.png"width="16" height="16" /> 
										<img src="${pageContext.request.contextPath }/static/img/T1SyeXFpliXXaSQP_X-16-16.png"width="16" height="16" /> 
									</span>
								</span>
							</td>
							<td width="200" class="property">
								<!-- <span>颜色:蓝色 </span>
								<span>颜色:蓝色 </span>
								<span>颜色:蓝色 </span> -->
							</td>
							<td class="price" width="130">
								$<span id="price">${cart.good.price }</span>
							</td>
							<td class="num" width="130" >
								<input type="button" value=" - " id="jian" onclick="jian(this)" />
								<input type="number"  value="1" min="1" id="num" onblur="minValue(this)"/>
								<input type="button" value="+" id="add" onclick="add(this)"/>
							</td>
							<td class="total" width="130" >
								$<span id="total">${cart.good.price }</span>										
							</td>
							<td class="action property" width="130">
								<span><a href="">移入收藏</a> </span>
								<span><a href="">删除</a> </span>
							</td>
						</tr> 
					</c:forEach>
					
		 		</table>
		 		 <table border="0" width="1060" style="background: #E9E9E9;"height="40px" class="foot">
		 			<tr> 
		 				<td width="130">
		 					<input type="checkbox" name="" id="all" value="" />
		 					<label for="all">全选</label >
		 				</td>
		 				<td width="130"><a href="">删除 </a> </td>
		 				<td width="350"><a href="">移入收藏夹</a> </td> 
		 				<td width="130">已选<span id="total_chk">0</span> 件</td> 
		 				<td width="180">合计(不含运费):&nbsp;&nbsp;<span class="price total" id="total_price">0</span> </td> 
		 				<td width="130">
		 					<input type="button" id="" value="结算" class="final"/>
		 				</td>
		 			</tr>  
		 		</table>
		 		
		 		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		 		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/cart.js" ></script> 
		 	</div>
	</body>
</html>
