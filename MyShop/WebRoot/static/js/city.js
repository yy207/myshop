					$(function(){ 
							//后台根据以及分类的选择加载二级级分类
							$("#city1").change(function(){ 
								var type1 = $("#city1").val();
								$.ajax({
									type:"GET",
									url:"/MyShop/pre/city",
									data:{pid:type1,type:2},
									dataType:"json",
									success:function(result){   
										var txt = " <option value=''>请选择区/县</option>";
										for(var i = 0; i<result.length;i++){
											txt +="<option value='"+ result[i].id +"'>"+result[i].cityName+" </option>";
										} 
										$("#city2").html(txt);
										$("#city3").html("<option value=''>请选择区/县</option>");
									},
									error:function(result){
										alert("后台数据请求错误,请联系管理员！");
									}
								});
								
							});
//							c1();
//							function c1(){ 
//								var type1 = $("#city1").val();
//								$.ajax({
//									type:"GET",
//									url:"/MyShop/pre/city",
//									data:{pid:1,type:1},
//									dataType:"json",
//									success:function(result){   
//										var txt = " <option value=''>--请选择--</option>";
//										for(var i = 0; i<result.length;i++){
//											txt +="<option value='"+ result[i].id +"'>"+result[i].cityName+" </option>";
//										} 
//										$("#city1").html(txt); 
//									},
//									error:function(result){
//										alert("后台数据请求错误,请联系管理员！");
//									}
//								});
//								
//							} 
							$("#city2").change(function(){
								var type2 = $("#city2").val();
								$.ajax({
									type:"GET",
									url:"/MyShop/pre/city",
									data:{pid:type2,type:3},
									dataType:"json",
									success:function(result){  
										var txt = " <option value=''>请选择区/县</option>";
										for(var i = 0; i<result.length;i++){
											txt +="<option value='"+ result[i].id +"'>"+result[i].cityName +" </option>";
										} 
										$("#city3").html(txt); 
									},
									error:function(result){
										alert("后台数据请求错误,请联系管理员！");
									} 
									});
								
							}); 
						});

function tel(){
	//手机号
	var phone=$("#phone").val();
	//提示
	var $divPwd=$("#phoneMsg");
	//表达式		数字1开头	1+10个
	var reg = /^1{7|3|5}{5|7|6|8|9|1}\d{7}$/;
	//验证
	if(phone == null || phone == ''){
		$divPwd.html("* 请输入一个手机号！");
		return false;
	}
	if(reg.test(phone)==false||phone.length!=11){
		$divPwd.html("* 手机号格式不正确！");
		return false;
	}
	$divPwd.html("");
		return true;
}

		 			