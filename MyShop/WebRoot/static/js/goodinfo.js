//最小值限制
		 			function minValue(num){
		 				if($(num).val()==''||parseInt($(num).val())<=1){
		 					$(num).val(1);
		 				}
		 			}
		 			//数量加
		 			function jia(add){
		 				var num = add.previousElementSibling;
		 				$(num).val(parseInt($(num).val())+1);  
		 			}
		 			//数量减
		 			function jian(jian){
		 				var num = jian.nextElementSibling;
		 				if(parseInt($(num).val())==1){
		 					alert("不能再减了！");
		 					return ;
		 				}
		 				$(num).val(parseInt($(num).val())-1);  
		 			} 
		 			//添加购物车
					function addCart(gid,sid){
						var num = $("#num").val();
						$.ajax({
							type:"GET",
							url:"/MyShop/pre/cart/addcart/",
							data:{"gid":gid,"sid":sid,"num":num},
							dataType:"text",
							success:function(dataresult){
								if(dataresult=="true"){
									alert("添加成功!"); 
									//location.href="/MyShop/pre/goodinfo/"+gid+"/"+sid;
								} else{
									alert("添加失败!");
								}  
							},
							error:function(dataresult){
								alert("后台数据请求错误,请联系管理员解决！");
							} 
						});
					}