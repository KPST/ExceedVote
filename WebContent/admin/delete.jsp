<%@page import="com.exceedvote.controller.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.exceedvote.jpa.User"%>
    <%@page import="com.exceedvote.controller.Client"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User a = (User)session.getAttribute("user");
if(a.hasRoles("Admin")){
int id = Integer.parseInt(request.getParameter("id"));
String type = request.getParameter("type");
Client c = (Client)session.getAttribute("Cl");
if(type.equals("choice")){
	c.deleteChoice(id);
	System.out.println("delete choice "+id);
	response.sendRedirect("choice.jsp");
}
else if(type.equals("statement")){
	c.deleteStatement(id);
	System.out.println("delete statement "+id);
	response.sendRedirect("statement.jsp");
}
else if(type.equals("user")){
	c.deleteUser(id);
	System.out.println("delete user "+id);
	response.sendRedirect("user.jsp");
}
else{
	System.out.println("type fail");
	
}
}
else{
	System.out.println("GG");
	response.sendRedirect("fail.jsp");
}
%>
</body>
</html>