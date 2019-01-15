<%@page import="com.pojo.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<!--user.equals(null)-->
  </head>
<%   
	UserInfo user=(UserInfo)session.getAttribute("dq");
	System.out.println(user);
	if(user==null){
		request.setAttribute("error", "请登录");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
  <body>

    This is my JSP page. &nbsp; 欢迎 ${dq.userName} <br>
    	总共有 ${count}人访问过该网站
    <a href="SelectServlet">查询</a>
    <table border="1">
    
    <c:forEach  var="info" items="${list}">
  
    <tr>
   	 	
    	<td>${info.userName} </td>
    	<td>${info.userPass} </td>
    	<td>${info.realName} </td>
    	<td>${info.userAge} </td>
    	<td><a href="DeleteServlet?userid=${info.userID}">删除</a> </td>
    	
    
    </tr>
    
    </c:forEach>
    
    </table>
    
  </body>
</html>
