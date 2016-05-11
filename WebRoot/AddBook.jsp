<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'AddBook.jsp' starting page</title>

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
		<h2>请输入图书信息</h2>
		<br>

		<form action="BookClServlet?flag=addbook" method="post">
			<table>
				<tr>
					<td>书名</td>
					<td><input type="text" name="bookname"/></td>
				</tr>

				<tr>
					<td>作者</td>
					<td><input type="text" name="bookauthor"/></td>
				</tr>
			</table><br>
			<input type="submit" name="提交" value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset"  name="重置" value="重置"/>
		</form>



	</center>
</body>
</html>
