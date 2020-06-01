<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我要开店</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/shopindex.css" />
	</head>
	<body>
		<!--背景-->
		<div class="bg">
			<div class="img">
				<!--<img src="${pageContext.request.contextPath }/static/img/bg.png"/>-->
			</div> 
		</div>
		<div class="b_bk"></div>
		<!--导航-->
		<div class="header">
			<div class="logo">
				<a href="#">
					<img src="${pageContext.request.contextPath }/static/img/shoplogo.png" width="200"/>
				</a>
			</div>
			<div class="ul">
				<ul>
					<li class="active"><a href="#">0元开店</a> </li>
					<li><a href="#">开店教程</a></li>
					<li><a href="#">常见问题</a></li>
				</ul>
			</div>
		</div>
	 	
	 	<!--主题文字-->
	 	<div class="txt">
	 		<div class="big">
	 			<span>淘宝免费开店</span>
	 		</div>
	 		<div class="commont">
	 			<span>让天下没有难做的生意</span>
	 		</div>
	 		<div class="btn">
	 			<a href="${pageContext.request.contextPath }/pre/shop/shop" class="c">
	 				<span>企业店铺入驻</span>
					<img src="${pageContext.request.contextPath }/static/img/s_r_right.png" width="9" height="14" />
	 			</a>
	 			<a href="${pageContext.request.contextPath }/pre/shop/shop" class="p">
	 				<span>个人店铺入驻</span>
					<img src="${pageContext.request.contextPath }/static/img/sp_right.png" width="9" height="14" />
	 			</a>
	 		</div>
	 	</div>
	 
	 <!--中部矩形-->
	 <div class="rang">
	 	<div class="sp">
	 		<div class="img">
	 			<img src="${pageContext.request.contextPath }/static/img/shop.png" width="110" height="110"/>
	 		</div>
	 		<div class="item_name">
	 			0元开店
	 		</div>
	 		<div class="item_desc">
	 			开店无需任何费用
	 		</div>
	 	</div>
	 		<div class="sp">
	 		<div class="img">
	 			<img src="${pageContext.request.contextPath }/static/img/together.png" width="110" height="110"/>
	 		</div>
	 		<div class="item_name">
				新商家成长
	 		</div>
	 		<div class="item_desc">
				官方交流群，带你快速破单晋级
	 		</div>
	 	</div>
	 		<div class="sp">
	 		<div class="img">
	 			<img src="${pageContext.request.contextPath }/static/img/prople.png" width="110" height="110"/>
	 		</div>
	 		<div class="item_name">
	 				 海量用户
	 		</div>
	 		<div class="item_desc">
					海量消费者，大量需求
	 		</div>
	 	</div>
	 		<div class="sp">
	 		<div class="img">
	 			<img src="${pageContext.request.contextPath }/static/img/world.png" width="110" height="110"/>
	 		</div>
	 		<div class="item_name">
	 			全球货源
	 		</div>
	 		<div class="item_desc">
	 			拥有全球供应商提供高品质，多品类，货源丰富，无忧进货
	 		</div>
	 	</div> 
	 </div>
	 
	 <div class="p">
	 	加入淘宝，一起走向致富之路，未来你将成为他们
	 </div>

	 <div class="cards" id="cards">
	 	<div class="left">
			<a href=""><img src="${pageContext.request.contextPath }/static/img/s_left3.png"  width="18" height="28"/> </a>
		</div>
		<div class="container" >
			<!--1-->
			<div class="expl-card-container">
				<div class="card-bg">
					<img class="card-bg-img" src="${pageContext.request.contextPath }/static/img/tbf.png" width="250px" height="370px">
				</div>
				
				<div class="expl-card-content">
					<div class="expl-card-header">
						<div class="card-header-info">
							<img class="shop-logo" src="${pageContext.request.contextPath }/static/img/wwf.jpg" width="37" height="37" >
							<div class="shop-name">
								老爸评测会员店
							</div>
						</div>
						<div class="shop-tag">专业型人才</div>
					</div>
					<div class="shop-story">浙大硬核老爸魏文峰，因2015年偶然一次机会把女儿的包书皮检测后发现有致癌物质。他便自掏腰包开淘宝店、做日用品化学检测，帮助求助的家长们检测塑胶操场等。还曾被有人恶意破坏服务器，删了实验室数据。魏老爸说：假劣毒产品不停步的话，我们评测就不停手。
					</div>
					
				</div>
				<div class="card-bg-tag">
						<img src="${pageContext.request.contextPath }/static/img/sr.png" width="35" height="40">
					</div>
			</div>
			<!--2-->
			<div class="expl-card-container">
				<div class="card-bg">
					<img class="card-bg-img" src="${pageContext.request.contextPath }/static/img/wy.jpg" width="250px" height="370px">
				</div>
				
				<div class="expl-card-content">
					<div class="expl-card-header">
						<div class="card-header-info">
							<img class="shop-logo" src="${pageContext.request.contextPath }/static/img/wyxx.jpg" width="37" height="37" >
							<div class="shop-name">
								薇娅
							</div>
						</div>
						<div class="shop-tag">超人气主播</div>
					</div>
					<div class="shop-story">薇娅，淘宝超人气主播。此前，她常年排名第一，曾2小时引导成交2.67亿元。自入行以来，薇娅几乎全年无休，虽在巅峰，一刻也不敢放松。她说，自己身后是几十家工厂的生计，几百万粉丝的信赖，是压力，更是责任。</div>
					
				</div>
				<div class="card-bg-tag">
						<img src="${pageContext.request.contextPath }/static/img/sr.png" width="35" height="40">
				</div>
			</div>
			<!--3-->
			<div class="expl-card-container">
				<div class="card-bg">
					<img class="card-bg-img" src="${pageContext.request.contextPath }/static/img/ww.png" width="250px" height="370px">
				</div>
				
				<div class="expl-card-content">
					<div class="expl-card-header">
						<div class="card-header-info">
							<img class="shop-logo" src="${pageContext.request.contextPath }/static/img/www.jpg" width="37" height="37" >
							<div class="shop-name">
								TRUCE
							</div>
						</div>
						<div class="shop-tag">真正男子汉</div>
					</div>
					<div class="shop-story">2016年在《真正男子汉》被杨幂、佟丽娅、孙杨等人称为“小威威”的班长王威，是一名十足90后，却已成为了最尖刀部队的特种兵。如今退役后的他重新进入社会，响应国家政策，军人再创业做军旅元素潮牌，想让中国人穿上自己文化的潮牌服饰，整洁精神，积极时尚。</div>
					
				</div>
				<div class="card-bg-tag">
						<img src="${pageContext.request.contextPath }/static/img/sr.png" width="35" height="40">
				</div>
			</div>
			<!--4-->
			<div class="expl-card-container">
				<div class="card-bg">
					<img class="card-bg-img" src="${pageContext.request.contextPath }/static/img/jr.png" width="250px" height="370px">
				</div>
				<div class="expl-card-content">
					<div class="expl-card-header">
						<div class="card-header-info">
							<img class="shop-logo" src="${pageContext.request.contextPath }/static/img/jrr.jpg" width="37" height="37" >
							<div class="shop-name">
								战地婚纱
							</div>
						</div>
						<div class="shop-tag">退伍军人</div>
					</div>
					<div class="shop-story">「战地婚纱」退伍兵楼超和4个战友退役后拿出全部退伍费开了一家军人婚纱照淘宝店。他说全国那么多家影楼，没有一家是专门为军人开的。他最懂部队，而部队也懂他，所以他能拍出最有军味儿的照片。因为职业的特殊性，军嫂不远千里飞过来，有的照片甚至是孩子出生九个月以来第一次与父亲合影。军嫂跟军人一样伟大！</div>
				</div>
				<div class="card-bg-tag">
						<img src="${pageContext.request.contextPath }/static/img/sr.png" width="35" height="40">
				</div>
			</div>
			
		</div>
		<div class="right">
			<a href=""><img src="${pageContext.request.contextPath }/static/img/s_r_right.png" width="18" height="28" /> </a>
		</div>
	
	 </div>
	<div class="p">
		现在加入，立享新商家专享优惠礼包
	</div>
	<div class="p" >
		<img src="${pageContext.request.contextPath }/static/img/nav.png" width="1000px" />
	</div> 
	 
	 <div class="footer">
	 	<div class="footer-inner">
	 		<div class="qrcode">
	 			<div class="qrcode-item">
	 				<img src="${pageContext.request.contextPath }/static/img/qn.png" width="100" height="100"/>
	 				<div class="qrcode-item-desc">
	 					<div>扫描二维码下载</div>
	 					<div>千万卖家都在用的「千牛APP」
	 					</div>
	 					<div>
	 					</div>
	 				</div>
	 			</div>
	 			<div class="qrcode-item">
	 				<img src="${pageContext.request.contextPath }/static/img/dd.png" width="100" height="100">
	 				<div class="qrcode-item-desc">
	 					<div>扫描二维码下载钉钉</div>
	 					<div>加入淘宝商家官方群</div><div></div>
	 				</div>
	 			</div>
	 		</div>
	 		<div class="contact">
	 			<div class="contact-title">联系我们</div>
				<div class="contact-desc">
					<p>万象在线咨询：<a target="_blank" href="javascript:void(0)">点我咨询</a></p>
	 				<p>开店咨询热线（9:00 至 21:00）</p>
	 				<p>0571 - 8815 7858</p>
				</div>
			</div>
	 	</div>
	 </div>
	 
	 
	
	</body>
</html>
