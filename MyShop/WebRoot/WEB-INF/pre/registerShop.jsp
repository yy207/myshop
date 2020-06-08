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
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/shop.css" />
	</head>
	<body> 
		<!-- 标题 -->
		<%@ include file="common/shop_bg.jsp" %> 
					
		<div class="sec">
			<!-- left -->
			<%@ include file="common/shop_left.jsp" %>
			<!-- right -->
			<div class="right_sec">
				 
				 <div class="a">
				 	<a href="${pageContext.request.contextPath }/pre/shop/register">您还未注册店铺,点击链接跳转至注册页面！</a>
				 </div>
				 
			</div> 
		</div> 
		
		 <script type="text/javascript" src="${pageContext.request.contextPath }/static/ckeditor/ckeditor.js"></script> 
		 <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/city.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/shop.js" ></script>
		

		
		
		
	</body>
</html>
