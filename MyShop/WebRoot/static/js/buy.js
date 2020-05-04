				function buy(ds){
					var a = $("input[name*='addressRadio']");
					//alert(a.length);
					for (var i = 0; i < a.length; i++) {
						var tmp = a[i].parentNode.parentNode;
						$(tmp).removeClass("active");
						$(" .show").hide();
					} 
					var p = ds.parentNode.parentNode;
					$(p).addClass("active");
					$(".active").find(".show").show();
					//parent  
					
					copyInfo();
				}
				function copyInfo(){
					var address = $(".active").find("#sAddress").html();
					var name = $(".active").find("#sName").html();
					var phone = $(".active").find("#sPhone").html();
					
					
					$("#cAddress").html(address);
					$("#cName").html(name);
					$("#cPhone").html(phone); 
				}
				copyInfo();
				//class =  totalPrice  singlePrice number
				
				
				
				