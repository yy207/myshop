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
					<a href="${pageContext.request.contextPath }/main/index">网站首页</a>
					
					
				</li> 
				<li class="li"><a href="${pageContext.request.contextPath }/pre/nav/orderpage">我的淘宝</a></li> 
				<li class="li">
					<div class="li_menu ">
						<a href="#">购物车<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓"/></a>
					</div>
				</li>
				<li class="li">
					<div class="li_menu ">
						<a href="#">我的收藏<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓"/></a>
					</div>
					<div class="li_menu_li">
						<a href="#">收藏店铺</a> 
					</div>   
					<div class="li_menu_li">
						<a href="#">收藏商品</a> 
					</div>   
				</li> 
				<li class="li"> 
					<div class="li_menu ">
						<a href="#">会员中心<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓"/></a>
					</div>
					<div class="li_menu_li">
						<a href="#">我的积分</a> 
					</div>   
				</li>
				<li class="li">
					<div class="li_menu">
						<a href="#">辅助功能<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓"/></a>
					</div>  
					<div class="li_menu_li">
						<a href="#">浏览记录</a> 
					</div>  
					</li>
				<li class="li">
					<div class="li_menu">
						<a href="#">网址导航<img src="${pageContext.request.contextPath }/static/img/d_arrow.png" class="img_li" alt="↓"/></a>
					</div>  
				</li>
				</li>
			</ul> 
		</div>
		<!--导航栏结束-->