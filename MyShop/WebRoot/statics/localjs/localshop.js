var s = false;
function fun_name(){ 
	var sname = $("#name").val(); 
	if(sname==""){
		$("#nameMsg").html("名称不能为空！");
	}else{
		$.ajax({
			type:"GET",
			url:"shopname",
			data:{name:sname},
			dataType:"text",
			success:function(result){ 
				if(result=="false"){
					$("#nameMsg").html("该名称已被使用,请重新输入!");
					
				}else if(result=="error"){
					$("#nameMsg").html("该名称输入不合法,请重新输入!");
				}
				else {
					$("#nameMsg").html(""); 
					s = true;
					return true;
				}
				alert(r);
			},
			error:function(result){
				alert("后台数据请求出现错误,请联系管理员!");
			}
		});
	}  
	s = false;
	return false;
}
function fun_shop(){
	var result  = true;
	if(!s){
		result = false;
	}
	if(!fun_phone()){
		result=false;
	} 
	return result;
}