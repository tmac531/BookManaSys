<%@ page language="java" import="java.util.*,java.net.*"
	contentType="text/html; charset=utf-8"%>
<%


request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'UpdateBook.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
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
		<h2>请输入修改信息</h2>
		<br>
<%



 %>
		<form action="BookClServlet?flag=updatebook" method="post">
			
			<%
			String bookName=new String(request.getParameter("bookName").getBytes("ISO-8859-1"),"utf-8");
			 %>
			
			
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" readonly="readonly" name="bookid"
						value="<%=request.getParameter("bookId")%>" /></td>

				</tr>
				<tr>
					<td>书名</td>
					<td><input type="text" name="bookname"
						value="bookName"/></td>
				</tr>

				<tr>
					<td>作者</td>
					<td><input type="text" name="bookauthor"
						value="<%=request.getParameter("bookAuthor")%>" /></td>
				</tr>
			</table>
			<br> <input type="submit" name="提交" value="修改" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" name="重置" value="重置" />
		</form>



	</center>
</body>
</html>
