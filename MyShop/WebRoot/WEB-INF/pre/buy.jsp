<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>生成订单</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/nav.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/buy.css" />
	</head>
	<body>
	<%@ include file="common/nav.jsp" %>
		<div class="buy_info_step">
			<div class="logo">
				<img src="${pageContext.request.contextPath }/static/img/logo.png" width="150"/>
			</div>
			<div class="step">
				<div class="s s1 ">
					<span class="cycle active">1</span> <br />
					<span class="txt">1、确认订单信息</span>
				</div>
				<hr class="hr"/>
				<div class="s s1">
					<span class="cycle">2</span><br />
					<span class="txt">2、付款到支付宝</span>
				</div>
				<hr class="hr"/>
				<div class="s s1">
					<span class="cycle">3</span><br />
					<span class="txt">3、确认收货</span>
				</div>
				<hr class="hr"/>
				<div class="s s1">
					<span class="cycle">4</span><br />
					<span class="txt">4、双方互评</span>
				</div>
			</div>
		</div>
		
		<div class="buy_order">
		   <form action="${pageContext.request.contextPath }/pre/buy/order">
				
			<div class="address_choose">
				<div class="top_t">
					<div class="title" >
						确认收货地址
					</div>
					<div class="right">
						<a href="${pageContext.request.contextPath }/pre/nav/addresspage">管理收货地址</a>
					</div>		 
				</div>
				<div class="radiobuttons">
				   <c:forEach items="${addressList }" var="address">
					<div class="radiobutton <c:if test="${address.isDefault==1 }">active</c:if>">
						<div class="pre">
							<div class="show">
								<img src="${pageContext.request.contextPath }/static/img/ch.png" width="18" height="18" class="checked"/>
								<label class="checked">寄送至</label>
							</div>
						</div>
						<div class="radio">
							<input type="radio" id="s${address.id }" name="addressRadio" value="${address.id }" required   onchange="buy(this)"  <c:if test="${address.isDefault==1 }">checked</c:if> />
							<label for="s${address.id }">
								<span id="sAddress">${address.c1.cityName} ${address.c2.cityName} ${address.c3.cityName}  ${address.address }</span> &nbsp;&nbsp;&nbsp;
								(<span id="sName">${address.name }</span>)收&nbsp;&nbsp;&nbsp;
								<span id="sPhone">${address.phone } </span>
							</label>
						</div> 
						<div class="update"  >
							<div class="show">
								<a href="${pageContext.request.contextPath }/pre/address/update/${address.id}">修改此地址</a>
							</div>
						</div>
					</div> 
   				  </c:forEach>
   				  
   				 
				</div>
				<div class="new_add">
					 <c:if test="${fn:length(addressList)==0 }">
	   				  	
	   				  	<a href="${pageContext.request.contextPath }/pre/nav/addresspage" class="news"><input type="radio" name="addressRadio" style="display: none;" required />请先添加一个地址!</a>
	   				  </c:if>
					<c:if test="${fn:length(addressList)!=0 }">
	   				  		<a href="${pageContext.request.contextPath }/pre/nav/addresspage" class="new">使用新地址</a>
	   				  </c:if>
				</div>
			</div>
			
			<hr />
			<div class="order_choose">
				<div class="top_t">
					<div class="title" >
						确认订单信息
					</div> 
				</div>
				<div class="good">
					<table width="990" height="170">
						<tr class="title">
							<td width="300">宝贝信息</td>
							<td width="150">属性</td>
							<td width="100">单价</td>
							<td width="100">数量</td>
							<td width="200">优惠方式</td>
							<td width="100x">小计</td>
						</tr> 
						
						<c:forEach items="${orderList }" var="order">
							<input type="hidden" name="gid" value="${order.good.id }"/>
							<input type="hidden" name="sid" value="${order.shop.id }"/> 
							<tr>
								<td  style="border-bottom: 2px #B7D2FF dashed;">店铺：${order.shop.name }</td>
								<td colspan="5"  style="border-bottom: 2px #B7D2FF dashed;">卖家：${order.shop.user.userName }</td>
							</tr>
							<tr class="info order_info">
								<td width="300">
									<span><img src="${pageContext.request.contextPath }/static/img/O1CN017IVk7V1bevFsDb8FQ_!!13493491.jpg_220x220.jpg" width="50" height="50" /> </span>
									<span class="txt">${order.good.name }</span>
								</td>
								<td width="150">
									<span class="property">颜色：黑色</span>
									<span class="property">颜色：黑色</span>
								</td>
								<td width="100">
									 $<span class="property singlePrice single_price" style="display:inline;" id="singlePrice">${order.good.price }</span>								
								</td>
								<td width="100" class="num">
									<input type="button" value=" - " class="jian" onclick="jian(this)" />
									<input type="number"  value="<c:if test="${order.number ==null }">1</c:if><c:if test="${order.number !=null }">${order.number }</c:if>"
									 name="number"  class="number good_num" id="num"  onblur="" onchange="minValue(this)"/>
									<input type="button" value="+"  id="add"  class="add" onclick="jia(this)"/>
								</td> 
								<td width="200" style="text-align: center;">
									<span class="property">满减</span>
								</td>
								<td width="100" class="right">￥
									<span class="price totalPrice" style="font-size:14px ;" id="total"> 
										<c:if test="${order.number ==null }"> ${order.good.price}</c:if>
										<c:if test="${order.number !=null }">${order.number*order.good.price }</c:if>	
									</span>								
								</td>
							</tr>
							<tr class="else">
								<td colspan="2">
									给卖家留言：
									<input type="text" name="remark" id="remark"  multiple="multiple"/>
								</td>
								<td colspan="3" class="">配送方式：普通快递 免邮  </td>
								<td width="100" class="right">
									<span class="price" style="font-size:14px ;" >0.0</span>								
								</td>
							</tr> 
						</c:forEach>
						<tr class="else">
							<td colspan="6" class="right">
								店铺合计(含运费)<span class="price total" style="font-size:14px ;" id="total_price">￥
									<c:if test="${totalPrice !=null }">${totalPrice }</c:if>	 
									</span>		
							</td>
						</tr> 
					</table> 
				</div>
				
			</div>	
			
			<div class="clear">
				<div class="final">
					<div class="price">
						实付款:<span  class="money" id="realMoney">￥
							<c:if test="${totalPrice !=null }">${totalPrice }</c:if>	 
						</span>
					</div>
					<div class="address">
						<b>寄送至：</b> <span id="cAddress"></span>
					</div>
					<div class="name">
						<b> 收货人：</b><span id="cName"></span>&nbsp;&nbsp;&nbsp;
						<b>电话</b>  ：<span id="cPhone"></span>
					</div> 
				</div>
			</div>
			<div class="submit">
				<input type="image" src="${pageContext.request.contextPath }/static/img/btn_sure.gif" />
				
			</div>
	      </form> 
		</div>  
	</div>
		
		
		
			<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.min.js" ></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/buy.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/number.js" ></script> 
	</body>
</html>
