<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '403.jsp' starting page</title>
   

  </head>
  
  <body>
  <h2>Forbidden:请先登录,五秒后自动跳转登录页面...</h2> 
   <h3><a href="${pageContext.request.contextPath }/pre/login">若长时间未跳转请点击此处...<span class="glyphicon glyphicon-home" aria-hidden="true"></span></a> </h3>
             
  </body>
  <script type="text/javascript">
    	setTimeout(function(){location.href="/MyShop/pre/login"},5000);
   	</script>
</html>
