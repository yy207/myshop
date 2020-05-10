//删除所有
					function delall(){
						var ok = confirm("确定要删除吗？这将会删除你所有的历史记录");
						if(ok){
							$.ajax({
								type:"GET",
								url:"/MyShop/pre/history/deleteall",
								data:null,
								dataType:"text",
								success:function(dataresult){
									if(dataresult=="true"){
										alert("删除成功!"); 
										location.href="/MyShop/pre/history/historypage";
									} else{
										alert("删除失败!");
									}  
								},
								error:function(dataresult){
									alert("后台数据请求错误,请联系管理员解决！");
								} 
							});
						}
						
					}