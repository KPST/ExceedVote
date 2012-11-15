<%@page import="com.exceedvote.jpa.Auth"%>
<%@page import="com.exceedvote.controller.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Edit</title>
</head>
<body>
<% Client c = (Client) session.getAttribute("Cl");
   Auth[] a = c.getUser();
   for(int i = 0 ; i < a.length ; i++){
	   out.println("id "+a[i].getId()+" user "+a[i].getUser());
	   out.println("<a href=\"delete.jsp?id="+a[i].getId()+"&type=user\">delete</a>");
	   out.println("<br>");
   }
%>
</body>
</html>