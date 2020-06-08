
function emp(){
	alert("您还没有注册店铺,请先注册！");
}
function sub(){
	document.forms[1].submit(); 
}
function dis(){
	var chk = $("#J_agreement");
	//alert(chk.prop("checked")+">>>>>>>>>");
	if(chk.prop("checked")==true){
		$(".btn").addClass("btnOk");
		$(".btn").prop("disabled",false)
	}
	
}

function fun_name(){
	var name = $("#name").val();
	if(name==''){
		$("#nameMsg").html("店铺名不能为空！"); 
	}else{
		$("#nameMsg").html("");
		return true; 
	}
	 return false;
	
}
















