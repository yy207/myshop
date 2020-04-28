<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>


<div class="x_panel">
	<div class="x_title">
		<h2>商店注册</h2>
		<div class="clearfix"></div>
	</div>
	<form id="register" name="register" action="add" method="post"
		enctype="multipart/form-data" onsubmit="return fun_shop()"
		class="form-horizontal form-label-left">
		<div class="form-group">
			<input type="hidden" id="id" name="id"
				class="form-control col-md-7 col-xs-12" value="${shop.id }">
		</div>
		<div class="form-group">
			<label for="userName"
				class="control-label col-md-3 col-sm-3 col-xs-12">商店名称</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="name" name="name" onblur="fun_name()"
					required="required" class="form-control col-md-7 col-xs-12"
					value="${shop.name }">
			</div>
			<span class="required">*</span> <span id="nameMsg"></span>
		</div>
		<div class="form-group">
			<label for="userPassword"
				class="control-label col-md-3 col-sm-3 col-xs-12">经营地址</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="address" name="address" required="required"
					onblur="" class="form-control col-md-7 col-xs-12"
					value="${shop.address}">
			</div>
			<span class="required">*</span> <span id="addressMsg"></span>
		</div>

		<div class="form-group">
			<label for="userRole"
				class="control-label col-md-3 col-sm-3 col-xs-12">商店经营</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="col-md-4 col-sm-4 col-xs-12">
					<!-- 一级分类 -->
					<select id="type1" name="type1" required="required"
						class="form-control col-md-7 col-xs-12">
						<option value="">--请选择--</option>
						<c:forEach var="cate" items="${cate1 }">
							<option value="${cate.id }" <c:if test="${cate.id == shop.type1 }">selected</c:if>>
								${cate.name }
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-12">
					<!-- 二级分类 -->
					<select id="type2" name="type2" 
						class="form-control col-md-7 col-xs-12">
						  <option value="">--请选择--</option>
						<c:forEach var="cate" items="${cate2 }">
							<option value="${cate.id }" <c:if test="${cate.id == shop.type2 }">selected</c:if>>
								${cate.name }
							</option>
						</c:forEach>  
					</select>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-12">
					<!-- 三级分类 -->
					<select id="type3" name="type3"
						class="form-control col-md-7 col-xs-12">
						<option value="">--请选择--</option>
						  <c:forEach var="cate" items="${cate3 }">
							<option value="${cate.id }" <c:if test="${cate.id == shop.type3 }">selected</c:if>>
								${cate.name }
							</option>
						</c:forEach> 
					</select>
				</div> 
			</div>
			<span class="required">*</span>
		</div>
		<div class="form-group">
			<label for="idCard" class="control-label col-md-3 col-sm-3 col-xs-12">详细描述</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="describe" name="describe"
					onblur="" required="required"
					class="form-control col-md-7 col-xs-12" value="${shop.describe}">
			</div>
			<span class="required">*</span> <span id="describeMsg"></span>
		</div>



		<div class="form-group">
			<label for="phone" class="control-label col-md-3 col-sm-3 col-xs-12">电话/手机号码</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="phone" name="phone" onblur="fun_phone()"
					required="required" class="form-control col-md-7 col-xs-12"
					value="${user.phone }">
			</div>
			<span class="required">*</span> <span id="phoneMsg"></span>
		</div>

		<div class="form-group">
			<label for="shopImage"
				class="control-label col-md-3 col-sm-3 col-xs-12">上传图片</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="file" id="shopImage" name="shopImage"
					class=" col-md-7 col-xs-12">
			</div>
			<span id="imageMsg">${file }</span>
		</div>
		<div class="ln_solid"></div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
				<button type="reset" class="btn btn-primary">清空</button>
				<button type="submit" class="btn btn-success">注册</button>
				<h2 style="color:red;">${msg }</h2>
			</div>
		</div>
	</form>
</div>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	/*  selectjs(); */
</script>
