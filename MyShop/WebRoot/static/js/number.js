					//最小值限制
		 			function minValue(num){
		 				if($(num).val()==''||parseInt($(num).val())<=1){
		 					$(num).val(1);
		 				}
		 				count();
		 			}
		 			//数量加
		 			function jia(add){
		 				var num = add.previousElementSibling; 
		 				$(num).val(parseInt($(num).val())+1); 
		 				 
		 				var tr = add.parentNode.parentNode;
		 				var p = parseFloat($(tr).find(".single_price").eq(0).html());
						var n = parseInt($(num).val());
						$(tr).find(".totalPrice").html(FloatMul(p,n)); 
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
						$(tr).find(".totalPrice").html(FloatMul(p,n));
		 				count(); 
		 			} 
		 			/** 
		 			* 乘法运算，避免数据相乘小数点后产生多位数和计算精度损失。 
		 			* 
		 			* @param num1被乘数 | num2乘数 
		 			*/ 
		 			function FloatMul(num1, num2) { 
		 				var baseNum = 0; 
			 			try { 
			 				baseNum += num1.toString().split(".")[1].length; 
			 				} catch (e) { 
			 			} 
			 			try { 
			 				baseNum += num2.toString().split(".")[1].length; 
			 			} catch (e) { 
			 				
			 			} 
			 			return Number(num1.toString().replace(".", "")) * Number(num2.toString().replace(".", "")) / Math.pow(10, baseNum); 
		 			}; 
//		 			//乘法
//		 			 function FloatMul(arg1,arg2)
//					  {
//					      var m=0,s1=arg1.toString(),s2=arg2.toString();
//					      try{m+=s1.split(".")[1].length}catch(e){}
//					      try{m+=s2.split(".")[1].length}catch(e){}
//					      return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
//					  } 
		 			  //+法
					   function FloatAdd(arg1,arg2){
					       var r1,r2,m;
					       try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
					       try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
					       m=Math.pow(10,Math.max(r1,r2));
					       return (arg1*m+arg2*m)/m;
					   }
		 			 function count(){ 
		 				var count=0;
						var totalPrice=0;
						$("tr.order_info").each(function(){  
								count++; 
								var nums =$(this).find(".totalPrice").eq(0).html();
								//alert(num);
								totalPrice+=FloatAdd(0,nums) ;
						}); 
						$("#total_price").html(totalPrice);
						$("#realMoney").html(totalPrice); 	
		 			 }