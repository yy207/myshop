<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/nav.jsp" %>
		<div class="login">
			<div class="header">
				<div class="left">
					<a href="First.html">
						<img src="${pageContext.request.contextPath }/static/img/logo.png" />
					</a> 
				</div>
			 
			</div>
			<hr />
			<div class="section">
				<div class="left">
					<img src="${pageContext.request.contextPath }/static/img/loadimg.jpg" />
				</div>
				<div class="right">
					<!--表单-->
					<form action="${pageContext.request.contextPath}/pre/dologin" method="post">
						<p class="p1">
							<strong>用户登录</strong>
							<a href="${pageContext.request.contextPath }/main/register"style="color: blue;" >注册账号</a>
						</p>
						<p class="p2">
							<input name="userCode" id="userCode" value="${userCode }" required type="text"placeholder="Username"/> 
						</p>
						<p class="p3">
							<input name="userPassword" id="userPassword" value="${userPassword }" required type="password" placeholder="Password"/> 
						</p> 
						<p style="color:red; text-align: left;">&nbsp;${error}</p>
						<p class="p4">
							<input type="checkbox" name="auto" id="auto" />
							<label for="auto">保存用户名和密码</label>
							<a href="">忘记密码？</a>
						</p>
						<p class="p5">
							<input type="submit" name="submit"value="登录" />
						</p>
						<div class="p6">
							更多合作网站账号登录
						</div>
						<p class="p7">
							<a href="" class="a1 aimg" > </a>
							<a href="" class="a2 aimg">  </a>
							<a href="" class="a3 aimg">  </a>
							<a href="" class="a4 aimg"> </a>
							<a href="" class="a5">
								更多合作网站
							</a>
						</p>
					</form>
					
				</div>
			</div>
			
			<div class="footer">
				<p>
					沪ICP备13044278号 | 合字B1.B2-20130004 | 营业执照
				</p>
				<p>
					Copyright &copy; 1号店网上超市2007-2016 ，AllRights Reserved
				</p>
			</div>
			
		</div>
	</body>
</html>

