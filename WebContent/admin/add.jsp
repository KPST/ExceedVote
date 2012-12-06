<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.exceedvote.jpa.User"%>
    <%@page import="com.exceedvote.controller.Client"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add</title>
</head>
<body>
<% User a = (User)session.getAttribute("user");
if(a.hasRoles("Admin")){
String type = request.getParameter("type");
Client c = (Client)session.getAttribute("Cl");
if(type.equals("choice")){
	String name = request.getParameter("name");
	String des = request.getParameter("des");
	String img = request.getParameter("img");
	c.addChoice(name, des,img);
	System.out.println("add choice "+name+" "+des+" "+img);
	response.sendRedirect("choice.jsp");
}
else if(type.equals("statement")){
	String des = request.getParameter("des");
	c.addStatement(des);
	System.out.println("add statement "+des);
	response.sendRedirect("statement.jsp");
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