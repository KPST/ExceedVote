<!-- CheckVote is the check the statement which is chosen from the main.jsp and send a redirection to vote.jsp
@author Tanachot Teachajarupan
@version 2012.11.15
-->
<%@page import="com.exceedvote.jpa.Statement"%>
<%@page import="com.exceedvote.jpa.Ballot"%>
<%@page import="com.exceedvote.controller.*" %>
<%@page import="com.exceedvote.jpa.User" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

CheckVote
<%=request.getParameter("id") %>
<%
int id = Integer.parseInt(request.getParameter("id"));
User userinfo = (User)session.getAttribute("user");
Client cl = (Client)session.getAttribute("Cl");
Statement st  = cl.getStatement(id);
session.setAttribute("Statement", st);
response.sendRedirect("vote.jsp");

%>

</body>
</html>