<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  </head>
  
  <body bgcolor="pink">
 <center>
  用户登录 <br>
   <form action="LoginClServlet" method="post">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名<input type="text" name="username"><br>
   &nbsp;&nbsp;&nbsp;密&nbsp;码&nbsp;&nbsp;&nbsp;<input type="password" name="password"><br>
  <input type="submit" value="登录">
  <input type="reset" value="重置">
  </form>
  </center>
  </body>
</html>
