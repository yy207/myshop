			//登录切换界面
			function changeform(type,p){
				if(type==1){
					$("#form_password").show();
					$("#form_email").hide();
					$("#title_email").css("border-bottom","none");
					$(p).css("border-bottom","2px #000000 solid");
				}else{
					$("#form_password").hide();
					$("#form_email").show();
					$("#title_pwd").css("border-bottom","none");
					$(p).css("border-bottom","2px #000000 solid");
				}
				
			}