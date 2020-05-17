<style>
	.left{
	display:none;
	}
</style> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>
   
<div class="shopS001">
	<p>
		所有> ${c1.name } > ${c2.name } > <em style="color: #FF4E00;">${fn:substring(good.name,0,10)
			}</em>
	</p>
	<form action="<%=request.getContextPath()%>/pay/alipay" method="post">
		<div class="goods">
			<div class="left">
				<img class="img"
					src=" <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
						<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
				<p>
					<img class=""
						src="<%=request.getContextPath() %>/statics/localimg/r_left.png" />
					<c:forEach var="img" items="${good.images }" begin="0" end="4">
						<img class="g"
							src="<%=request.getContextPath() %>/statics/localimg/${img.path}" />
					</c:forEach>
					<img class=""
						src="<%=request.getContextPath() %>/statics/localimg/r_right.png" />
				</p>
			</div>
			<div class="center">
				<p class="p1">${fn:substring(good.name,0,12) }</p>
				<p class="p2">${fn:substring(good.describe,0,25)}</p>
				<p class="p3">
					本店价格：<span>￥${good.price }</span>
				</p>
				<%-- <p class="p4">参考价：￥${fn:substring(good.price/0.65,0,5) }</p> --%>
				<!-- <p class="p5" >尺码：
						<span class="active" >43cm </span>
						<span>45cm </span>
						<span>50cm</span>
					</p>
					<p class="p6" >颜色选择：
							<span class="active"> 粉色</span> 
							<span>白色</span>   
					</p> -->
				<p class="p7">
					<span id=""><img
						src="<%=request.getContextPath() %>/statics/localimg/sh.png" />
						分享 </span> <span> <img
						src="<%=request.getContextPath() %>/statics/localimg/care.png" />
						关注商品 </span>
				</p>
				<p class="p8">
					购买数量: <input class="num" name="number" type="number" value="1"
						max="100" min="1" step="1"> <input name="gid"
						type="hidden" value="${good.id }"> <input name="sid"
						type="hidden" value="${good.shop.id }">
				</p>
				<p class="p9">
					<%-- <button style="background-color: #FF4E00;color: #FFFFFF; font-size: 22px;" >
							<img width="20px" src="<%=request.getContextPath() %>/statics/localimg/cars_h.png" /> 
							加入购物车  
						</button> --%>
					<button
						style="background-color: #FF4E00;color: #FFFFFF; font-size: 22px;">
						<img src="<%=request.getContextPath() %>/statics/localimg/l_3.png" />
						立即购买
					</button>
				</p>
			</div>
			<div class="right">
				<a class="s" href=""> <img class="img"
					src=" <c:if test="${fn:contains(shop.picPath,'http:') }">${shop.picPath }</c:if>
						<c:if test="${!fn:contains(shop.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${shop.picPath }</c:if>" />
				</a> 
					<a href="">进入${shop.name }专区</a> 
			</div>
		</div>

	</form>
</div>

<!--左右列表-->
<div class="section0003">
	<div class="left">
		<p>
			<span style="font-size: 18px;">类似商品</span>
		</p>
		<c:forEach var="good" items="${goods }">
			<ul>
				<li><a
					href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }"><img
						class="img"
						src=" <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
						<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>" />
				</a>
				</li>
				<li><a
					href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">${good.name
						}</a>
				</li>
				<li><a
					href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">￥${good.price
						}</a>
				</li>
			</ul>
		</c:forEach>
	</div>
	<div class="right">
		<!--推荐组合-->
<%-- 	<div class="group">
			<dl>
				<dt>
					<span class="color">推荐搭配</span>
				</dt>
				<dd>
					<p>
						<img
							src="<%=request.getContextPath() %>/statics/localimg/mat_1.jpg" />
					</p>
					<p>粤通国际珠宝 999足金</p>
					<p>
						<input type="checkbox" /> ￥76
					</p>
				</dd>
				<dd>
					<img
						src="<%=request.getContextPath() %>/statics/localimg/jia_b.gif" />
				</dd>
				<dd>
					<p>
						<img
							src="<%=request.getContextPath() %>/statics/localimg/mat_2.jpg" />
					</p>
					<p>珠韵 珍珠项链</p>
					<p>
						<input type="checkbox" /> ￥1890
					</p>
				</dd>
				<dd>
					<img
						src="<%=request.getContextPath() %>/statics/localimg/jia_b.gif" />
				</dd>
				<dd>
					<p>
						<img
							src="<%=request.getContextPath() %>/statics/localimg/mat_3.jpg" />
					</p>
					<p>清新耳环</p>
					<p>
						<input type="checkbox" /> ￥232
					</p>
				</dd>
				<dd>
					<img src="<%=request.getContextPath() %>/statics/localimg/equl.gif" />
				</dd>
				<dd>
					<p id="p">套餐价 ￥2000</p>
					<p>
						<input type="number" max="10" min="1" step="1" value="1" />
					</p>
					<p>
						<input type="button" value="组合购买" />
					</p>
				</dd>
			</dl>
		</div> --%>
		<!--详情-->
		<div class="group">
			<dl>
				<dt>
					<span class="color">商品属性</span>  
				</dt>
				<dd>
					<p>商品名称：天然淡水珍珠</p>
					<p>商品毛重：160.00g</p>
					<p>镶嵌材质：纯银</p>
				</dd>

				<dd>
					<p>商品编号：1546211</p>
					<p>商品产地：法国</p>
					<p>款式：项链</p>
				</dd>

				<dd>
					<p>品牌：珠韵首饰</p>
					<p>珍珠形状：正圆</p>

				</dd>

				<dd>
					<p>上架时间：2015-06-09 09:19</p>

				</dd>
			</dl>
		</div>
		<!--详情图片资料-->
		<div class="secion001" id="details">
			<div class="center adver">
				<ul>
					<li id="no1">1</li>
					<li id ="no2">2</li>
					<li id = "no3">3</li>
					<li id="no4">4</li>
					<li id="no5">5</li>
				</ul>
				<img class="arrowLeft"
					src="<%=request.getContextPath() %>/statics/localimg/s_left.png" />
				<img class="arrowRight"
					src="<%=request.getContextPath() %>/statics/localimg/s_right.png" />
			</div>
		</div>
		<!--商品评论-->
		<div class="group">
			<dl>
				<dt
					style="border-top: #FF4E00 2px solid;color: #FF4E00;padding: 8px 20px;">商品评论</dt>
				<dd></dd>
			</dl>
		</div>

		<!-- 分页  -->
		<!-- <div class="end">
					<a href="#">上一页</a>
					<a href=""> 1	</a>
					<a href=""> 2	</a>
					<a href=""> 3	</a>···
					<a href=""> 20	</a>
					<a href="">下一页 	</a>
				</div> -->
	</div>
</div>
 
<!--footer-->
<%@ include file="common/footer.jsp"%> 
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/prejs/n_nav.js"></script> 
 		 