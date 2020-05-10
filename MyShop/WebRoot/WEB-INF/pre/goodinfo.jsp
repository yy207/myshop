<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/ui/demo.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/goodinfo.css" /> 
	</head>
<body>
		<!-- 引入导航 -->  
		<%@ include file="common/nav.jsp" %>
		  <!-- header -->
		<%@ include file="common/header.jsp" %>
		<!--商店头开始-->
		<div class="owner">
			<div class="name">
				<a href="${shop.id }">${shop.name }</a>
				<a href="">联系客服</a>
				<span class="good" style="mmargin-left: 60px;">服务4.9↑ 服务4.9↑ 服务4.9↑</span>
			</div>
			<div class="shop_info">
			</div>
			<div class="action">
				<div class="heart">
					<a  id="s_y" href="javascript:void(0);" onclick="love_add(${shop.id },2,1)" 
						<c:if test="${loveShop == 0}">style="display: inline-block;;"</c:if>> 
						<img src="${pageContext.request.contextPath }/static/img/heart_h.png" width="18px"/>
						<span>取消收藏</span>
					</a>
					<a id="s_n" href="javascript:void(0);" onclick="love_add(${shop.id },2,0)" 
						<c:if test="${loveShop !=0 }">style="display: inline-block;"</c:if>> 	
						<img src="${pageContext.request.contextPath }/static/img/heart.png" width="18px"/> 
						<span>收藏店铺</span> 
					</a>
				</div> 
			</div> 
		</div>
		<!--商店头结束-->
		<p style="margin: 0 auto;width: 1000px;">当前位置>>${c1.name }>>${c2.name }<%-- >><span style="color:red;vertical-align: middle;">${good.name }</span> --%> </p>
		<!--商品信息开始-->
		<div class="good">
			<div class="image"  >
				<div class="img_main">
					<img  src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if><c:if test="${!fn:contains(good.picPath,'http:') }">${pageContext.request.contextPath }/static/img/${good.picPath } </c:if>" width="300" height="300"/>
				</div>
				<div class="img_small">
					<div class="li">
						<c:forEach items="${imageList }" var="img" begin="0" end="3">
							<a href="">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">
										${good.picPath }
									</c:if>
									<c:if test="${!fn:contains(good.picPath,'http:') }">
										${pageContext.request.contextPath }/static/img/${good.picPath }
									</c:if>"
									 width="44" height="44" />  
							</a>   
						</c:forEach> 
					</div>
					<div class="control">
						<a href="javascript:void(0)"><img src="${pageContext.request.contextPath }/static/img/b_left.png" class="img_left" width="25" height="44" /></a>
						<a href="javascript:void(0)"><img src="${pageContext.request.contextPath }/static/img/b_right.png" class="img_right" width="25" height="44"/> </a>
					</div>
				</div>
				<div class="">
					保留说明 ${loveGood }---${loveShop }
				</div>
			</div>
			<div class="good_info">
				<form action="${pageContext.request.contextPath }/pre/buy/buypage" method="post">
					<table border="0" width="500">
						<tr><th colspan="6" style="text-align: left;">${good.name }</th></tr>
						<tr>
							<td width="100">价格</td>
							<td colspan="3" width="300"><s>￥18888</s> </td>
							<td width="50">交易 2次</td>
							<td width="50">评论 0 条</td>
						</tr>
						<tr>
							<td width="100">淘宝价</td>
							<td colspan="3"> <span class="s25">￥${good.price }</span></td> 
						</tr>
						<tr>
							<td width="100">优惠</td>
							<td colspan="">店铺折扣 8折  </td> 
						</tr>
						<tr>
							<td width="100"></td>
							<td colspan="">店铺折扣 8折 </td> 
							<td colspan="">会员折扣  6折 </td>
						</tr>
						<tr>
							<td width="100">配送</td>
							<td colspan="3">全国 免运费 </td> 
						</tr>
						<tr>
							<td></td> 
							<td>
							
							<a  id="g_y" href="javascript:void(0);" onclick="love_add(${good.id },1,1)" 
								<c:if  test="${loveGood ==0 }">style="display: inline-block;;"</c:if>> 
								<img src="${pageContext.request.contextPath }/static/img/care.png" width="16px"/>
								<span>取消收藏</span>
							</a>
							<a id="g_n" href="javascript:void(0);" onclick="love_add(${good.id },1,0)" 
								<c:if test="${loveGood !=0 }">style="display: inline-block;"</c:if>> 	
								<img src="${pageContext.request.contextPath }/static/img/heart.png" width="16px"/> 
								<span>收藏</span> 
							</a>
							</td>
							<td class="share_img">
								<a href="">分享 <img src="${pageContext.request.contextPath }/static/img/sh.png" width="16" height="13" /></a>
								<div class="share"> 
									<a href=""><img src="${pageContext.request.contextPath }/static/img/sh_1.gif" width="16" height="16" /> </a>
									<a href=""><img src="${pageContext.request.contextPath }/static/img/sh_2.gif" width="16" height="16" /> </a>
									<a href=""><img src="${pageContext.request.contextPath }/static/img/sh_3.gif" width="16" height="16" /> </a>
									<%-- <a href=""><img src="${pageContext.request.contextPath }/static/img/sh_4.gif" width="16" height="16" /> </a> --%>
								</div>
							</td>
						</tr>
						<tr>
							<td width="100">颜色分类</td>
							<td width="100"  colspan="3">
								 <img src="${pageContext.request.contextPath }/static/img/b4.png" width="40px" height="40px"/>
								 <img src="${pageContext.request.contextPath }/static/img/b4.png" width="40px" height="40px"/>
							</td>  
						</tr>
						<tr>
							<td width="100">数量</td>
							<td width="100" class="num">
								<!-- <input type="button" value=" - "/>
								<input type="number" name="number" id="number"  value="1" min="1"  />
								<input type="button" value="+" />  -->
								<input type="button" value=" - " id="" onclick="jian(this)" />
								<input type="number"  name="number"  value="1" min="1" id="num" onblur="minValue(this)"/>
								<input type="button" value="+" id="add" onclick="jia(this)"/>
							</td>
							<td>(库存233件)</td>
						</tr>
						<tr>
							<td  colspan="2" style="text-align: center;">
								<input type="hidden" name="gid" value="${good.id }"/>
								<input type="hidden" name="sid" value="${shop.id }"> 
								<input type="hidden" name="price" value="${good.price }"/> 
								<input type="submit" value="立即购买" style="width: 180px; height: 45px; font-size: 18px;color: #ffffff; background: #FFAB3F;" />
							</td>
							</form> 
							<td  colspan="2">
								<%-- <form action="${pageContext.request.contextPath }/pre/cart/addcart">
									<input type="hidden" name="gid" value="${good.id }"/>
									<input type="hidden" name="sid" value="${shop.id }"> 
									<input type="image" onclick="addCart()"   src="${pageContext.request.contextPath }/static/img/j_car.png" />
								</form> --%>
							  		<img type="image" onclick="addCart(${good.id },${shop.id })"  
							  		 src="${pageContext.request.contextPath }/static/img/j_car.png" />
							</td>
						</tr>
					</table>
					
				
			</div>
			<div class="else">
				<div class="h3">
					<h3>看了又看</h3>
				</div>
				<ul>
					<c:forEach items="${goods }" var="good" begin="0" end="3">
						<li>
							<a href="<%=request.getContextPath()%>/pre/goodinfo/${good.id}/${good.shop.id }">
								<img src="<c:if test="${fn:contains(good.picPath,'http:') }">
										${good.picPath }
										</c:if>
										<c:if test="${!fn:contains(good.picPath,'http:') }">
											${pageContext.request.contextPath }/static/img/${good.picPath }
										</c:if>"
									 width="100" height="100" /> 
								<span>￥${good.price }</span>
							</a>
						</li>
					</c:forEach> 
				</ul> 
			</div>  
		</div>
		
		<!--商品信息结束-->
		
		<!--推荐以及商品详情-->
		<div class="like">
			<div class="like_left">
				<h3>本店宝贝排行榜</h3>
				<ul>
					<c:forEach items="${goodList }" var="good" begin="0" end="3">
						<li class="like_li">
							<a href="<%=request.getContextPath()%>/pre/goodinfo/${good.id}/${good.shop.id }">
								<div><img src="<c:if test="${fn:contains(good.picPath,'http:') }">
											${good.picPath }
											</c:if>
											<c:if test="${!fn:contains(good.picPath,'http:') }">
												${pageContext.request.contextPath }/static/img/${good.picPath }
											</c:if>" width="200px" height="200px"/></div>
								<div><span>${good.name }</span></div>
								<div><span><b>￥${good.price }</b> </span></div>
							</a>	
						</li>
					</c:forEach>	
				</ul>
				
			</div> 
			<div class="good_detail"> 
				<div class="easyui-tabs" style="width:750px; border: 0px ;">
					<div title="宝贝详情" style="padding:10px">
						<div class="property">
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span>
							<span  class="key">name : value </span> 
						</div> 
						<ul class="">
							<li>
								<img src="${pageContext.request.contextPath }/static/img/ban1.jpg" width="500px" height="300px" />
							</li>
							<c:forEach items="${goodList }" var="good" begin="0" end="3">
								<li class="like_li">
									  <img src="<c:if test="${fn:contains(good.picPath,'http:') }">
												${good.picPath }
												</c:if>
												<c:if test="${!fn:contains(good.picPath,'http:') }">
													${pageContext.request.contextPath }/static/img/${good.picPath }
												</c:if>" width="500px" height="300px"/> 
								</li>
						</c:forEach>	
						</ul>
							
					</div>
					<div title="累计评论" style="padding:10px">
						<ul class="easyui-tree" >
							<li>
								<div class="commonts">
									暂无评论
								</div>
							</li> 
							
							
						</ul>
					</div>
					
					<div title="其他" style="padding:10px">
						<ul class="easyui-tree"  ></ul>
					</div>
				</div>
				
			</div> 
		</div> 
		
		<%@ include file="common/btm.jsp" %>
				<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.min.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/ui/jquery.easyui.min.js"></script>
		 		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
			 	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/love.js"></script>
		 		<script type="text/javascript">
		 			//最小值限制
		 			function minValue(num){
		 				if($(num).val()==''||parseInt($(num).val())<=1){
		 					$(num).val(1);
		 				}
		 			}
		 			//数量加
		 			function jia(add){
		 				var num = add.previousElementSibling;
		 				$(num).val(parseInt($(num).val())+1);  
		 			}
		 			//数量减
		 			function jian(jian){
		 				var num = jian.nextElementSibling;
		 				if(parseInt($(num).val())==1){
		 					alert("不能再减了！");
		 					return ;
		 				}
		 				$(num).val(parseInt($(num).val())-1);  
		 			} 
		 			//添加购物车
					function addCart(gid,sid){
						$.ajax({
							type:"GET",
							url:"/MyShop/pre/cart/addcart/",
							data:{"gid":gid,"sid":sid},
							dataType:"text",
							success:function(dataresult){
								if(dataresult=="true"){
									alert("添加成功!"); 
									//location.href="/MyShop/pre/goodinfo/"+gid+"/"+sid;
								} else{
									alert("添加失败!");
								}  
							},
							error:function(dataresult){
								alert("后台数据请求错误,请联系管理员解决！");
							} 
						});
					}
		 		</script> 
	</body>
</html>

