$(document).ready(function(){

	
	
});

function love_add(sid,type){
	$.ajax({
		type:"GET",
		url:"/MyShop/pre/love/add/"+sid+"/"+type,
		data:"",//"sid":sid,"type":type
		dataType:"text",
		success:function(dataresult){
			if(dataresult=="true"){
				if(){
					
				}
				
				$("#s_y").css("display","inline-block");
				$("#s_n").css("display","none"); 
			  alert("true");
			} else{

				  alert("false");
			}  
		},
		error:function(dataresult){
			alert("操作失败！");
		} 
	}); 
}
