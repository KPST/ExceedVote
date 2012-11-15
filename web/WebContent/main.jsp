<!-- Main page user select vote question and go to editvote page here
@author Kunat Pipatanakul
@version 2012.11.07
-->
<%@page import="com.exceedvote.controller.*"%>
<%@page import="com.exceedvote.core.*"%>
<%@page import="com.exceedvote.jpa.*" %>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
  <style>
    #loginrow{
      margin-top: 50px;
      margin-bottom: 20px;
    }
    input{

    }
    #lo{
      color:#d71700;
      font-size: 32px;
    }
    body{
      background-color:#DDDDDD;
    }
  </style>
</head>
<body>
<%
//get client and userinfo from session
Client c =(Client) session.getAttribute("Cl");
Auth user = (Auth) session.getAttribute("user");
//TODO : how to select q num
//qnum = statement num. start at 1
//int qnum =  1;
//send statement to session
int size = c.statements.length;
//Statement s = c.getStatement(qnum);
//session.setAttribute("Statement",s);
%>
<font id="lo">
<br>
Hi!
<%= user.getId() %>
</font>
<br>
<br>
<!-- number of ballot user can vote -->
Your remain ballot(s) is
<%= user.getNoBallot() %>
<!-- go to vote page -->
<br>
<br>
<% for (int i = 0;i<size;i++){
	Statement s = c.getStatement(i);
	//session.setAttribute("Statement",s);
%>
<table border="1">
<tr>
<td>
<%= s.getDescription() %>
</td>
<td>
<% out.print("<a href=\"checkVote.jsp?id="+i+"\">Go to Vote!</a>"); %>
</td>
</tr>
</table>
<% }%>

<form method="POST" action="history.jsp">
  <input class="btn" type="submit" value="History">
</form>

<form method="POST" action="logout.jsp">
  <input class="btn" type="submit" value="LogOut">
</form>





</body>
</html>	