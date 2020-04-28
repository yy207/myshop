function selectjs(){ 
	var option ="<option value=''>--请选择--</option>"; 
		$.ajax({
			type:"GET",
			url:"userRole",
			dataType:"json",
			data:{keyCode:"userRole"},
			success:function(result){
				for ( var i = 0; i < result.length; i++) {
					option += "<option value='"+result[i].valueId+"'>"+result[i].valueName+"</option>";
				} 
				$("#userRole").html("");
				$("#userRole").html(option);
			},
			error:function(result){
				alert("后台出错啦~~请联系管理员修复··");
			} 
		})   
} 
//清空按钮替代功能 
$(function (){
	$(".btn-reset").click(function(){ 
		$("#userCode").val('');
		$("#userName").val('');
		$("#userRole").find("option").eq(0).prop("selected",true);
	})
})