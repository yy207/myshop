$(function(){ 
	//后台根据以及分类的选择加载二级级分类
	$("#type1").change(function(){ 
		var type1 = $("#type1").val();
		$.ajax({
			type:"GET",
			url:"cate",
			data:{parentId:type1,type:2},
			dataType:"json",
			success:function(result){   
				var txt = " <option value=''>--请选择--</option>";
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
		
	});
	$("#type2").change(function(){
		var type2 = $("#type2").val();
		$.ajax({
			type:"GET",
			url:"cate",
			data:{parentId:type2,type:3},
			dataType:"json",
			success:function(result){  
				var txt = " <option value=''>--请选择--</option>";
				for(var i = 0; i<result.length;i++){
					txt +="<option value='"+ result[i].id +"'>"+result[i].name+" </option>";
				} 
				$("#type3").html(txt); 
			},
			error:function(result){
				alert("后台数据请求错误,请联系管理员！");
			} 
			});
		
	}); 
});