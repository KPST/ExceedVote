<%@page import="com.exceedvote.jpa.User"%>
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
<b>User List</b>
<br>
<% Client c = (Client) session.getAttribute("Cl");
   User[] a = c.getUser();
   for(int i = 0 ; i < a.length ; i++){
	   out.println("id "+a[i].getId()+" user "+a[i].getUser());
	   out.println("<a href=\"delete.jsp?id="+a[i].getId()+"&type=user\">delete</a>");
	   out.println("<br>");
   }
%>
<br>
<form method="POST" action="index.jsp">
  <input class="btn" style="height: 40px; width: 100px" type="submit" value="Back to Menu">
</form>

</body>
</html>