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
										var txt = " <option value=''>--请选择--</option>";
										for(var i = 0; i<result.length;i++){
											txt +="<option value='"+ result[i].id +"'>"+result[i].cityName+" </option>";
										} 
										$("#city2").html(txt);
										$("#city3").html("<option value=''>----------</option>");
									},
									error:function(result){
										alert("后台数据请求错误,请联系管理员！");
									}
								});
								
							});
							c1();
							function c1(){ 
								var type1 = $("#city1").val();
								$.ajax({
									type:"GET",
									url:"/MyShop/pre/city",
									data:{pid:1,type:1},
									dataType:"json",
									success:function(result){   
										var txt = " <option value=''>--请选择--</option>";
										for(var i = 0; i<result.length;i++){
											txt +="<option value='"+ result[i].id +"'>"+result[i].cityName+" </option>";
										} 
										$("#city1").html(txt); 
									},
									error:function(result){
										alert("后台数据请求错误,请联系管理员！");
									}
								});
								
							} 
							$("#city2").change(function(){
								var type2 = $("#city2").val();
								$.ajax({
									type:"GET",
									url:"/MyShop/pre/city",
									data:{pid:type2,type:3},
									dataType:"json",
									success:function(result){  
										var txt = " <option value=''>--请选择--</option>";
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
		 			