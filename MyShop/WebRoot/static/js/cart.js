							/**
						 * 记录数量*价格
						 */
						function count(){
							var count=0;
							var totalPrice=0;
							$(".good_chk").each(function(){
								var ch=$(this).prop("checked")
								if(ch==true){
									 count++;
									var num = $(this.parentNode.parentNode.parentNode).find(".total_price").eq(0).html();
									totalPrice+=FloatAdd(0,num)
								} 
							}); 
							$("#total_price").html(totalPrice);
							$("#total_chk").html(count); 	
						}					
						/**
		 			 * 选中复选框
		 			 * @param {Object} cbo
		 			 */
		 			function Checked(cbo){
		 				var pNode=cbo.parentNode.parentNode.parentNode;
						if(cbo.checked){
							$(pNode).css("background","#EAEAEA");
						}else{
							$(pNode).css("background","#fff");
						}
						var chks = $(".good_chk");
						var count = 0; 
						for (var i = 0; i < chks.length; i++) {
							if(chks[i].checked){
								 count++;
							}
						}
 
						$("#total_chk").html(count); 
						count();
		 			}  
		 			//最小值限制
		 			function minValue(num){
		 				if($(num).val()==''||parseInt($(num).val())<=1){
		 					$(num).val(1);
		 				}
		 			}
		 			//数量加
		 			function add(add){
		 				var num = add.previousElementSibling;
		 				$(num).val(parseInt($(num).val())+1); 
		 				
		 				var tr = add.parentNode.parentNode;
		 				var p = parseFloat($(tr).find(".single_price").eq(0).html());
						var n = parseInt($(num).val());
						$(tr).find(".total_price").html(FloatMul(p,n));
		 				count();
		 			}
		 			//数量减
		 			function jian(jian){
		 				var num = jian.nextElementSibling;
		 				if(parseInt($(num).val())==1){
		 					alert("不能再减了！");
		 					return ;
		 				}
		 				$(num).val(parseInt($(num).val())-1);
		 				var tr = jian.parentNode.parentNode;
		 				var p = parseFloat($(tr).find(".single_price").eq(0).html());
						var n = parseInt($(num).val());
						$(tr).find(".total_price").eq(0).html(FloatMul(p,n)); 
		 				count();
		 			} 
		 			//乘法
		 			 function FloatMul(arg1,arg2)
					  {
					      var m=0,s1=arg1.toString(),s2=arg2.toString();
					      try{m+=s1.split(".")[1].length}catch(e){}
					      try{m+=s2.split(".")[1].length}catch(e){}
					      return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
					  } 
					  //+法
					   function FloatAdd(arg1,arg2){
					       var r1,r2,m;
					       try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
					       try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
					       m=Math.pow(10,Math.max(r1,r2));
					       return (arg1*m+arg2*m)/m;
					   }
					 //点击全选按钮
					  $("#all").click(function(){
						//当前复选框状态
						var ch=$(this).prop("checked");
						//alert(ch); 
						//设置集合的状态和复选框一致
						$(".good_chk").each(function(){
							$(this).prop("checked",ch)  
						}); 
						count();
					});
					//设置集合的状态和复选框一致
					$(".good_chk").click(function(){
						//遍
						$(".good_chk").each(function(){
							var ch=$(this).prop("checked")
							if(ch==false){
								$("#all").prop("checked",ch);
								return false;
							}
							//全选
							$("#all").prop("checked",true);
							return true;
						});   
						count();
					});
					
										
	//删除事件
function del(cid){
	$.ajax({
		type:"GET",
		url:"/MyShop/pre/cart/delcart/",
		data:{"cid":cid},
		dataType:"text",
		success:function(dataresult){
			if(dataresult=="true"){
				alert("删除成功!");
				location.href="/MyShop/pre/cart/cartpage"; 
			} else{
				alert("删除失败!");
			}  
		},
		error:function(dataresult){
			alert("后台数据请求错误,请联系管理员解决！");
		} 
	});
}
//收藏一个
function addheart(cid){
	$.ajax({
		type:"GET",
		url:"/MyShop/pre/cart/addheart",
		data:{"cid":cid},
		dataType:"text",
		success:function(dataresult){
			if(dataresult=="true"){ 
				alert("收藏成功!");
				location.href="/MyShop/pre/cart/cartpage"; 
			} else{
				alert("收藏失败!");
			}  
			alert(dataresult);
		},
		error:function(dataresult){
			alert("后台数据请求错误,请联系管理员解决！");
		} 
	});
}

//删除事件
function dels(){
	var ids = []; 
	$(".good_chk").each(function(){
		var ch=$(this).prop("checked");
		var id = $(this); 
		if(ch==true){
			ids.push(id.val()); 
		} 
	}); 
$.ajax({
	type:"GET",
	url:"/MyShop/pre/cart/delcarts/",
	contentType:"application/json",
	data:{"ids":ids},
	traditional:true,
	dataType:"text",
	success:function(dataresult){
		if(dataresult=="true"){
			alert("删除成功!");
			location.href="/MyShop/pre/cart/cartpage"; 
		} else{
			alert("删除失败!");
		}  
	},
	error:function(dataresult){
		alert("后台数据请求错误,请联系管理员解决！");
	} 
});
}			
//收藏事件S
function adds(){
	var ids = []; 
	$(".good_chk").each(function(){
		var ch=$(this).prop("checked");
		var id = $(this); 
		if(ch==true){
			ids.push(id.val()); 
		} 
	}); 
$.ajax({
	type:"GET",
	url:"/MyShop/pre/cart/addhearts/",
	contentType:"application/json",
	data:{"ids":ids},
	traditional:true,
	dataType:"text",
	success:function(dataresult){
		if(dataresult=="true"){
			alert("收藏成功!");
			location.href="/MyShop/pre/cart/cartpage"; 
		} else{
			alert("收藏失败!");
		}  
	},
	error:function(dataresult){
		alert("后台数据请求错误,请联系管理员解决！");
	} 
});
}			
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
						