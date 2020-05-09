					//最小值限制
		 			function minValueNum(num){
		 				if($(num).val()==''||parseInt($(num).val())<=1){
		 					$(num).val(1);
		 				}
		 				count();
		 			}
		 			//数量加
		 			function jiaNum(add){
		 				var num = add.previousElementSibling;
		 				$(num).val(parseInt($(num).val())+1);
		 				count();
		 			}
		 			//数量减
		 			function jianNum(jian){
		 				var num = jian.nextElementSibling;
		 				if(parseInt($(num).val())==1){
		 					alert("不能再减了！");
		 					return ;
		 				}
		 				$(num).val(parseInt($(num).val())-1);  
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
		 			 function count(){
		 				var p = $("#singlePrice").html();
						var n = $(num).val();
						if($("#totalPrice")!=null){
							$("#totalPrice").html(FloatMul(p,n));
							$("#total").html(FloatMul(p,n));
							$("#price").html(FloatMul(p,n));
						}
		 			 }