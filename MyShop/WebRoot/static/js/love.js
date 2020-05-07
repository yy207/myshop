$(document).ready(function(){

	
	
});

function love_add(sid,type,add){
	$.ajax({
		type:"GET",
		url:"/MyShop/pre/love/add/"+sid+"/"+type+"/"+add,
		data:"",//"sid":sid,"type":type
		dataType:"text",
		success:function(dataresult){
			if(dataresult=="true"){ 
				if(type==1){//商品
					if(add==0){//添加--移除
						$("#g_y").css("display","inline-block");
						$("#g_n").css("display","none"); 
					}else{
						$("#g_y").css("display","none");
						$("#g_n").css("display","inline-block"); 
					} 
				}else{//--商店
					if(add==0){
						$("#s_y").css("display","inline-block");
						$("#s_n").css("display","none"); 
					}else{
						$("#s_y").css("display","none");
						$("#s_n").css("display","inline-block"); 
					} 
				}
			} else{

				  alert("请先登录！");
			}  
		},
		error:function(dataresult){
			alert("网络错误");
		} 
	}); 
}
