<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<!--导航栏开始-->
		<div class="top_nav ">
			<ul class="top_nav_list_left">
				
					<c:if test="${sessionUser!=null }">
						<li class="li"> 	
						欢迎! 	<a href="${pageContext.request.contextPath }/pre/nav/accountpage">${sessionUser.userName }</a> 
						</li>
						<li class="li"><a href="${pageContext.request.contextPath }/pre/loginout ">退出</a></li>
					</c:if>
					<c:if test="${sessionUser ==null }">
						<li class="li"><a href="${pageContext.request.contextPath }/pre/login">登录</a></li> 
					</c:if>
					
				<li class="li"><a href="${pageContext.request.contextPath }/pre/register">免费注册</a></li> 
			</ul>
			 <ul class="top_nav_list_right"> 
				<li class="li">
					<a href="${pageContext.request.contextPath }/pre/index">网站首页</a>
				</li> 
				<li class="li">
					<div class="li_menu ">
						<a href="${pageContext.request.contextPath }/pre/nav/accountpage">我的淘宝<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓"/></a>
					</div> 
					<div class="li_menu_li">
						<a href="${pageContext.request.contextPath }/pre/nav/orderpage#">我的订单</a> 
					</div>  
					<div class="li_menu_li">
						<a href="${pageContext.request.contextPath }/pre/nav/addresspage">收货地址</a> 
					</div>  
				</li> 
					
				 <li class="li">
				 	<div class="li_menu">
						<a href="${pageContext.request.contextPath }/pre/cart/cartpage"> 
						<img src="${pageContext.request.contextPath }/static/img/car.png" alt="logo"/>
						购物车</a>
					</div>
				 </li>
				<li class="li">
					<div class="li_menu ">
						<a href="${pageContext.request.contextPath }/pre/love/lovepage/1"><img src="${pageContext.request.contextPath }/static/img/care.png" class="img_li" alt="↓" width="15" height="13"/>我的收藏</a>
					</div>
					<div class="li_menu_li">
						<a href="${pageContext.request.contextPath }/pre/love/lovepage/2">收藏店铺</a> 
					</div>   
					<div class="li_menu_li">
						<a href="${pageContext.request.contextPath }/pre/love/lovepage/1">收藏宝贝</a> 
					</div>   
				</li> 
				<li  class="li">
						<div class="li_menu">
						<a href="${pageContext.request.contextPath }/pre/history/historypage">我的足迹</a> 
					</div> 
					</li>
				<li class="li"> 
					<div class="li_menu ">
						<a href="#">会员中心<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓" width="10" height="5"/></a>
					</div>
					<div class="li_menu_li">
						<a href="#">我的积分</a> 
					</div>   
				</li> 
				<li class="li">
					<div class="li_menu">
						<a href="#">网址导航<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓" width="10" height="5"/></a>
					</div> 
					<div class="li_menu_li">
						<a href="${pageContext.request.contextPath }/login/login">后台管理</a> 
					</div>   
					<div class="li_menu_li">
						<a href="${pageContext.request.contextPath }/pre/shop/index">免费开店</a> 
					</div>   
				</li> 
			</ul> 
		</div>
		<!--导航栏结束-->