<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>


<div class="x_panel">
	<div class="x_title">
		<h2>新用户注册</h2>
		<div class="clearfix"></div>
	</div>
	<form id="register" name="register" action="registe" method="post"
		enctype="multipart/form-data" onsubmit="return fun_register()"
		class="form-horizontal form-label-left">
		<div class="form-group">
			<label for="userCode"
				class="control-label col-md-3 col-sm-3 col-xs-12">用户账号</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="userCode" name="userCode"
					onblur="fun_userCode()" required="required"
					class="form-control col-md-7 col-xs-12" value="${user.userCode }">
			</div>
			<span class="required">*</span> <span id="userCodeMsg"></span>
		</div>
		<div class="form-group">
			<label for="userName"
				class="control-label col-md-3 col-sm-3 col-xs-12">用户名称</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="userName" name="userName"
					onblur="fun_userName()" required="required"
					class="form-control col-md-7 col-xs-12" value="${user.userName }">
			</div>
			<span class="required">*</span> <span id="userNameMsg"></span>
		</div>
		<div class="form-group">
			<label for="userPassword"
				class="control-label col-md-3 col-sm-3 col-xs-12">用户密码</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="password" id="userPassword" name="userPassword"
					required="required" onblur="fun_userPassword()"
					class="form-control col-md-7 col-xs-12"
					value="${user.userPassword}">
			</div>
			<span class="required">*</span> <span id="userPasswordMsg"></span>
		</div>
		<div class="form-group">
			<label for="userRePassword"
				class="control-label col-md-3 col-sm-3 col-xs-12">确认密码</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="password" id="userRePassword" name="userRePassword"
					required="required" onblur="fun_reUserPassword()"
					class="form-control col-md-7 col-xs-12"
					value="${user.userPassword}">
			</div>
			<span class="required">*</span> <span id="userRePasswordMsg"></span>
		</div>
		<div class="form-group">
			<label for="userRole"
				class="control-label col-md-3 col-sm-3 col-xs-12">用户角色</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<select id="userRole" name="userRole" required="required"
					class="form-control col-md-7 col-xs-12">
					<option>--请选择--</option>
					<c:forEach var="role" items="${dataList }">
						<option value="${role.valueId }"
							<c:if test="${user.userrole == role.valueId }">selected</c:if>>${role.valueName }</option>
					</c:forEach>
				</select>
			</div>
			<span class="required">*</span>
		</div>
		<div class="form-group">
			<label for="idCard" class="control-label col-md-3 col-sm-3 col-xs-12">用户身份证号码</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="idCard" name="idCard" onblur="fun_idCard()"
					required="required" class="form-control col-md-7 col-xs-12"
					value="${user.idCard}">
			</div>
			<span class="required">*</span> <span id="idCardMsg"></span>
		</div>

		<div class="form-group">
			<label for="realName"
				class="control-label col-md-3 col-sm-3 col-xs-12">用户真实姓名</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="realName" name="realName"
					onblur="fun_realName()" required="required"
					class="form-control col-md-7 col-xs-12" value="${user.realName}">
			</div>
			<span class="required">*</span><span id="realNameMsg"></span>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3 col-sm-3 col-xs-12">性别</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div id="sex" class="btn-group" data-toggle="buttons">
					<label class="btn btn-default active"> <input id="male"
						type="radio" name="sex" value="男"> 男 </label> <label
						class="btn  btn-default"> <input id="female" type="radio"
						name="sex" value="女"> 女 </label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="birthday"
				class="control-label col-md-3 col-sm-3 col-xs-12">出生日期</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="birthday" name="birthday" onblur="fun_birthday()"
					class="date-picker form-control col-md-7 col-xs-12"
					required="required" type="date" value="${user.birthday}">
			</div>
			<span class="required">*</span><span id="birthdayMsg">${birthday
				}</span>
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
			<label for="address"
				class="control-label col-md-3 col-sm-3 col-xs-12">用户住址</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="address" name="address" required="required"
					class="form-control col-md-7 col-xs-12" value="${user.address }">
			</div>
			<span class="required">*</span>
		</div>


		<div class="form-group">
			<label for="email" class="control-label col-md-3 col-sm-3 col-xs-12">用户邮箱</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="email" name="email" onblur="fun_email()"
					class="form-control col-md-7 col-xs-12" value="${user.email }">
			</div>
			<span id="emailMsg"></span>
		</div>

		<div class="form-group">
			<label for="userImage"
				class="control-label col-md-3 col-sm-3 col-xs-12">上传头像</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="file" id="userImage" name="userImage"
					class=" col-md-7 col-xs-12">
			</div>
			<span id="imageMsg">${file }</span>
		</div>
		<div class="ln_solid"></div>
		<div class="form-group">
			<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
				<button type="reset" class="btn btn-primary">清空</button>
				<button type="submit" class="btn btn-success">注册</button>
				<!-- onclick="this.form.onsubmit()" -->
			</div>
		</div>
	</form>
</div>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	/*  selectjs(); */
</script>