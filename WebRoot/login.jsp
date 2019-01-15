<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page isELIgnored ="false" %>

<!DOCTYPE HTML  >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	

  </head>
  
  <body>
    This is my JSP page. <br>
    <a href="SelectServlet">超链接</a>
    <form action="Loginservlet" method="post">
       
   		<input type="text" name="user" placeholder="用户名" required="required">${error}
    	<input type="password" name="password" placeholder="密 码" required="required">
    	<button type="submit">登录</button>


</form>

  </body>
</html>
