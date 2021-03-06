
<%@page import="com.exceedvote.entity.Criteria" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criteria Edit</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"></link>
<link href="../bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
	#test{
		font-size: 32px;
	}
	#test2{
		font-size: 32px;
		margin-bottom: 20px;
	}
	#table1{
		margin-bottom: 20px;
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
			<li><a href="../Main.do">Main</a></li>
			<li><a href="Admin.do?type=project">Edit Project</a></li>
			<li class="current_page_item"><a href="Admin.do?type=criteria">Edit Criteria</a></li>
			<li><a href="Admin.do?type=user">Edit User</a></li>
			<li><a href="Admin.do?type=role">Edit Role</a></li>
			<li><a href="Admin.do?type=time">Edit Time</a></li>
			<li><a href="Admin.do?type=rank">Show Score</a></li>
			
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Criteria List</div>
		<br>
		<%
			Criteria[] criterias = (Criteria[]) request.getAttribute("criteria");
			out.print("<table id=\"table1\">");
			for(int i = 0 ; i < criterias.length ; i ++){
				out.print("<form name=\"form1\" method=\"post\" action=\"Delete.do\"><tr><td>");
				out.print(criterias[i].getDescription());
				out.print("<input type=\"hidden\" name=\"id\" value="+criterias[i].getId()+">");
				out.print("<input type=\"hidden\" name=\"type\" value=criteria></td><td id=\"spacc\"></td><td>");
				out.print(" <input class=\"btn\" type=\"submit\" value=Delete>");	
				out.print("</td></tr></form>");
			}
			out.print("</table>");
		%>
		<form name="form1" method="post" action="Add.do">			
  			<!--center-->
  			<div id="test2">Add new Criteria</div>
  			<table id="table2">
  				<tr><td>
        		Description :</td><td><input name="des" type="text" id="des"></td></tr>
       			<tr><td>BallotMultiply :</td><td><input name="multiply" type="text" id="multiply"></td>
        		<td><input name="type" type="hidden" value="criteria"></td></tr>
			<!--/center-->
		</form>
	</table>
	<input class="btn" type="submit" name="Submit" value="Add">
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 KPST. All rights reserved.Design by <a href="http://www.freecsstemplates.org">freecsstemplates.org</a>. </p>
</div>

</body>
</html>