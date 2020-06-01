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
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.easyui.min.js"></script>
	 	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/sendgood.css">
		
	</head>
	<body> 
		
		<div class="bg">
			<div class="mid">
				<div class="sale">
					卖家工作台
				</div>
				<div class="info">
					<div class="img">
						<img src="img/b1.png" width="35" height="35" />
					</div>
					<div class="name">
						测试店铺001
					</div>
				</div>
			</div>
		</div>		
					
					
		<div class="sec">
			<div class="left_sec">
				<div class="left_title">
					全部分类
				</div>
				<div class="dl">
					<dl>
						<dt><a href="">店铺管理</a> </dt>
						<dd><a href="">基本信息</a> </dd>
						<dd><a href="">店铺留言</a> </dd>	 
					</dl>
				</div>  
				<div class="dl">
					<dl>
						<dt><a href="">商品管理</a> </dt>
						<dd><a href="">发布宝贝</a> </dd>
						<dd><a href="">出售中的宝贝</a> </dd>	
						<dd><a href="">已卖出的宝贝</a> </dd>
						<dd><a href="">评价管理</a> </dd>
					</dl>
				</div>  
				<div class="dl">
					<dl>
						<dt><a href="">订单管理</a> </dt>
						<dd><a href="">发货</a> </dd> 
						<dd><a href="">物流查看</a> </dd> 
						<dd><a href="">已卖出的宝贝</a> </dd>
						<dd><a href="">评价管理</a> </dd>
					</dl>
				</div>  
			</div>
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
										 			<form action="" method="post">
										 				
										 				<div class="order_code">
										 					<input type="hidden" name="" id="" value="" />
											 				123456789
											 			</div>
											 			<div class="order_name">
											 				发货人
											 			</div>
											 			<div class="order_send">
											 				<input type="text" name="" id="" pattern="\d{16,20}" required value="请输入物流单号" />
											 			</div>
											 			<div class="order_btn">
											 				<input type="submit" name="" id="" value="确认发货" />
											 			</div>
										 			</form>
										 		</div>
										 		
										 	</li>
										 </ul> 
									</div>
									<div title="已发货" style="padding:10px" >
										 <ul>
										 	<li>
										 		<div class="order" style=""> 
										 			<form action="" method="post">
										 				
										 				<div class="order_code">
										 					<input type="hidden" name="" id="" value="" />
											 				123456789
											 			</div>
											 			<div class="order_name">
											 				发货人
											 			</div>
											 			<div class="order_send">
											 				<input type="text" name="" id="" required value="物流单号" readonly/>
											 			</div>
											 			<div class="order_btn">
											 				<input type="submit" name="" id="" value="查看详情" />
											 			</div>
										 			</form>
										 		</div>
										 		
										 	</li>
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
