<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${sessionUser.userName }收藏的店铺</title>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/nav.css" /> 
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/likeshop.css" />  
	</head>
	<body class="likeshop"> 
		<!-- nav -->
		<%@ include file="common/nav.jsp" %>
		<div class="header">
			<div class="list">
				<div class="head_logo">
					<a href=""><img src="${pageContext.request.contextPath }/static/img/logo.jpg" width="120" height="51" /></a>
				</div>
				<div class="a"> 
					<a href="${pageContext.request.contextPath }/pre/love/lovepage/1">宝贝收藏</a>
				</div>
				<div class="a"> 
					<a href="${pageContext.request.contextPath }/pre/love/lovepage/2">店铺收藏</a> 
				</div>
			</div>
		</div>
		<div class="shops">
			<div class="title">
				<span>全部店铺 ${fn:length(loveList) }</span>
			</div>
			<div class="lis">
			<c:forEach items="${loveList }" var="love">
				<div class="li"> 
					<div class="left_shop"> 
						<div class="img">
							<span> 
							 
						 	<a href=""><img src="${pageContext.request.contextPath }/static/img/${love.shop.picPath}" width="50" height="50" style="border-radius: 25px; border:0.5px solid #ccc;" /></a>
							</span>  
						</div> 
						<div class="name">
							 <img src="${pageContext.request.contextPath }/static/img/tm.png" width="24" height="18" /> 
							 <span><a href="">${love.shop.name }</a> 旗舰店</span>
						</div>
						<div class="del_icon">
							 <span><a href="${pageContext.request.contextPath }/pre/love/delove/${love.id}/2"><img src="${pageContext.request.contextPath }/static/img/del_gray.png" /> </a> </span>
						</div>  
						<div style="text-indent: 4em;">
							<p>粉丝数：${love.shop.liker }</p>
							<p>开业时间：${fn:substring(love.shop.createTime,0,10) }</p>
							<p>经营描述：${love.shop.describe }</p>
						</div>
					</div>
					<div class="right_shop">
						<div class="nav_shop">
							<div class="n1">
								<a href="#">进店看看</a>
							</div> 
						</div>
						<div class="goods">   
							<c:forEach items="${love.shop.goods }" var="good">
							<div class="good">
								<div class="img">
									<span>
										<a href="<%=request.getContextPath()%>/pre/goodinfo/${good.id}/${good.shop.id }"><img src="<c:if test="${fn:contains(good.picPath,'http:') }">
										${good.picPath }
									</c:if>
									<c:if test="${!fn:contains(good.picPath,'http:') }">
										${pageContext.request.contextPath }/static/img/${good.picPath }
									</c:if>" width="100" height="100" /></a>
									</span> 
								</div> 
								<div class="price">
									<span>￥88</span>
								</div>
							</div>  
							</c:forEach>
						</div>
					</div> 
				</div>  
			</c:forEach>
			</div>
		</div> 
		
	</body>
</html>
