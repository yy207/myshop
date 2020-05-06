<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		  <!-- nav -->
		 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/nav.css" />
		 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/likegood.css" />
	</head>
	<body> 
	
		  <!-- nav -->
		<%@ include file="common/nav.jsp" %>
		<div class="header">
			<div class="list">
				<div class="head_logo">
					<a href=""><img src="${pageContext.request.contextPath }/static/img/logo.jpg" width="120" height="51" /></a>
				</div>
				<div class="a"> 
					<a href="#">宝贝收藏</a>
				</div>
				<div class="a"> 
					<a href="#">店铺收藏</a> 
				</div>
			</div>
		</div>
		<div class="goods">
			<div class="title">
				<span>全部宝贝23</span>
			</div>
			<div class="lis">
				<div class="li">
					<div class="img">
						<span>
							<a href=""><img src="${pageContext.request.contextPath }/static/img/O1CN011WkLkmMz7dKc11O_!!47372826.jpg_220x220.jpg" width="148" height="148" /></a>
						</span>
						<span class="del_icon">
							<a href="#"><img src="${pageContext.request.contextPath }/static/img/del.png" width="12" height="13" /> </a>
						</span>
						<span class="shop">
							<a href="#">找店铺</a>
						</span>
					</div>
					<div class="name">
						<span>
							<a href=""> <img src="${pageContext.request.contextPath }/static/img/tm.png" width="24" height="18" />包包包包包包</a>
						</span>
					</div>
					<div class="price">
						<span>￥88</span>
					</div>
				</div> 
			</div>
		</div> 
		
	</body>
</html>
