<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />
		
	</head>
	<body>
		<!--导航栏开始-->
		<div class="top_nav ">
			<ul class="top_nav_list_left">
				<li class="li">
					<a href="#">登录</a></li> 
				<li class="li"><a href="#">免费注册</a></li> 
			</ul>
			 <ul class="top_nav_list_right"> 
				<li class="li">
					<a href="${pageContext.request.contextPath }/main/index">网站首页</a>
					
					
				</li> 
				<li class="li"><a href="#">我的淘宝</a></li> 
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
		<!--头部搜索框开始-->
		<div class="head">
			<div class="head_logo" >
				<img src="${pageContext.request.contextPath }/static/img/logo.png" class="logo_img" alt="logo"/>
			</div>
			<div class="head_input">
				<div class="form">
					<form action="${pageContext.request.contextPath }/main/index" method="post" >
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
							 <span class="fl"> <a href="${pageContext.request.contextPath }/main/index?cate=${cate.id}">${cate.name }</a> </span> 
					</c:forEach>
				</div>
			</div>
			<div class="head_logo">
				<img src="${pageContext.request.contextPath }/static/img/logo.png" class="logo_img" alt="logo"/>
			</div>  
		</div>
		<div class="nav">
			<h2 class="nav_title head_logo">全部分类</h2>
			<ul class="nav_ul head_input">
				<li class="nav_li"> <a href="${pageContext.request.contextPath }/main/index">首页</a> </li> 
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
		<!--中部轮播图开始-->
		<div class="main_body">
			<div class="cate_list">
				<ul class="cate_ul">
					<c:forEach var="cate" items="${cateList2}" begin="0" end="9">
						<li class="cate_li">  
							<img src="<%=request.getContextPath() %>/static/img/${cate.iconClass }" />
							<span class="fl"> <a href="${pageContext.request.contextPath }/main/index?cate=${cate.id}">${cate.name }</a> </span>
						</li>  
					</c:forEach>
				</ul>
				
			</div>
			<div class="banner">    	
	            <div class="top_slide_wrap">
	                <ul class="slide_box bxslider">
	                    <li><img src="${pageContext.request.contextPath }/static/img/ban1.jpg" width="740" height="401" /></li>
	                    <li><img src="${pageContext.request.contextPath }/static/img/ban1.jpg" width="740" height="401" /></li> 
	                    <li><img src="${pageContext.request.contextPath }/static/img/ban1.jpg" width="740" height="401" /></li> 
	                </ul>	
	                <div class="op_btns clearfix">
	                    <a href="#" class="op_btn op_prev"><span></span></a>
	                    <a href="#" class="op_btn op_next"><span></span></a>
	                </div>        
	            </div>
	      </div>
	      <div class="news">
	      	<ul>
	      		<c:forEach items="${newsList }" var="news" begin="0" end="5">
					<li>
						<a href=""><span>【${news.dataDictionary.valueName}】</span> ${news.content }</a>
					</li> 
	      		</c:forEach>
	      	</ul>
	      	<div class="info_user">
	      		<div class="">
	      			<img class="photo" src="${pageContext.request.contextPath }/static/img/b2.png"/></div>
	      		<h2>hi,您好</h2>
	      		<button class="button " onclick="javascript:location.href='index.html'">登录</button>
	      		<button class="button " onclick="javascript:location.href='index.html'">注册</button>
	      		<button class="button "  onclick="javascript:location.href='index.html'">开店</button>
	      	</div>
	      </div> 
		</div>
		<!--中部轮播图结束-->
		<!--大图开始-->
		<div class="big_img">
			<a hre=""><img src="${pageContext.request.contextPath }/static/img/n_ban.jpg" class="big_img" /></a>
		</div>
		<!--大图结束-->
		<!--左右开始-->
		<div class="shopping">
			<div class="partial">
				<h1><img class="info_img" src="${pageContext.request.contextPath }/static/img/TB1tqpnegMPMeJjy1XcXXXpppXa-148-48.png" />  <span style="font-size: 9px;color: #A9A9A9;font-weight: 400;">与品质生活不期而遇</span></h1>
				<ul class="info"> 
				<c:forEach var="good" items="${goodList1}" begin="0" end="5"> 
					<li class="info_li">
						<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }" class="info_a">
							<div class="info_img ">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
							</div>
							<div class="info_txt">
								<h3>${fn:substring(good.name,0,5)}</h3>
							<p class="p">${fn:substring(good.describe,0,12)}</p>
							</div>
						</a> 
					</li> 
				</c:forEach>
			</ul> 
			</div>
			<div class="partial">
				<h1><img class="info_img" src="${pageContext.request.contextPath }/static/img/TB1UNX2bSFRMKJjy0FhXXX.xpXa-112-46.png" />   <span style="font-size: 9px;color: #A9A9A9;font-weight: 400;">与品质生活不期而遇</span></h1>
				<ul class="info"> 
				<c:forEach var="good" items="${goodList2}" begin="0" end="5"> 
					<li class="info_li">
						<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }" class="info_a">
							<div class="info_img ">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
							</div>
							<div class="info_txt">
								<h3>${fn:substring(good.name,0,5)}</h3>
							<p class="p">${fn:substring(good.describe,0,12)}</p>
							</div>
						</a> 
					</li> 
				</c:forEach>
					 
				</ul> 
			</div> 
		</div>
		<!--左右结束-->
		<div class="shopping">
			<div class="partial">
				<h1><img class="info_img" src="${pageContext.request.contextPath }/static/img/TB1cmpCb3MPMeJjy1XdXXasrXXa-204-42.png" />  <span style="font-size: 9px;color: #A9A9A9;font-weight: 400;">与品质生活不期而遇</span></h1>
				<ul class="info"> 
				<c:forEach var="good" items="${goodList3}" begin="0" end="5"> 
					<li class="info_li">
						<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }" class="info_a">
							<div class="info_img ">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
							</div>
							<div class="info_txt">
								<h3>${fn:substring(good.name,0,5)}</h3>
							<p class="p">${fn:substring(good.describe,0,12)}</p>
							</div>
						</a> 
					</li> 
				</c:forEach>
			</ul> 
			</div>
			<div class="partial">
				<h1><img class="info_img" src="${pageContext.request.contextPath }/static/img/TB1_EXwb3oQMeJjy0FpXXcTxpXa-162-48.png" />   <span style="font-size: 9px;color: #A9A9A9;font-weight: 400;">与品质生活不期而遇</span></h1>
				<ul class="info"> 
				<c:forEach var="good" items="${goodList4}" begin="0" end="5"> 
					<li class="info_li">
						<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }" class="info_a">
							<div class="info_img ">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
							</div>
							<div class="info_txt">
								<h3>${fn:substring(good.name,0,5)}</h3>
							<p class="p">${fn:substring(good.describe,0,12)}</p>
							</div>
						</a> 
					</li> 
				</c:forEach>
					 
				</ul> 
			</div> 
		</div>
		<!--左右结束-->
		<!--大图开始-->
		<div class="big_img">
			<img src="${pageContext.request.contextPath }/static/img/mban_2.jpg" class="big_img" />
		</div>
		<!--大图结束-->
		<!-- 热卖 -->
		<div class="hot">
			<h1 class="hot_title "><img src="${pageContext.request.contextPath }/static/img/h_t.gif" /><span  style="font-size: 20px;" > 单品热卖</span></h1>
			<ul class="info"> 
				<c:forEach var="good" items="${goodList}" begin="0" end="11" > 
					<li class="info_li">
						<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }" class="info_a">
							<div class="info_img ">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
							</div>
							<div class="info_txt">
								<h3>${fn:substring(good.name,0,5)}</h3>
							<p class="p">${fn:substring(good.describe,0,12)}</p>
							<span class="s20 bold orangle">￥${good.price }</span> <span class="p">卖出${good.buyCount }件</span>
							</div>
						</a> 
					</li> 
				</c:forEach> 
				</ul>  
		</div>
		
		
		<!--大图开始-->
		<div class="big_img">
			<img src="${pageContext.request.contextPath }/static/img/TB1MDBzuUY1gK0jSZFMSuuWcVXa.jpg" class="big_img" />
		</div>
		<!--大图结束-->
		
		<div class="hot">
			<h1 class="hot_title "><img src="${pageContext.request.contextPath }/static/img/h_t.gif" /><span  style="font-size: 20px;" > 猜你喜欢</span></h1>
			<ul class="info"> 
				<c:forEach var="good" items="${likeList}" begin="0" end="11" > 
					<li class="info_li">
						<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }" class="info_a">
							<div class="info_img ">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
							</div>
							<div class="info_txt">
								<h3>${fn:substring(good.name,0,5)}</h3>
							<p class="p">${fn:substring(good.describe,0,12)}</p>
							<span class="s20 bold orangle">￥${good.price }</span> <span class="p">卖出${good.buyCount }件</span>
							</div>
						</a> 
					</li> 
				</c:forEach> 
				</ul>  
		</div>
		
		
		<div class="footer">
			<img class="footer" style="border:0px;" src="${pageContext.request.contextPath }/static/img/footer.png" /> 
		</div>
		 <!--footer-->
	<!--Begin Footer Begin --> 
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
        	<a href="#" class="b_sh1">新浪微博</a>            
        	<a href="#" class="b_sh2">腾讯微博</a>
            <p>
            服务热线：<br />
            <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="${pageContext.request.contextPath }/static/img/er.gif" width="118" height="118" /></div>
            <img src="${pageContext.request.contextPath }/static/img/ss.png" />
        </div>
    </div>    
    <div class="footer">
		<div class="btm">
			备案/许可证编号  ：-----------1-www.dingguagua.com  Copyright&copy;1号店网上超市2020 All Rights Reserved.复制必究!!!
		<br />
           		<img src="${pageContext.request.contextPath }/static/img/b_1.gif" width="98" height="33" />
				<img src="${pageContext.request.contextPath }/static/img/b_2.gif" width="98" height="33" />
				<img src="${pageContext.request.contextPath }/static/img/b_3.gif" width="98" height="33"/>
				<img src="${pageContext.request.contextPath }/static/img/b_4.gif" width="98" height="33"/>
				<img src="${pageContext.request.contextPath }/static/img/b_5.gif" width="98" height="33"/>
				<img src="${pageContext.request.contextPath }/static/img/b_6.gif" width="98" height="33"/>  
		</div>    	
    </div>
    <!--End Footer End -->  
	</body>
</html>
