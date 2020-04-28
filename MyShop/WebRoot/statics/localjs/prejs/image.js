function fun_image(){
	$.get("/MyShop/image/image.do",null,function(){
		$("#imageCode").attr("src","");
		$("#imageCode").attr("src","/MyShop/image/image.do");
	});
	
}