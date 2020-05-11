 	//轮播js 
	$(document).ready(function(){ 


		var left = ["-40",'-780','-1520','-780']; 
		var num = [1,2,3,2]; 
		begin();
		var index  = 0;/*公共变量----下标*/ 
		//计时器切换
		var interval ;
		//启动计时器
		function begin(){
			interval = setInterval(function changeImg(){
				if(index>=left.length-1){ 
					index = 0;//返回第一
				}else{
					index=index+1;
				}  
				pub();
			},5000);
		}
		$(".adver").mouseover(function(){//悬浮事件
			clearInterval(interval);  
			$(".op_prev").show();	
			$(".op_next").show();//显示
		}).mouseout(function(){//移开事件
			setTimeout(begin(),3000);//延迟加载
			$(".op_prev").hide();	
			$(".op_next").hide();//隐藏
		});
		//右点击
		$(".op_next").click(function(){ 
			clearInterval(interval);  
			var str=$(".adver").css("background-image") ;  
			if(index>=left.length-1){ 
				index = 0;//返回第一
			}else{
				index=index+1;
			} 
			 pub();
			setTimeout(begin(),3000);//延迟加载
		});
		//左点击
		$(".op_prev").click(function(){  
			clearInterval(interval); //清除
			if(index==0){ 
				index = left.length-1;//返回第一
			}else{
				index=index-1;
			} 
			 pub();
			setTimeout(begin(),3000);//延迟加载启动
		});   
		
		
		
		
		function  pub(){
			$("#slide_box").animate({ left:left[index]},2000);
			$(".adver .num li:nth-of-type("+num[index]+")").siblings().css("background","#333");
			$(".adver .num li:nth-of-type("+num[index]+")").css("background","#FFA500"); 
		}
	}); 
	
	
	
	
	
	
	
	
	
	
	
	
	
	