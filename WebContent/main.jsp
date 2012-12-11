<!-- Main page user select vote question and go to editvote page here
@author Kunat Pipatanakul
@version 2012.11.07
-->
<%@page import="com.exceedvote.model.*"%>
<%@page import="com.exceedvote.entity.*" %>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
    #welcome{
    	min-height: 350px;
    }
  </style>
</head>
<body>
<%
	//get client and userinfo from session
//ContentController c = ContentController.getInstance();

User user = (User) session.getAttribute("user");
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
			<li><a href="History.do">History</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="welcome">
		<font id="lo">
			<br>
			Hi!
			<%= user.getUser() %>
		</font>
		<br>
		<br>
		<!-- number of ballot user can vote -->
		
		<!-- go to vote page -->
		<br>
		<br>
		<%
		Statement[] sts = (Statement[])request.getAttribute("statement");
		int[][] ballotinfo = (int[][]) request.getAttribute("ballotinfo");
		//Statement[] sts = c.getStatement();
		for (int i = 0;i < sts.length;i++){
		%>
			<div class="row">
			<div class="span2">
			<% out.print(sts[i].getDescription()); %>
			<% out.print("   "+ballotinfo[i][0]+"/"+ballotinfo[i][1]+" "); %>
			</div>
			<div class="span3">
			<div class="btn">
			<% out.print("<a href=\"goVote.do?id="+sts[i].getId()+"\">Go to Vote!</a>"); %>
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