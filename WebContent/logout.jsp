<!-- 
 logout.jsp clears all session from the using and redirect to a login.html 
 @author Tanachot Teachajarupan
 @version 2012.11.13
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<center>
		<%
		session.invalidate();
		response.sendRedirect("index.jsp");
		%>
	</center>


</body>
</html>