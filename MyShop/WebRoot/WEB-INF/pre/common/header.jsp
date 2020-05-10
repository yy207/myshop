<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<!--头部搜索框开始-->
		<div class="head">
			<div class="head_logo" >
				<a href="${pageContext.request.contextPath }/pre/index"><img src="${pageContext.request.contextPath }/static/img/logo.png" class="logo_img" alt="logo"/>
				</a>	
			</div>
			<div class="head_input">
				<div class="form">
					<form action="${pageContext.request.contextPath }/pre/index" method="post" >
						<div class="search"> 
							<input type="text" name="name" class="search_input"/>
						</div>
						
						<div class="button">
							<input type="submit" name="name" value="搜索" class="button_input" />
						</div>
					</form> 
				</div>
				<div class="li_a">
					<c:forEach var="cate" items="${cateList1}" begin="0" end="6"> 
							 <span class="fl"> <a href="${pageContext.request.contextPath }/pre/index?cate=${cate.id}">${cate.name }</a> </span> &nbsp; &nbsp; 
					</c:forEach>
				</div>
			</div>
			<%-- <div class="head_logo">
				<img src="${pageContext.request.contextPath }/static/img/logo.png" class="logo_img" alt="logo"/>
			</div>  --%>
			<div class="head_logo i_car">
		     <div class="car_t"><%-- <img src="${pageContext.request.contextPath }/static/img/car.png" alt="logo"/> --%> 购物车 [ <span>${fn:length(cartList)}</span> ]</div>
		        <div class="car_bg">
		        	<c:if test="${sessionUser==null }">
			        	<!--Begin 购物车未登录 Begin-->
			        	<div class="un_login">还未登录！<a href="${pageContext.request.contextPath }/pre/login" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
			            <!--End 购物车未登录 End-->
		        	</c:if>
		        	<c:if test="${sessionUser!=null }">
						<c:if test="${fn:length(cartList)>0 }">
						<!--Begin 购物车已登录 Begin-->
			            <ul class="cars">
			            	
			            		<c:forEach items="${cartList }" var="cart">
				            		<li>
					                	<div class="img"><a href="#"><img src="<c:if test="${fn:contains(cart.good.picPath,'http:') }">
																			${cart.good.picPath }
																		</c:if>
																		<c:if test="${!fn:contains(cart.good.picPath,'http:') }">
																			${pageContext.request.contextPath }/static/img/${cart.good.picPath }
																		</c:if>" width="58" height="58" /></a></div>
					                    <div class="name"><a href="<%=request.getContextPath()%>/pre/goodinfo/${cart.good.id}/${cart.good.shop.id }">${cart.good.name }</a></div>
					                    <div class="price"><font color="#ff4e00">￥${cart.good.price }</font> X1</div>
					                </li>
				            	</c:forEach>  
			            </ul>
			            <div class="price_sum"><!-- 共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span> --></div>
			            <div class="price_a"><a href="${pageContext.request.contextPath }/pre/cart/cartpage">去购物车结算</a></div>
			            <!--End 购物车已登录 End-->
			            </c:if>
			            
			            <c:if test="${fn:length(cartList)==0 }"> 
			            	<div class="un_login">
			            		<a href="#">暂时还没有添加喜爱的商品 ,先去购物吧！</a>
			            	</div>
			            </c:if>
		        	</c:if> 
		        </div>
	  		  </div> 
			</div>
		<div class="nav">
			<h2 class="nav_title " style="width: 220px;"><!-- 全部分类 --></h2>
			<ul class="nav_ul head_input">
				<li class="nav_li"> <a href="${pageContext.request.contextPath }/pre/index">首页</a> </li> |
				<li class="nav_li"> <a href="#">店铺</a> </li> | 
				<li class="nav_li"> <a href="#">折扣专场</a> </li> |
				<li class="nav_li"> <a href="#">好货中心</a></li> |
				<li class="nav_li"> <a href="#">品牌热卖</a> </li> |
				<li class="nav_li"> <a href="#">聚划算</a> </li> |
				<li class="nav_li"> <a href="#">生活便利</a> </li> 
			</ul>
			<h2 class="nav_title head_logo"></h2>
		</div>
		<!--头部搜索框结束-->
