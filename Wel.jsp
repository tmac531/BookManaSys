<%@ page language="java" import="java.util.*,com.model.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#CDCFFF">
  <center>
  <h2>图书列表</h2> <br>
  <a href="AddBook.jsp"><h3>增加图书</h3></a><br>

  
  <table border="1">
  
  <%
  ArrayList al=(ArrayList)request.getAttribute("result");
  
   %>
  
  
  <tr>
  
  <td>序号</td><td>书名</td><td>作者</td><td>修改</td><td>删除</td>
  
  </tr>
  
  <%
  
  for(int i=0;i<al.size();i++)
  {
  
  BookBean bb=(BookBean)al.get(i);
  
  
  
   %>
  <tr>
  
 
  
  <td><%=bb.getBookId() %></td><td><%=bb.getBookName() %></td><td><%=bb.getBookAuthor() %></td><td><a href="UpdateBook.jsp?bookName=<%=bb.getBookName()%>&bookAuthor=<%=bb.getBookAuthor()%>&bookId=<%=bb.getBookId() %>">修改</a></td>      
  
  <td><a href="BookClServlet?flag=delBook&bookId=<%=bb.getBookId() %>">删除</a></td>
  
  </tr>
  <%
   }
   %>
 

  </table>
  <% 
  int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));
  if(pageNow!=1)
  
  out.println("<a href=BookClServlet?flag=fenye&pageNow="+(pageNow-1)+">上一页</a>");
  
  
  String pageCount_2=(String)request.getAttribute("pageCount");
  int pageCount=Integer.parseInt(pageCount_2);
  
  for(int i=1;i<=pageCount;i++)
  out.println("<a href=BookClServlet?flag=fenye&pageNow="+i+">"+i+"</a>");
  
  
  if(pageNow!=pageCount)
   out.println("<a href=BookClServlet?flag=fenye&pageNow="+(pageNow+1)+">下一页</a>");
   %>
  
  
  
  
  
  
  
  
  
  </center>
  </body>
</html>
