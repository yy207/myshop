<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%> 
<div class="i_bg bg_color">
	<div class="i_ban_bg section001">
		<!-- 轮播图-->
		<div class="banner">
			<div class="top_slide_wrap">
				<ul class="slide_box bxslider">
					<c:forEach items="${imageList }" var="image" begin="0" end="5">
						<li><img
							src="<%=request.getContextPath() %>/statics/localimg/${image.path}"
							width="741" height="401" /></li>
					</c:forEach>
				</ul>
				<div class="op_btns clearfix">
					<a href="#" class="op_btn op_prev"><span></span> </a> <a href="#"
						class="op_btn op_next"><span></span> </a>
				</div>
			</div>
		</div>
		<!--新闻-->
		<div class="inews">
			<div class="news_t">
				<span class="fr"><a href="#">更多 ></a> </span>新闻资讯
			</div>
			<ul>
				<c:forEach var="news" items="${newsList }" begin="0" end="5">
					<li><a href=""><span>【${news.dataDictionary.valueName}】</span>
							${news.content }</a>
					</li>
				</c:forEach>
			</ul>
			<div class="charge_t">
				话费充值
				<div class="ch_t_icon"></div>
			</div>
			<form>
				<table border="0" style="width:205px; margin-top:10px;"
					cellspacing="0" cellpadding="0">
					<tr height="35">
						<td width="33">号码</td>
						<td><input type="text" value="" class="c_ipt" /></td>
					</tr>
					<tr height="35">
						<td>面值</td>
						<td><select class="jj" name="city">
								<option value="0" selected="selected">100元</option>
								<option value="1">50元</option>
								<option value="2">30元</option>
								<option value="3">20元</option>
								<option value="4">10元</option>
						</select> <span style="color:#ff4e00; font-size:14px;">￥99.5</span>
						</td>
					</tr>
					<tr height="35">
						<td colspan="2"><input type="submit" value="立即充值"
							class="c_btn" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!--Section002-->

	<!-- 热门商品  -->
	<div class="content mar_10">
		<!-- 左边 -->
		<div class="h_l_img"> 
			<c:forEach var="good" items="${goodList}" begin="0" end="0"> 
				<div class="img">
				<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
				<img
						src="<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
					<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
						width="180" height="180" />
				</a>
					
				</div>
				<div class="pri_bg">
					<span class="price fl " style="font-size:20px;">￥${good.price }</span>
				</div> 
			</c:forEach>
		</div>
		<!-- 右边 -->
		<div class="hot_pro">
			<div id="featureContainer">
				<div id="feature">
					<div id="block">
						<div id="botton-scroll">
							<ul class="featureUL">
								<c:forEach var="good" items="${goodList}" begin="1" end="10">
									<li class="featureBox">
										<div class="box">
											<div class="h_icon">
												<img
													src="<%=request.getContextPath() %>/statics/localimg/hot.png"
													width="45" height="45" />
											</div>
											<div class="imgbg">
												<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
													<img class="img"
													src=" <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
														<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
													width="160" height="136" /> </a>

											</div>
											<div class="name"> 
												<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
													<h2>${fn:substring(good.name,0,14)}</h2> </a>
											</div>
											<div class="price">
												<font>￥<span>${good.price }</span> </font>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<a class="h_prev" href="javascript:void();">Previous</a> <a
						class="h_next" href="javascript:void();">Next</a>
				</div>
			</div>
		</div>
	</div> 
	<!--section003大图-->
	<div class="section003" style="width:1200px;margin:10px auto;">
		<img src="<%=request.getContextPath() %>/statics/localimg/n_ban.jpg" width="1200px" alt="宣传" />
	</div>
	<!--Begin 进口 生鲜 Begin1 -->
    <div class="i_t mar_10">
    	<span class="floor_num">1F</span>
    	<span class="fl">进口 <b>·</b> 生鲜</span>                
        <span class="i_mores fr"><a href="#">进口咖啡</a>&nbsp; &nbsp; &nbsp; 
        <a href="#">进口酒</a>&nbsp; &nbsp; &nbsp; <a href="#">进口母婴</a>&nbsp; &nbsp; &nbsp; 
        <a href="#">新鲜蔬菜</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜水果</a></span>
    </div>
    <div class="content">
    	<div class="fresh_left">
        	<div class="fre_ban">
            	<div id="imgPlay1">
                    <ul class="imgs" id="actor1">
                    <c:forEach var="good" items="${goodList1}" begin="0" end="2">
						 <li class="featureBox">
						    <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
									 <img class="img" src=" 
									 	<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
										 width="211" height="286" /> </a> 
						 </li>
					 </c:forEach> 
                         <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prevf">上一张</div>
                    <div class="nextf">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
                	<a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	  <c:forEach var="good" items="${goodList1}" begin="3" end="8">
				 	<li class="featureBox"> 
						<div class="name"><a href="#">${good.name }</a></div>
	                    <div class="price"> <font>￥<span>${good.price}</span></font>  </div>
	                    <div class="img">
                    	<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
                    	<img class="img" src=" 
							 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
							 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
							 width="185" height="155" /> </a></div> 
						 </li>
					 </c:forEach> 
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<c:forEach var="good" items="${goodList1}" begin="9" end="10">
						 <li>
						    <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
							  <img class="img" src=" 
								  <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
								  <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
							   width="260" height="220" /> </a> 
						 </li>
				 </c:forEach>  
            </ul>
        </div>
    </div>    
    <!--End 进口 生鲜 End-->
    
     <!--Begin 个人美妆 Begin -->
    <div class="i_t mar_10">
    	<span class="floor_num">2F</span>
    	<span class="fl">个人美妆</span>                                
        <span class="i_mores fr"><a href="#">洗发护发</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">面膜</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">洗面奶</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">香水</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">沐浴露</a></span>                
    </div>
    <div class="content">
    	<div class="make_left">
        	<div class="make_ban">
            	<div id="imgPlay3">
                    <ul class="imgs" id="actor3">
 					  <c:forEach var="good" items="${goodList2}" begin="0" end="2">
						 <li class="featureBox">
						    <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
									 <img class="img" src=" 
									 	<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
										 width="211" height="286" /> </a> 
						 </li>
					 </c:forEach> 
                    </ul>
                    <div class="prev_m">上一张</div>
                    <div class="next_m">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
                	<a href="#">洗发护发</a><a href="#">牙刷牙膏</a><a href="#">面膜</a><a href="#">补水面膜</a><a href="#">香水</a><a href="#">面霜</a><a href="#">洗面奶</a><a href="#">脱毛膏</a><a href="#">沐浴露</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	 <c:forEach var="good" items="${goodList2}" begin="3" end="8">
				 	<li class="featureBox"> 
						<div class="name"><a href="#">${good.name }</a></div>
	                    <div class="price"> <font>￥<span>${good.price }</span></font>  </div>
	                    <div class="img">
                    	<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
                    	<img class="img" src=" 
							 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
							 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
							 width="185" height="155" /> </a></div> 
						 </li>
				 </c:forEach>  
            </ul>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<c:forEach var="good" items="${goodList2}" begin="9" end="10">
				  <li>
					  <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
							  <img class="img" src=" 
									 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
									 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
									 width="260" height="220" /> </a> 
						 </li>
			 </c:forEach>  
            </ul>
        </div>
    </div>    
    <!--End 个人美妆 End-->
    
    <!--section003大图-->
	<div class="section003" style="width:1200px;margin:10px auto;">
		<img src="<%=request.getContextPath() %>/statics/localimg/mban_1.jpg" width="1200px" alt="宣传" />
	</div>
    
    <!--Begin 家居生活 Begin -->
    <div class="i_t mar_10">
    	<span class="floor_num">3F</span>
    	<span class="fl">家居生活</span>                                
        <span class="i_mores fr"><a href="#">床上用品</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">家纺布艺</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">餐具</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">沙发</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">汽车用品</a></span>                                              
    </div>
    <div class="content">
    	<div class="home_left">
        	<div class="home_ban">
            	<div id="imgPlay5">
                    <ul class="imgs" id="actor5">
                        <c:forEach var="good" items="${goodList3}" begin="0" end="2">
						 <li class="featureBox">
						    <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
									 <img class="img" src=" 
									 	<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
										 width="211" height="286" /> </a> 
						 </li>
					 </c:forEach> 
                    </ul>
                    <div class="prev_h">上一张</div>
                    <div class="next_h">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
                	<a href="#">床上用品</a><a href="#">家纺布艺</a><a href="#">餐具水具</a><a href="#">锅具厨具</a><a href="#">沙发</a><a href="#">书柜</a><a href="#">狗粮</a><a href="#">家装建材</a><a href="#">汽车用品</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	 <c:forEach var="good" items="${goodList3}" begin="3" end="8">
				 	<li class="featureBox"> 
						<div class="name"><a href="#">${good.name }</a></div>
	                    <div class="price"> <font>￥<span>${good.price }</span></font>  </div>
	                    <div class="img">
                    	<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
                    	<img class="img" src=" 
							 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
							 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
							 width="185" height="155" /> </a></div> 
						 </li>
					 </c:forEach>  
            </ul>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<c:forEach var="good" items="${goodList3}" begin="9" end="10">
				  <li>
					  <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
							  <img class="img" src=" 
									 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
									 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
									 width="260" height="220" /> </a> 
						 </li>
			 </c:forEach>  
            </ul>
        </div>
    </div>    
    <!--End 家居生活 End-->
    
    <!--section003大图-->
	<div class="section003" style="width:1200px;margin:10px auto;">
		<img src="<%=request.getContextPath() %>/statics/localimg/mban_2.jpg" width="1200px" alt="宣传" />
	</div>
    
   <!--Begin 数码家电 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">4F</span>
    	<span class="fl">数码家电</span>                                
        <span class="i_mores fr"><a href="#">手机</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">苹果</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">华为手机</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">洗衣机</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">数码配件</a></span>                                               
    </div>
    <div class="content">
    	<div class="tel_left">
        	<div class="tel_ban">
            	<div id="imgPlay6">
                    <ul class="imgs" id="actor6">
                    <c:forEach var="good" items="${goodList4}" begin="0" end="2">
						 <li class="featureBox">
						    <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
									 <img class="img" src=" 
									 	<c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
										<c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
										 width="211" height="286" /> </a> 
						 </li>
					 </c:forEach> 
                    </ul>
                    <div class="prev_t">上一张</div>
                    <div class="next_t">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
                	<a href="#">手机</a><a href="#">平板电脑</a><a href="#">空调</a>
                	<a href="#">合约机</a><a href="#">电风扇</a><a href="#">数码配件</a>
                	<a href="#">洗衣机</a><a href="#">电视</a><a href="#">充电器</a><a href="#">耳线</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul> 
               <c:forEach var="good" items="${goodList4}" begin="3" end="8">
				 	<li class="featureBox"> 
						<div class="name"><a href="#">${good.name }</a></div>
	                    <div class="price"> <font>￥<span>${good.price }</span></font>  </div>
	                    <div class="img">
                    	<a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
                    	<img class="img" src=" 
							 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
							 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
							 width="185" height="155" /> </a></div> 
						 </li>
					 </c:forEach>  
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
        	<c:forEach var="good" items="${goodList4}" begin="9" end="10">
				  <li>
					  <a href="<%=request.getContextPath()%>/main/goodinfo/${good.id}/${good.shop.id }">
							  <img class="img" src=" 
									 <c:if test="${fn:contains(good.picPath,'http:') }">${good.picPath }</c:if>
									 <c:if test="${!fn:contains(good.picPath,'http:') }"><%=request.getContextPath() %>/statics/localimg/${good.picPath }</c:if>"
									 width="260" height="220" /> </a> 
						 </li>
			 </c:forEach>  
            </ul>
        </div>
    </div>    
    <!--End 数码家电 End--> 

	<!--section003大图-->
	<div class="section003" style="width:1200px;margin:10px auto;">
		<img src="<%=request.getContextPath() %>/statics/localimg/n_ban.jpg" width="1200px" alt="宣传" />
	</div>
	<%@ include file="common/footer.jsp"%>

	<!-- prechangeimg.js -->
	<script
		src="${pageContext.request.contextPath }/statics/localjs/prechangeimg.js"></script>