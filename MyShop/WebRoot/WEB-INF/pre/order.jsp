<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${sessionUser.userName }的订单</title>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/demo.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/order.css" />  
	</head>
	<body>
		<!-- nav -->
		<%@ include file="common/nav.jsp" %>
		<!-- nav left-->
		<%@ include file="common/nav_left.jsp" %>
		 
		
		<div class="main">
			<div class="easyui-tabs" style="width:950px; border: 0px ;">
				<div title="所有订单" style="padding:10px" >
					<ul>
						<c:forEach items="${orderList }" var ="order">
						<li>
							<table border="0" cellspacing="0" cellpadding="0">
								<tr class="th">
									<td width="120px"><input type="checkbox" />${fn:substring(order.createTime,0,10)}</td> 
									<td width="300" colspan="2">订单号: ${order.orderCode } </td>
									<td width="100">${order.shop.name }<p></p> </td> 
									<td width="80px" style="text-align: center;">单价</td>
									<td width="80px" style="text-align: center;">数量</td>
									<td width="80px" style="text-align: center;">共计</td>
									<td width="90px" style="text-align: center;"><a href="" style="color: #fff;">联系卖家</a> </td>
									<td style="float: right;"><a href="${pageContext.request.contextPath }/pre/buy/orderdelete/${order.id}" style="color: #fff;">删除 <img src="${pageContext.request.contextPath }/static/img/delete.png"/> </a> </td> 
								</tr>
								<tr class="tr">
									<td width="120px"><img src="<c:if test="${fn:contains(order.good.picPath,'http:') }">
																${order.good.picPath }
															</c:if>
															<c:if test="${!fn:contains(order.good.picPath,'http:') }">
																${pageContext.request.contextPath }/static/img/${order.good.picPath }
															</c:if>" width="100px" height="100px" /> </td>
									<td width="400px" colspan="3" style="text-align: left;">${order.good.name } </td>
									<td width="80px" style="text-align: center;">￥${order.good.price } </td>
									<td width="80px" style="text-align: center;">${order.number } </td>
									<td width="80px" style="text-align: center;">${order.price } </td>
									<td width="90px">
										<c:if test="${order.state ==3 }"> 
											<span><a href="">查看物流</a> </span>	 
										</c:if> 
										<span><a href="">订单详情</a> </span> 
									</td>
									<td width="90px">
										<c:if test="${order.state ==1 }">
												<span class="default"><a href="${pageContext.request.contextPath }/pre/buy/orderbuy/${order.id}">去付款</a> </span>
												<span><a href="">取消订单</a> </span>	
										</c:if>
										<c:if test="${order.state ==2 }"> 
												<span><a href="">催卖家发货</a> </span>	
												<span><a href="">取消订单</a> </span>
										</c:if>
										<c:if test="${order.state ==3 }"> 
												<span><a href="javascript:sendShop(${order.id },${order.logidtics });">确认收货</a> </span> 
												<span><a href="">联系退货</a> </span>
										</c:if>
										<c:if test="${order.state ==4 }"> 
												<span><a href="#">去评论</a> </span>
										</c:if>
										<c:if test="${order.state ==5 }">
											<span><a href="${pageContext.request.contextPath }/pre/buy/orderdelete/${order.id}">删除记录</a> </span>	
										</c:if> 
									</td>
								</tr> 
							</table> 
						</li> 
						</c:forEach>
					</ul>
				</div>
				<div title="待付款" style="padding:10px">
					<ul>
						<c:forEach items="${orderList }" var ="order">
							<c:if test="${order.state== 1 }">
								<li>
									<table border="0" cellspacing="0" cellpadding="0">
										<tr class="th">
											<td width="120px"><input type="checkbox" />${fn:substring(order.createTime,0,10)}</td> 
											<td width="300" colspan="2">订单号: ${order.orderCode } </td>
											<td width="100">${order.shop.name }<p></p> </td> 
											<td width="80px" style="text-align: center;">单价</td>
											<td width="80px" style="text-align: center;">数量</td>
											<td width="80px" style="text-align: center;">共计</td>
											<td width="90px" style="text-align: center;"><a href="" style="color: #fff;">联系卖家</a> </td>
											<td style="float: right;"><a href="${pageContext.request.contextPath }/pre/buy/orderdelee/${order.id}" style="color: #fff;">删除 <img src="${pageContext.request.contextPath }/static/img/delete.png"/> </a> </td> 
										</tr>
										<tr class="tr">
											<td width="120px"><img src="<c:if test="${fn:contains(order.good.picPath,'http:') }">
																${order.good.picPath }
															</c:if>
															<c:if test="${!fn:contains(order.good.picPath,'http:') }">
																${pageContext.request.contextPath }/static/img/${order.good.picPath }
															</c:if>" width="100px" height="100px" /> </td>
											<td width="400px" colspan="3" style="text-align: left;">${order.good.name } </td>
											<td width="80px" style="text-align: center;">￥${order.good.price } </td>
											<td width="80px" style="text-align: center;">${order.number } </td>
											<td width="80px" style="text-align: center;">${order.price } </td>
											<td width="90px"> 
												<span><a href="">订单详情</a> </span>	
											</td>
											<td width="90px">
												<span class="default"><a href="${pageContext.request.contextPath }/pre/buy/orderbuy/${order.id}">去付款</a> </span>
												<span><a href="">取消订单</a> </span>	
											</td>
										</tr> 
									</table> 
								</li>
							</c:if> 
						</c:forEach> 
					 </ul>
				</div>
				<div title="待发货" style="padding:10px">
					<ul>
						<c:forEach items="${orderList }" var ="order">
							<c:if test="${order.state== 2 }">
								<li>
									<table border="0" cellspacing="0" cellpadding="0">
										<tr class="th">
											<td width="120px"><input type="checkbox" />${fn:substring(order.createTime,0,10)}</td> 
											<td width="300" colspan="2">订单号: ${order.orderCode } </td>
											<td width="100">${order.shop.name }<p></p> </td> 
											<td width="80px" style="text-align: center;">单价</td>
											<td width="80px" style="text-align: center;">数量</td>
											<td width="80px" style="text-align: center;">共计</td>
											<td width="90px" style="text-align: center;"><a href="" style="color: #fff;">联系卖家</a> </td>
											<td style="float: right;"><a href="${pageContext.request.contextPath }/pre/buy/orderdelete/${order.id}" style="color: #fff;">删除 <img src="${pageContext.request.contextPath }/static/img/delete.png"/> </a> </td> 
										</tr>
										<tr class="tr">
											<td width="120px"><img src="<c:if test="${fn:contains(order.good.picPath,'http:') }">
																${order.good.picPath }
															</c:if>
															<c:if test="${!fn:contains(order.good.picPath,'http:') }">
																${pageContext.request.contextPath }/static/img/${order.good.picPath }
															</c:if>" width="100px" height="100px" /> </td>
											<td width="400px" colspan="3" style="text-align: left;">${order.good.name } </td>
											<td width="80px" style="text-align: center;">￥${order.good.price } </td>
											<td width="80px" style="text-align: center;">${order.number } </td>
											<td width="80px" style="text-align: center;">${order.price } </td>
											<td width="90px"> 
												<span><a href="">订单详情</a> </span>	
											</td>
											<td width="90px"> 
												<span><a href="">催卖家发货</a> </span>	
												<span><a href="">取消订单</a> </span>
												</td>
										</tr> 
									</table> 
								</li>
							</c:if> 
						</c:forEach> 
					 </ul>
					</ul>
				</div>
				
				<div title="待收货" style="padding:10px">
					<ul>
						<c:forEach items="${orderList }" var ="order">
							<c:if test="${order.state== 3 }">
								<li>
									<table border="0" cellspacing="0" cellpadding="0">
										<tr class="th">
											<td width="120px"><input type="checkbox" />${fn:substring(order.createTime,0,10)}</td> 
											<td width="300" colspan="2">订单号: ${order.orderCode } </td>
											<td width="100">${order.shop.name }<p></p> </td> 
											<td width="80px" style="text-align: center;">单价</td>
											<td width="80px" style="text-align: center;">数量</td>
											<td width="80px" style="text-align: center;">共计</td>
											<td width="90px" style="text-align: center;"><a href="" style="color: #fff;">联系卖家</a> </td>
											<td style="float: right;"><a href="${pageContext.request.contextPath }/pre/buy/orderdelete/${order.id}" style="color: #fff;">删除 <img src="${pageContext.request.contextPath }/static/img/delete.png"/> </a> </td> 
										</tr>
										<tr class="tr">
											<td width="120px"><img src="<c:if test="${fn:contains(order.good.picPath,'http:') }">
																${order.good.picPath }
															</c:if>
															<c:if test="${!fn:contains(order.good.picPath,'http:') }">
																${pageContext.request.contextPath }/static/img/${order.good.picPath }
															</c:if>" width="100px" height="100px" /> </td>
											<td width="400px" colspan="3" style="text-align: left;">${order.good.name } </td>
											<td width="80px" style="text-align: center;">￥${order.good.price } </td>
											<td width="80px" style="text-align: center;">${order.number } </td>
											<td width="80px" style="text-align: center;">${order.price } </td>
											<td width="90px">
												<span><a href="">查看物流</a> </span>	
												<span><a href="">订单详情</a> </span>	
											</td>
											<td width="90px">
												<span><a href="javascript:sendShop(${order.id },${order.logidtics });">确认收货</a> </span> 
												<span><a href="">联系退货</a> </span>
												</td>
										</tr> 
									</table> 
								</li>
							</c:if> 
						</c:forEach> 
					 </ul>
					</ul>
				</div>
				<div title="待评价" style="padding:10px">
					<ul>
						<c:forEach items="${orderList }" var ="order">
							<c:if test="${order.state== 4 }">
								<li>
									<table border="0" cellspacing="0" cellpadding="0">
										<tr class="th">
											<td width="120px"><input type="checkbox" />${fn:substring(order.createTime,0,10)}</td> 
											<td width="300" colspan="2">订单号: ${order.orderCode } </td>
											<td width="100">${order.shop.name }<p></p> </td> 
											<td width="80px" style="text-align: center;">单价</td>
											<td width="80px" style="text-align: center;">数量</td>
											<td width="80px" style="text-align: center;">共计</td>
											<td width="90px" style="text-align: center;"><a href="" style="color: #fff;">联系卖家</a> </td>
											<td style="float: right;"><a href="${pageContext.request.contextPath }/pre/buy/orderdelete/${order.id}" style="color: #fff;">删除 <img src="${pageContext.request.contextPath }/static/img/delete.png"/> </a> </td> 
										</tr>
										<tr class="tr">
											<td width="120px"><img src="<c:if test="${fn:contains(order.good.picPath,'http:') }">
																${order.good.picPath }
															</c:if>
															<c:if test="${!fn:contains(order.good.picPath,'http:') }">
																${pageContext.request.contextPath }/static/img/${order.good.picPath }
															</c:if>" width="100px" height="100px" /> </td>
											<td width="400px" colspan="3" style="text-align: left;">${order.good.name } </td>
											<td width="80px" style="text-align: center;">￥${order.good.price } </td>
											<td width="80px" style="text-align: center;">${order.number } </td>
											<td width="80px" style="text-align: center;">${order.price } </td>
											<td width="90px"> 
												<span><a href="">订单详情</a> </span>	
											</td>
											<td width="90px">
												<span><a href="#">去评论</a> </span>  
										</tr> 
									</table> 
								</li>
							</c:if> 
						</c:forEach> 
					 </ul>
					</ul>
				</div>
			</div>
		</div>
		<!-- footer -->
		<%@ include file="common/btm.jsp" %>
		<script type="text/javascript">
			function sendShop(oid,logidtics){ 
				 
					if(oid!=null){
						$.ajax({
						type:"GET",
						url:"/MyShop/pre/shop/receipt?id="+oid+"&logidtics="+logidtics,
						data:null,
						dataType:"text",
						success:function(dataresult){
							if(dataresult=="true"){
								alert("操作成功！");
								location.reload();
							}else{
								alert("操作失败！");
							}  
						},
						error:function(dataresult){
							alert("后台数据请求错误,请联系管理员解决！");
						} 
					});
					} 
					
			}
		</script>
	</body>
</html>
