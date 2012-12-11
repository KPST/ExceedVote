
<%@page import="com.exceedvote.entity.Role" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Edit</title>
<link rel="stylesheet" href="/ExceedVote/bootstrap/css/bootstrap.min.css"></link>
<link href="/ExceedVote/bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
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
			<li><a href="Admin.do?type=statement">Edit Choice</a></li>
			<li><a href="Admin.do?type=statement">Edit Statement</a></li>
			<li><a href="Admin.do?type=user">Edit User</a></li>
			<li class="current_page_item"><a href="Admin.do?type=role">Edit Role</a></li>
			<li><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<b>Role List</b>
		<br>
		<%
				Role[] roles = (Role[]) request.getAttribute("role");
				for(int i = 0 ; i < roles.length ; i ++){
					out.print("<form name=\"form1\" method=\"post\" action=\"Delete.do\">");
					out.print(roles[i].getName()+" ");
					out.print("<input type=\"hidden\" name=\"id\" value="+roles[i].getId()+">");
					out.print("<input type=\"hidden\" name=\"type\" value=role>");
					out.print(" <input class=\"btn\" type=\"submit\" value=Delete>");
					out.print("</form>");
				}
				out.print("Note : when you delete role all user will be delete.<br><br><br> ");
		%>
		<form name="form1" method="post" action="Add.do">
  			<!--center-->
  			<div class="container">
      		<div class="row" id="loginrow"><font id="lo">Add new Role</font></div>
      		<div class="row" id="userow">
        		&nbsp;
        		Name : <input name="name" type="text" id="name">
      		</div>
      		<div class="row">
        		&nbsp;
        		Ballot Multiply : <input name="ballot" type="text" id="ballot"> Note: Ballot Multiply = 0 mean Special Role that not on register page.
        		<input name="type" type="hidden" value="role"> 
      		</div>
  			</div>
  			<br>
  			<input class="btn" type="submit" name="Submit" value="Add">
			<!--/center-->
		</form>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>

</body>
</html>