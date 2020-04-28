<%@page import="cn.main.utils.Contains"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">


<title>欢迎登录:${sessionUser.userName }</title>
<%@ include file="css.jsp"%>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col menu_fixed">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span> My Shop </span>
						</a>
					</div>
					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile">
						<div class="profile_pic">
							<img
								src="${pageContext.request.contextPath }/statics/images/${sessionUser.userPic}"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>${sessionUser.userName }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->
					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3 style="display:block;" id="time">NOW:</h3>
							<ul class="nav side-menu">
								<!-- 管理员账户的权限操作功能======================================= 1 -->
								<c:if test="${sessionUser.userRole == 1 }"></c:if>
								<li><a><i class="fa fa-home"></i> 用户管理 <span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="../user/userlist">用户查询</a>
										</li>
										<li><a href="../user/add">新用户注册</a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> 商店管理 <span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="../shop/shoplist">商店查询</a>
										</li>
										<li><a href="../shop/add">商店注册</a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> 商品管理 <span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="../good/goodlist">商品查询</a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-table"></i>订单管理<span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="general_elements.html">订单查询</a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-desktop"></i>审核管理<span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="tables.html">审核记录</a>
										</li>
										<li><a href="tables_dynamic.html">待审核信息</a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> 代办信息 <span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="chartjs.html">我的信息</a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span
										class="fa fa-chevron-down"></span>
								</a>
									<ul class="nav child_menu">
										<li><a href="#level1_1">Level One</a>
										<li><a>Level One<span class="fa fa-chevron-down"></span>
										</a>
											<ul class="nav child_menu">
												<li class="sub_menu"><a href="level2.html">Level
														Two</a></li>
												<li><a href="#level2_1">Level Two</a></li>
												<li><a href="#level2_2">Level Two</a></li>
											</ul></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a href="${pageContext.request.contextPath }/user/loginout" data-toggle="tooltip"
							data-placement="top" title="Logout"> <span
							class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> 
						<a href="${pageContext.request.contextPath }/main/index"> <span
							class="glyphicon glyphicon-home" aria-hidden="true"></span> </a>

					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i>
							</a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img
									src="${pageContext.request.contextPath }/statics/images/${sessionUser.userPic}"
									alt="">${sessionUser.userName } <span
									class=" fa fa-angle-down"></span> </a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="${pageContext.request.contextPath }/main/index"> Go Shopping</a></li>
									<li><a href="javascript:;"> <span
											class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a></li>
									<li><a href="${pageContext.request.contextPath }/user/loginout"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a>
									</li>
								</ul></li>

							<li role="presentation" class="dropdown"><a
								href="javascript:;" class="dropdown-toggle info-number"
								data-toggle="dropdown" aria-expanded="false"> <i
									class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
									role="menu">
									<li><a> <span class="image"><img src=""
												alt="Profile Image" />
										</span> <span> <span>John Smith</span> <span class="time">3
													mins ago</span> </span> <span class="message"> Film festivals used
												to be do-or-die moments for movie makers. They were where...
										</span> </a></li>
									<li>
										<div class="text-center">
											<a> <strong>See All Alerts</strong> <i
												class="fa fa-angle-right"></i> </a>
										</div></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">