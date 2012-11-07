<!-- Main page user select vote question and go to editvote page here
@author Kunat Pipatanakul
@version 2012.11.07
-->
<%@page import="com.exceedvote.web.UserInfo"%>
<%@page import="com.exceedvote.controller.*"%>
<%@page import="com.exceedvote.core.*"%>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<%
//get client and userinfo from session
Client c =(Client) session.getAttribute("Cl");
UserInfo user = (UserInfo) session.getAttribute("user");
//TODO : how to select q num
//qnum = statement num. start at 1
int qnum = 1;
//send statement to session
Statement s = c.getStatement(qnum);
session.setAttribute("Statement",s);
%>
<!-- not nessecery here -->
<%= c %>
<%= application.getRealPath("/") %>
<!-- number of ballot user can vote -->
<%=c.findBallot(user.getUserid(),2).length %>
<!-- go to vote page -->
<A HREF="vote.jsp">Continue</A>
<!-- go to history page -->
<A href="history.jsp">HIStory</A>
</body>
</html>	