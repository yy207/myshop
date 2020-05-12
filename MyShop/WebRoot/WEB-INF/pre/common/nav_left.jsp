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
					<a href="${pageContext.request.contextPath }/pre/index" style="color:#fff;font-size: 20px;">首页</a>
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
			<div class="m_left">
        	<div class="left_n">管理中心</div>
            <div class="left_m"> 
                <ul>
                	<li><a href="${pageContext.request.contextPath }/pre/nav/accountpage">账户中心</a></li>
                	<li><a href="${pageContext.request.contextPath }/pre/nav/orderpage#">我的订单</a> </li>
                    <li><a href="${pageContext.request.contextPath }/pre/nav/addresspage">收货地址</a></li>
                    <li><a href="${pageContext.request.contextPath }/pre/cart/cartpage">去购物车</a> </li>
                    <li><a href="${pageContext.request.contextPath }/pre/love/lovepage/2">收藏店铺</a></li> 
                    <li><a href="${pageContext.request.contextPath }/pre/love/lovepage/1">收藏宝贝</a></li>
                </ul>
            </div> 
        	</div> 
			</div> 
		<!-- nav-left end -->