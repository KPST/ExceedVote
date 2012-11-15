<!-- Main page user select vote question and go to editvote page here
@author Kunat Pipatanakul
@version 2012.11.07
-->
<%@page import="com.exceedvote.controller.*"%>
<%@page import="com.exceedvote.core.*"%>
<%@page import="com.exceedvote.jpa.*" %>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
<link href="bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
  <style>
    #lo{
      color:#d71700;
      font-size: 32px;
    }
    .row{
    	margin-top: 15px;
    }
  </style>
</head>
<body>
<%
//get client and userinfo from session
Client c =(Client) session.getAttribute("Cl");
Auth user = (Auth) session.getAttribute("user");
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
			<li class="current_page_item"><a>Main Menu</a></li>
			<li><a href="history.jsp">History</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="welcome">
		<font id="lo">
			<br>
			Hi!
			<%= user.getId() %>
		</font>
		<br>
		<br>
		<!-- number of ballot user can vote -->
		Your remain ballot(s) is
		<%= user.getBallot() %>
		<!-- go to vote page -->
		<br>
		<br>
		<% for (int i = 0;i<c.statements.length;i++){
			Statement sd = c.statements[i];
		%>
			<div class="row">
			<div class="span2">
				<%= sd.getDescription() %>
			</div>
			<div class="span3">
			<div class="btn">
			<% out.print("<a href=\"checkVote.jsp?id="+sd.getId()+"\">Go to Vote!</a>"); %>
			</div>
			</div>
			</div>
		<% }%>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>
</body>
</html>	