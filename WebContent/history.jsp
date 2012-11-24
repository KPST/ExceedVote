<%@page import="com.exceedvote.jpa.Ballot"%>
<%@page import="com.exceedvote.controller.*" %>
<%@page import="com.exceedvote.jpa.Auth" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote History</title>
</head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
<link href="bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
<style>
    .row{
    	margin-top: 15px;
    	margin-left: 10px;
    }
    #lo{
      color:#d71700;
      font-size: 32px;
    }
    #welcome{
    	min-height: 350px;
    }
  </style>
<body>
<%
Auth user = (Auth)session.getAttribute("user");
Client c = (Client)session.getAttribute("Cl");
%>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Exceed<span>Vote</span></a></h1>
			<p>Vote the projects in eXceed Camp .</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="main.jsp">Main Menu</a></li>
			<li class="current_page_item"><a>History</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="welcome">
		<font size="3">
<%
	int statementlength = c.statements.length;	
	for(int i = 0 ; i < statementlength ;i++){
	int sid = c.statements[i].getId();
	%>
	<font size="5" color="#d71700">
	<%
	out.println(c.statements[i].getDescription());
	Ballot[] b = c.findBallot(user.getId(), sid);
	out.print("</font><br>");
	for(int j = 0 ; j < b.length ;j++){
		%><div class="row"><%
			out.print(" - Your vote is "+b[j].getChoice()+" ");
			%><div class="btn"><%
			out.print("<a href=\"delete.jsp?id="+b[j].getId()+"\">edit</a>");
			%></div>
		</div><%
		out.print("<br>");
		
	}
	out.print("<br>");
}
%>		
	</div>
</div>
</font>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>
</body>
</html>