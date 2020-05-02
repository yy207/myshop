<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 	<!-- header begin -->
 	<div class="header">
			<div class="p1"> 
				<div class="logo_img">
					<img class="logo_img" src="${pageContext.request.contextPath }/static/img/logo.jpg" />
				</div>
			</div>	
			<div class="p1"> 
				<div class="my white">
					<a href="${pageContext.request.contextPath }/main/index" style="color:#fff;font-size: 20px;">首页</a>
				</div>
			</div>
			<div class="p1">
				<div class="count white">
					<a href="${pageContext.request.contextPath }/pre/nav/accountpage" style="color:#fff;font-size: 20px;">账户设置</a>
				</div>
			</div> 
		</div>
		<!-- header end  -->
		<!-- nav_left begin -->
		<div class="nav_left">
			<h3>全部功能</h3>
			<ul class="nav_left_ul">
				<li class="nav_left_li">
					<div class="li_a">
						<a href="${pageContext.request.contextPath }/pre/nav/accountpage">收货地址</a> 
					</div>  
				</li>
				<li class="nav_left_li">
					<div class="li_a">
						<a href="#">我的购物车</a> 
					</div> 
				</li>
				<li class="nav_left_li">
					<div class="li_a">
						<a href="${pageContext.request.contextPath }/pre/nav/orderpage#">我的订单</a> 
					</div> 
				</li>
				<li class="nav_left_li">
					<div class="li_a">
						<a href="#">我的收藏</a> 
					</div> 
				</li>
				<li class="nav_left_li">
					<div class="li_a">
						<a href="#">我的积分</a> 
					</div> 
				</li>
				<li class="nav_left_li">
					<div class="li_a"><a href="#" >我的足迹</a>&nbsp;&nbsp;
						<img src="${pageContext.request.contextPath }/static/img/xia.png" height="5" width="10" />
					</div>
					<div class="content">
						<ul>
							<li><a href="#">我的足迹</a></li>
							<li><a href="#">我的足迹</a></li>
						</ul>
					</div>
				</li> 
			</ul> 
		</div> 
		<!-- nav-left end -->