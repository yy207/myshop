<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<!--头部搜索框开始-->
		<div class="head">
			<div class="head_logo" >
				<a href="${pageContext.request.contextPath }/main/index"><img src="${pageContext.request.contextPath }/static/img/logo.png" class="logo_img" alt="logo"/>
			</a>	
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
