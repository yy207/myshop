	var img = new Array();/*公共变量----图片数组*/
	//轮播js 
	$(document).ready(function(){ 
		function getImage(){
			$.ajax({
				url:"imagelist",
				type:"get",
				data:"type=1",
				dataType:"json",
				success:function(result){
					img.length = result.length;
					for ( var int = 0; int < result.length; int++) {
						img[int] = result[int].path;
					} 
				},
				error:function(data){
					alert("后台数据请求错误！");
				}
			}); 
		}
		getImage();
		begin();
		var index  = 0;/*公共变量----下标*/ 
		//计时器切换
		var interval ;
		//启动计时器
		function begin(){
			interval = setInterval(function changeImg(){
				if(index==img.length-1){ 
					index = 0;//返回第一
				}else{
					index=index+1;
				} 
				$(".adver").css("background","url(../statics/localimg/"+img[index]+") ");//  
				$(".adver").animate({"background-position":-750},1000);
				$(".adver li:nth-of-type("+(index+1)+")").siblings().css("background","#333");
				$(".adver li:nth-of-type("+(index+1)+")").css("background","#FFA500"); 
			},2000);
		}
		$(".adver").mouseover(function(){//悬浮事件
			clearInterval(interval);  
			$(".arrowLeft").show();	
			$(".arrowRight").show();//显示
		}).mouseout(function(){//移开事件
			setTimeout(begin(),3000);//延迟加载
			$(".arrowLeft").hide();	
			$(".arrowRight").hide();//隐藏
		});
		//右点击
		$(".arrowRight").click(function(){ 
			clearInterval(interval);  
			var str=$(".adver").css("background-image") ;  
			if(index==img.length-1){ 
				index = 0;//返回第一
			}else{
				index=index+1;
			} 
			$(".adver").css("background","url(../statics/localimg/"+img[index]+") ");//
//			$(".adver").animate({"background-position":-750},1000);//动画
			$(".adver li:nth-of-type("+(index+1)+")").siblings().css("background","#333");
			$(".adver li:nth-of-type("+(index+1)+")").css("background","#FFA500"); 
			setTimeout(begin(),3000);//延迟加载
		});
		//左点击
		$(".arrowLeft").click(function(){  
			clearInterval(interval); //清除
			if(index==0){ 
				index = img.length-1;//返回第一
			}else{
				index=index-1;
			} 
			$(".adver").css("background","url(../statics/localimg/"+img[index]+")");// 
//			$(".adver").animate({"background-position":700},1000);//动画
			$(".adver li:nth-of-type("+(index+1)+")").siblings().css("background","#333");
			$(".adver li:nth-of-type("+(index+1)+")").css("background","#FFA500"); 
			setTimeout(begin(),3000);//延迟加载启动
		});   
	}); 