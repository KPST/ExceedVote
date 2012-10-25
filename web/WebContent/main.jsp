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
<title>Insert title here</title>
</head>
<body>
<%
Client c =(Client) session.getAttribute("Cl");
UserInfo user = (UserInfo) session.getAttribute("user");
//qnum = statement num. start at 0
int qnum = 2;
Statement s = c.getStatement(qnum);
session.setAttribute("Statement",s); 
session.setAttribute("snum", qnum);%>
<%= c %>
<A HREF="vote.jsp">Continue</A>
<A href="history.jsp">HIStory</A>
</body>
</html>	