 var c = false;
/**
 * 账户唯一验证
 * 
 * @returns {Boolean}
 */
function fun_userCode(){
	var code = $("#userCode").val();
	if(code!=''){
		$.ajax({
			type:"GET",
			url:"/MyShop/login/userCode",
			data:{userCode:code},
			dataType:"text",
			success:function(dataresult){
				if(dataresult=="true"){
					$("#userCodeMsg").html("该账户名称可以使用");
					c=true;
					return true;
				}else if(dataresult=="false"){
					$("#userCodeMsg").html("该账户名称已存在,请尝试换一个"); 
				}else{
					$("#userCodeMsg").html("该名称输入不合法,请重新输入!");
				}  
			},
			error:function(dataresult){
				alert("后台数据请求错误,请联系管理员解决！");
			} 
		});
		c = false;
		return false;
	}else{
		$("#userCodeMsg").html("账户名称不能为空");
		c=false;
		return false;
	}  
}
/**
 * 账号名称
 * 
 * @returns {Boolean}
 */
function fun_userName(){
	var reg = new RegExp("^[A-Za-z0-9]{6,12}$");
	var name = $("#userName").val();
	if(name==''){
		$("#userNameMsg").html("用户名称不能为空"); 
	}else{
		if(name.length<6){
			$("#userNameMsg").html("用户名称不能小于6位");
		}else{
			if(reg.test(name)){
				$("#userNameMsg").html("");
				return true;
			}else{
				$("#userNameMsg").html("用户名称不能包含数字，字母，下划线之外的字符！");
			}
		}
	}
	 return false;
}
/**
 * 账号密码
 * 
 * @returns {Boolean}
 */
function fun_userPassword(){
	var pwd = $("#userPassword").val();
	if(pwd==''){
		$("#userPasswordMsg").html("密码不能为空"); 
	}else{
		if(pwd.length<6){
			$("#userPasswordMsg").html("密码不能小于6位");
		}else{
			$("#userPasswordMsg").html("");
			return true;
		}
	}
	 return false;
}
/**
 * 确认密码
 * 
 * @returns {Boolean}
 */
function fun_reUserPassword(){
	var repwd = $("#userRePassword").val();
	var pwd = $("#userPassword").val();
	if(repwd==''){
		$("#userRePasswordMsg").html("密码不能为空"); 
	}else{
		if(pwd!=repwd){
			$("#userRePasswordMsg").html("两次密码输入不一致");
		}else{
			$("#userRePasswordMsg").html("");
			return true;
		}
	}
	 return false; 
} 
/**
 * idCard
 * 
 * @returns
 */
function fun_idCard(){
	var id = $("#idCard").val();
	var reg = new RegExp("^[0-9]{17}[a-zA-Z0-9]{1}$");
	if(id==''){
		$("#idCardMsg").html("身份证号码不能为空！");
	}else{
		if(reg.test(id)){
			$("#idCardMsg").html("");
			return true;
		}else{
			$("#idCardMsg").html("身份证号码输入格式不正确！");
		}
	}  
	return false;
}
/**
 * 真实姓名
 * 
 * @returns {Boolean}
 */
function fun_realName(){ 
	var name = $("#realName").val();
	if(name==''){
		$("#realNameMsg").html("真实姓名不能为空"); 
	}else{
		$("#realNameMsg").html("");
		return true; 
	}
	 return false;
}
/**
 * 验证日期
 */
function fun_birthday(){
	var date = $("#birthday").val();
	var reg = new RegExp("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$");
	if(date !=''){
		if(reg.test(date)){
			$("#birthdayMsg").html("");
			return true;
		}else{
			$("#birthdayMsg").html("日期格式输入不正确！"); 
		}
	}else{
		$("#birthdayMsg").html("出生日期不能为空！");
	}
	return false;
}

/**
 * 验证手机号码
 * @returns {Boolean}
 */
function fun_phone(){
	var phone = $("#phone").val();
	var reg = RegExp("^1[3|5|6|7|8|9][0-9]{9}$");
	if(phone == ''){
		$("#phoneMsg").html("手机号码不能为空！");
	}else{
		if(reg.test(phone)){
			$("#phoneMsg").html("");
			return true;
		}else{
			$("#phoneMsg").html("手机号码输入格式不正确！");
		}
	}
	return false;
}
/**
 * 检查邮箱
 * @returns {Boolean}
 */
function fun_email(){
	//email
	var email = $("#email").val();
	//
	var u=document.getElementById("email");	
	//表达式
	var reg = /^\w+@\w+([\.a-zA-Z0-9]{2,3}){1,2}$/;
	if(reg.test(email)==false){
		u.setCustomValidity("电子邮箱格式不对")
		$("#emailMsg").html("电子邮箱格式不正确！");
		return  false;
	}else{
		$("#emailMsg").html("");
		u.setCustomValidity("")
		return  true;
	} 
} 

/**
 * 提交事件触发
 */
function fun_register(){
	var r = true;
	if(!c){ 
		r=false;
	} 
	if(!fun_userName()){
		r=false;
	}
	if(!fun_userPassword()){
		r=false;
	}  
	if(!fun_reUserPassword()){
		r=false;		
	}  
	if(!fun_idCard()){
		r=false;
	}
	if(!fun_realName()){
		r=false;
	} 
	if(!fun_birthday()){
		r=false;
	}
	if(!fun_phone()){
		r=false;
	}
	if($("#email").val()!=''){
		if(!fun_email()){ 
			r=false;
		}
	} 
	return r;
}



/**
 * 提交事件触发
 */
function fun_pre_register(){
	var r = true;
	if(!c){ 
		r=false;
	}  
	if(!fun_userPassword()){
		r=false;
	}  
	if(!fun_reUserPassword()){
		r=false;		
	}  
	if(!fun_idCard()){
		r=false;
	}
	if(!fun_realName()){
		r=false;
	}  
	if(!fun_phone()){
		r=false;
	}
	if($("#email").val()!=''){
		if(!fun_email()){ 
			r=false;
		}
	} 
	if($("#checkbox").prop("checked")==false){
		alert("注册前请勾选用户协议");
		r=false;
	}
	return r;
}




