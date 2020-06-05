<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/leftcommon.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/shop.css" />
	</head>
	<body> 
		<!-- 标题 -->
		<%@ include file="common/shop_bg.jsp" %> 
					
		<div class="sec">
			<!-- left -->
			<%@ include file="common/shop_left.jsp" %>
			<!-- right -->
			<div class="right_sec">
				<div class="right_title">
					我的位置>我是买家>店铺管理
				</div>
				<div class="tab">
					<div class="tb active">
						<span>淘宝店铺</span>
					</div>	
					<div class="tb">
						<span>手机店铺</span>
					</div> 
				</div> 
				<h5>基础信息</h5>
				<div class="table"> 
					<div class="ul">
						<div class="shop-information">
                           <form action="" method="post" id="J_SimpleIntro">
			                    <input type="hidden" name="action" value="shop/shop_action">
			                    <input name="event_submit_do_update_shop_basic" type="hidden" value="改变分格">
			                    <input type="hidden" value="" name="shop_logo" id="shop_logo_data">
			                    <input type="hidden" name="ivToken" id="J_ivToken">
								<input name="_tb_token_" type="hidden" value="ebe8e38875eb7">
			                    <ul class="form-info"> 			                            
			                        <li class="ml">
			                            <span class="info-tip img-erro info-muted"><i></i>您填写的信息将在店铺前台展示给买家，请认真填写！</span>
			                        </li> 
			                        <li class="form-label">基础信息</li> 
				                    <li class="ml">
				                        <label class="item-name" for="sh-name"><em>*</em>店铺名称：</label>
			                            <div class="sh-name">                                           
			                            	<input type="text" class="text1" id="sh-name" name="shopName" value="${sessionUser.shop.name }">
			                            </div>                   
			                        </li>
			                        <li class="ml3">
			                            <span class="item-name">店铺标志：</span>
			                            <div class="shop-photo"> 
			                                <img src="${pageContext.request.contextPath }/static/img/${sessionUser.shop.picPath}" alt="店铺标志" class="shop-pic" id="file-img">
			                                <input type="file" class="simulate_upload" name="_fmw.u._0.ph" style="left: 25px; top: 14px;">
				                            <p class="upload-con">
				                            	<span>msg${imageMsg }</span>
				                            	<span class="info-tip img-erro"><i></i>文件格式GIF、JPG、JPEG、PNG文件大小80K以内，建议尺寸80PX*80PX</span>
				                            </p>
			                            </div>
			                        </li> 
			                        <li class="ml">
			                          <label class="item-name" for="sh-intro">店铺简介：</label>
			                          <div class="sh-category" style="width: 500px;">
			                                <textarea class="text1" id="sh-intro" name="_fmw.upd._0.k" style="width: 340px;height: 36px;">${sessionUser.shop.shortInfo}</textarea>
			                              	 <span class="info-tip img-erro" style="margin-left: 130px;"><i></i>店铺简介会加入到店铺索引中！</span>
			                                <a href="#" target="_blank">详细说明</a>
			                          </div>
			                        </li>
			
			                         <li class="ml">
			                                <label class="item-name">
			                                 <em>*</em>经营地址:
			                                </label>
			                                <div class="registered-addresss">
											<div id="J_ContactAddresss" data-isuserselfdefine="">
											 <select name="contactProvince" class="J_AddressCN" id="city1" data-level="province">
											 		<option value="">请选择省/直辖市</option> 
											 		<c:forEach var="city" items="${cityList1 }">
											 			<option value="${city.id }"
											 				
											 				<c:if test="${sessionUser.shop.city1 == city.id }">selected</c:if>
											 			>${city.cityName }</option> 
											 		</c:forEach>
											 		
											 </select>
											 <select name="contactCity" class="J_AddressCN" id="city2" data-level="city">
											 		<op	tion value="">请选择区/县</option>
											 		<c:forEach var="city" items="${cityList2 }">
											 			<option value="${city.id }"
											 			
											 				<c:if test="${sessionUser.shop.city2 == city.id }">selected</c:if>
											 			>${city.cityName }</option> 
											 		</c:forEach>
											 </select>
											 <select name="contactDistrict" class="J_AddressCN" id="city3" data-level="area">
											 	<option value="">请选择区/县</option>
											 		<c:forEach var="city" items="${cityList3 }">
											 			<option value="${city.id }" 
											 				<c:if test="${sessionUser.shop.city3 == city.id }">selected</c:if>
											 			>${city.cityName }</option> 
											 		</c:forEach>
											 </select>
											</div>
										</div>
			                         </li> 
									 <li class="ml">
			                            <label class="item-name"></label>
										<div id="J_ContactAddresss" data-isuserselfdefine="">
			                                <input type="text" class="text4" data-valid="{}" name="_fmw.upd._0.ex" value="${sessionUser.shop.address }">
			                                <span class="info-tip img-erro" style="margin-left: 130px;">
			                                <i></i>目前不支持设置海外国家、地区、港澳台地区的地址，建议您遵循声明要求填写国内地址。更多问题<a href="#" target="_blank">点此查看</a>
			                                </span>
			                            </div> 
			                        </li>
									 
									 
			                        <li class="ml">
			                            <span class="item-name"><em>*</em>主要货源：</span>
			                            <div class="source-item"> 
			                                <p>
			                                    <input type="radio" name="mainSource" id="off-line" value="1" checked="true"><label for="off-line">线下批发市场</label>
			                                    <input type="radio" name="mainSource" id="store" value="5"><label for="store">实体店拿货</label>
			                                    <input type="radio" name="mainSource" id="alibaba" value="3"><label for="alibaba">阿里巴巴批发</label>
			                                    <input type="radio" name="mainSource" id="distribution" value="4"><label for="distribution">分销/代销</label>
			                                </p>
			                                <p>
			
			                                    <input type="radio" name="mainSource" id="made-myself" value="2"><label for="made-myself">自己生产</label>
			                                    <input type="radio" name="mainSource" id="oem" value="7"><label for="oem">代工生产</label>
			                                    <input type="radio" name="mainSource" id="free-way" value="8"><label for="free-way">自由公司渠道</label>
			                                    <input type="radio" name="mainSource" id="not-sure" value="6"><label for="not-sure">货源还未确定</label>
			                                </p>
			                            </div>
			                        </li>
			
			                     <li class="ml"> 

			                             	<input type="hidden" name="_fmw.upd._0.p" value="464230">                                                                                                                                                                                                                                                                                                                                                                        <li class="ml">
			                                <label class="item-name"><em>*</em>店铺介绍：</label> 
			                    	</li>
			                    <textarea id="TextArea1" cols="15" rows="2" class="ckeditor">${sessionUser.shop.describe }</textarea>
			                    <li class="ml2">
			                            <label id="J_agreement_check" style="background: #FFF3E0;padding: 10;">
			                                <input type="checkbox" id="J_agreement">
			                               		 我声明，此页面所填写内容均真实有效，特别是经营地址为店铺最新可联系到的地址。同时可以作为行政机关和司法机关送达法律文件的地址。如果上述地址信息有误，愿意承担由此带来的平台处罚（<a href="#" target="_blank">天猫处罚细则</a>）、行政监管和司法诉讼风险。
			                            </label>
			                    </li>
			
			                    <li class="ml2">
			                        <div id="J_saveAction">
			                            <span style="display: inline-block;padding: 3px 8px;background-color: #ddd;color: #333">保存</span>
			                        </div>
			                    </li>
			                </ul>
			
			            </form>
			            <div class="upload upload-btn" style="top: 195px; left: 143px;">
			                <a href="javascript:void(0)" class="upload-btn"> 
			                   <em>上传图标</em>
			                    <form target="upload_iframe" enctype="multipart/form-data" method="POST" action="${pageContext.request.contextPath }/pre/shop/upload" id="upload_form" style="cursor:pointer;">
			                        <input name="id" type="hidden" value="${sessionUser.shop.id }">
			                        <input type="file" <c:if test="${sessionUser.shop != null }">onchange="sub()"</c:if> class="simulate_upload" name="shopImage" style="left: 15px; top: 1px;" accept="image/jpeg,image/png" />
			                    </form>
			                    <script type="text/javascript">
			                    	function sub(){
			                    		document.forms[1].submit();
			                    	
			                    	}
			                    </script>
			                </a>  
			            </div>
			        </div>
				</div> 
			</div> 
			</div> 
		</div> 
		
		 <script type="text/javascript" src="${pageContext.request.contextPath }/static/ckeditor/ckeditor.js"></script> 
		 <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/city.js" ></script>
		

		
		
		
		
	</body>
</html>
