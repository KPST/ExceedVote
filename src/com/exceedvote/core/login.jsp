<!-- 
 login.jsp is a JSP file with checking the username and password for authentication. 
 @author Tanachot Teachajarupan
 @version 2012.10.23
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.exceedvote.core.Authentication" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
  String name = (String)session.getAttribute("txtUsername");
  String pass = (String)session.getAttribute("txtPassword");
	Authentication a = (Authentication)session.getAttribute("username");
  	boolean check = a.login(name,pass);
  	if(check) %><a href="vote.jsp"></a>
  	<% else %><a href="index.html"></a>
</body>
</html>