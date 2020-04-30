<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <!-- nav -->
<%@ include file="common/nav.jsp" %>
  <!-- header -->
<%@ include file="common/header.jsp" %>
  
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
		
<%@ include file="common/footer.jsp" %>
