<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.exceedvote.controller.*"%>
<%@page import="com.exceedvote.core.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
   Client c =(Client) session.getAttribute("Cl");
   int id = Integer.parseInt(request.getParameter("id"));
   int question = Integer.parseInt(request.getParameter("question"));
   int choice = Integer.parseInt(request.getParameter("choice"));
   c.vote(id, question, choice);
%>
<!-- Redirect to main project page -->
<% response.sendRedirect("voted.jsp");
%>
</body>
</html>