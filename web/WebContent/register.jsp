<%@page import="com.exceedvote.core.ExceedJpaFactory"%>
<%@page import="com.exceedvote.controller.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String user = request.getParameter("username");
   String pass = request.getParameter("password");
   Authentication c = new Authentication(ExceedJpaFactory.getInstance().getDAO());
   String ip = request.getRemoteAddr();
   c.addUser(user, pass, 1, ip);
   session.invalidate();
   response.sendRedirect("index.jsp");
	%>
</body>
</html>