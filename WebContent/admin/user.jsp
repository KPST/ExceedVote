
<%@page import="com.exceedvote.entity.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choice Edit</title>
<link rel="stylesheet" href="/ExceedVote/bootstrap/css/bootstrap.min.css"></link>
<link href="/ExceedVote/bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
	#test{
		font-size: 32px;
	}
	#table1{
		margin-top: 20px;
	}
	#spacc{
		width: 60px;
	}
</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Exceed<span>Vote</span></a></h1>
			<p>Vote the projects in eXceed Camp.</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="Admin.do?type=choice">Edit Choice</a></li>
			<li><a href="Admin.do?type=statement">Edit Statement</a></li>
			<li class="current_page_item"><a href="Admin.do?type=user">Edit User</a></li>
			<li><a href="Admin.do?type=role">Edit Role</a></li>
			<li><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Statement List</div>
		<br>
	<table id="table1">
<%
   User[] users = (User[]) request.getAttribute("usr");
   for(int i = 0 ; i < users.length ; i++){
	   	out.print("<form name=\"form1\" method=\"post\" action=\"Delete.do\"><tr><td>");
	   	out.print("id "+users[i].getId()+" user "+users[i].getUser()+" Role :");
	   	for(int j = 0 ; j < users[i].getRoles().size();j++){
	   		out.print(users[i].getRoles().get(j).getName()+":");
	   	}
		out.print("<input type=\"hidden\" name=\"id\" value="+users[i].getId()+">");
		out.print("<input type=\"hidden\" name=\"type\" value=user></td>");
		out.print("<td id=\"spacc\"></td><td><input class=\"btn\" type=\"submit\" value=Delete >");	
		out.print("</td></tr>");
		out.print("</form>");
   }
%>
	</table>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>

</body>
</html>