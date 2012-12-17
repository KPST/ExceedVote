
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
<style type="text/css">
	#test{
		font-size: 32px;
	}
	#test2{
		font-size: 32px;
		margin-top: 20px;
		margin-bottom: 20px;
	}
	#spacc{
		width: 60px;
	}
	#table1{
		margin-bottom: 20px;
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
			<li><a href="Admin.do?type=statement">Edit Choice</a></li>
			<li><a href="Admin.do?type=statement">Edit Statement</a></li>
			<li><a href="Admin.do?type=user">Edit User</a></li>
			<li class="current_page_item"><a href="Admin.do?type=role">Edit Role</a></li>
			<li><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Role List</div>
		<br>
		<%
				out.print("<table id=\"table1\">");
				Role[] roles = (Role[]) request.getAttribute("role");
				for(int i = 0 ; i < roles.length ; i ++){
					out.print("<form name=\"form1\" method=\"post\" action=\"Delete.do\"><tr><td>");
					out.print(roles[i].getName()+" ");
					out.print("<input type=\"hidden\" name=\"id\" value="+roles[i].getId()+">");
					out.print("<input type=\"hidden\" name=\"type\" value=role></td><td id=\"spacc\"></td><td>");
					out.print(" <input class=\"btn\" type=\"submit\" value=Delete>");
					out.print("</td></tr></form>");
				}
				out.print("</table>");
				out.print("<div>Note : when you delete role all user will be delete.</div> ");
		%>
		<form name="form1" method="post" action="Add.do">
  			<!--center-->
  			<div id="test2">Add new Role</div>
  			<table id="table2"><tr><td>
        		Name : </td><td><input name="name" type="text" id="name"></td></tr><tr>
      		<td>Ballot Multiply : </td><td><input name="ballot" type="text" id="ballot"></td><tr>
        		<input name="type" type="hidden" value="role"> 
			<!--/center-->
			</table>
			Note: Ballot Multiply = 0 mean Special Role that not on register page.<br>
			<input class="btn" type="submit" name="Submit" value="Add">
		</form>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>

</body>
</html>