<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="top.jsp" %>
	<div class="menu_bg ">
		<div class="menu">
			<!--Begin 商品分类详情 Begin-->
			<div class="nav">
				<div class="nav_t bottom">全部商品分类</div>
				<div class="leftNav left "  >
				 
					<ul>
						<!-- 输出二级分类  -->
						<c:forEach var="cate" items="${cateList2}" begin="0" end="9">
							<li>
								<div class="fj">
									<span class="n_img"> <span></span> <img
										src="<%=request.getContextPath() %>/statics/localimg/${cate.iconClass }" />
									</span> <span class="fl"> ${cate.name }</span>
								</div>
								<div class="zj" style="top:-40px;">
									<div class="zj_l">
										<div class="zj_l_c">
											<h2>零食 / 糖果 / 巧克力</h2>
											<a href="#">坚果</a>|<a href="#">蜜饯</a>|<a href="#">红枣</a>|<a
												href="#">牛肉干</a>|<a href="#">巧克力</a>| <a href="#">口香糖</a>|<a
												href="#">海苔</a>|<a href="#">鱼干</a>|<a href="#">蜜饯</a>|<a
												href="#">红枣</a>| <a href="#">蜜饯</a>|<a href="#">红枣</a>|<a
												href="#">牛肉干</a>|<a href="#">蜜饯</a>|
												
												<script type="text/javascript">
												function cate(pid,type){  
														$.ajax({
															type:"GET",
															url:"/MyShop/main/cate",
															data:{"parentId":pid,"type":type},
															dataType:"json",
															success:function(result){   
																
																txt ="<a href='"+${pageContext.request.contextPath }+"/main/index?cate="+result[i].id+"'>"+result[i].name+"</a>";
																 for(var i = 0; i<result.length;i++){
																	txt +="<option value='"+ result[i].id +"'>"+result[i].name+" </option>";
																} 
																$("#type2").html(txt);
																$("#type3").html("");
															},
															error:function(result){
																alert("后台数据请求错误,请联系管理员！");
															}
														});
												}
												</script>
										</div>
									</div>
									<div class="zj_r">
										<a href="#"><img
											src="<%=request.getContextPath() %>/statics/localimg/n_img1.jpg"
											width="236" height="200" />
										</a> <a href="#"><img
											src="<%=request.getContextPath() %>/statics/localimg/n_img2.jpg"
											width="236" height="200" />
										</a>
									</div>
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--End 商品分类详情 End-->
			<ul class="menu_r">
				<li><a
						href="<%=request.getContextPath() %>/main/index">首页</a></li>
				<c:forEach var="cate" items="${cateList1}" begin="0" end="8">
					<li><a
						href="<%=request.getContextPath() %>/main/index?cate=${cate.id}">${cate.name
							}</a></li>
				</c:forEach>
			</ul>
			<div class="m_ad">中秋送好礼！</div>
		</div>
	</div>
	
<div class="i_bg bg_color">