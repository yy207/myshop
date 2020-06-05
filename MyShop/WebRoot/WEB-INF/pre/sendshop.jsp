<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/leftcommon.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/easyui.css"> 
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/demo.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.easyui.min.js"></script>
	 	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/sendshop.css">
		<style type="text/css">
			li { margin: 5px 0; }
		</style>
	</head>
	<body> 
		
		
			<!-- 标题 -->
		<%@ include file="common/shop_bg.jsp" %> 
					
		<div class="sec">
			<!-- left -->
			<%@ include file="common/shop_left.jsp" %>
			<!-- right -->
			<div class="right_sec">
				<div class="right_title">
					我的位置>物流管理
				</div>
				 
				<div class="table"> 
					<div class="ul">
						<div class="shop-information">
							<div class="main">
								<div class="easyui-tabs" style="width:880px; border: 0px ;min-height: 500px;">
									<div title="待发货" style="padding:10px;" >
										 <ul>
										 <li> 
										 		<div class="order" style=""> 
										 			 	<div class="order_code">
										 					<span>序号</span>  
										 					订单号
											 			</div>
											 			<div class="order_name">
															创建时间
											 			</div>
											 			<div class="order_send">
															请输入物流单号		
											 			</div>
											 			<div class="order_btn">
											 				操作
											 			</div> 
										 		</div> 
										 	</li>
										 	<c:forEach var="order" items="${orderList2 }" varStatus="i">
										 	<li> 
										 		<div class="order" style=""> 
										 			<form action="${pageContext.request.contextPath }/pre/shop/update" method="get">
										 				
										 				<div class="order_code">
										 					<span class="no">${i.index }</span>
										 					<input type="hidden" name="id" id="id" value="${order.id }" />
											 				${order.orderCode }
											 			</div>
											 			<div class="order_name"> 
											 				${fn:substring(order.createTime,0,19)}
											 			</div>
											 			<div class="order_send">
											 				<input type="text" name="logidtics" id="logidtics" pattern="\d{16,20}" required value="" placeholder="请输入物流单号"/>
											 			</div>
											 			<div class="order_btn">
											 				<input type="submit" name="" id="" value="确认发货" />
											 			</div>
										 			</form>
										 		</div> 
										 	</li>
										 	</c:forEach> 
										 </ul> 
									</div>
									<div title="已发货" style="padding:10px" >
										 <ul>
										 	<li> 
										 		<div class="order" style=""> 
										 			 	<div class="order_code">
										 					<span>序号</span>  
										 					订单号
											 			</div>
											 			<div class="order_name">
															创建时间
											 			</div>
											 			<div class="order_send">
															物流单号		
											 			</div>
											 			<div class="order_btn">
											 				操作
											 			</div> 
										 		</div> 
										 	</li>
										 	<c:forEach var="order" items="${orderList3  }" varStatus="i">
										 	<li>
										 		<div class="order" style=""> 
										 			<form action="${pageContext.request.contextPath }/pre/shop/update" method="get">
										 				
										 				<div class="order_code">
										 					<input type="hidden" name="id" id="id" value="${order.id }" />
											 				<span class="no">${i.index }</span>
										 					${order.orderCode }
											 			</div>
											 			<div class="order_name">
											 				${fn:substring(order.createTime,0,19)}
											 			</div>
											 			<div class="order_send">
											 				${order.logidtics }
											 			</div>
											 			<div class="order_btn">
											 				<!-- <input type="submit" name="" id="" value="确认发货" /> -->
											 				<a href="" style="color: #000;text-decoration: none;">查看详情</a>
											 			</div>
										 			</form>
										 		</div> 
										 	</li>
										 	</c:forEach> 
										 </ul>
									</div>
								</div>  
							</div>  
                        </div>    
			        </div>
				</div>
					
			</div>
				
				
				
				
				
				
			</div>
			
			
			
		</div>
		
		
		
		
		
		
		
		 <script type="text/javascript" src="${pageContext.request.contextPath }/static/ckeditor/ckeditor.js"></script> 

		
		
		
		
	</body>
</html>
