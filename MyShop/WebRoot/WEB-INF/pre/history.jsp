<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${sessionUser.userName }的足迹</title>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />
		 <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/likegood.css" />
		 <style type="text/css">
		 	.his img{
		 		width: 120px;height:51px;
		 	}
		 </style>
	</head>
	<body> 
	<!-- 引入导航 -->  
		<%@ include file="common/nav.jsp" %>
		  <!-- header -->
		<div class="header">
			<div class="list">
				<div class="head_logo his">
					<a href=""><img src="${pageContext.request.contextPath }/static/img/logo.jpg" width="120" height="51" /></a>
				</div>
				<div class="a"> 
					<a href="#">我的足迹	</a>
				</div>
				 
			</div>
		</div>
		<div class="goods" style="min-height: 500px;"> 
			 <div class="total"> 
			 	<a href="javascript:delall()">删除全部</a>
			 	<span></span>
			 </div>
			
		 		
			 
			<div class="lis" >
				<c:forEach items="${historyList }" var="history">
					<div class="li">
						<div class="img">
							<span>
								<a href="<%=request.getContextPath()%>/pre/goodinfo/${history.good.id}/${history.good.shop.id }">
								<img src="<c:if test="${fn:contains(history.good.picPath,'http:') }">${history.good.picPath }</c:if>
										  <c:if test="${!fn:contains(history.good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${history.good.picPath }</c:if>" 
										  width="148" height="148" /></a>
							</span>
							<span class="del_icon">
								<a href="${pageContext.request.contextPath }/pre/history/deletehistory/${history.id}"><img src="${pageContext.request.contextPath }/static/img/del.png" width="12" height="13" /> </a>
							</span>
							<span class="shop">
								<a href="javascript:void(0);">${history.createTime }</a>
							</span>
						</div>
						<div class="name">
							<span>
								<a href="<%=request.getContextPath()%>/pre/goodinfo/${history.good.id}/${history.good.shop.id }"> 
									<img src="${pageContext.request.contextPath }/static/img/tm.png" width="24" height="18" />${fn:substring(history.good.name,0,20) }
								</a>
							</span>
						</div>
						<div class="price">
							<span>￥${history.good.price }</span>
						</div>
					</div>  
				</c:forEach>
			</div>
		</div> 
		<%@ include file="common/btm.jsp" %>
		 <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		 	 <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/history.js" ></script>
		 	  
	</body>
</html>
