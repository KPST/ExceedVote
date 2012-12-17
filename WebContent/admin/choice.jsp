
<%@page import="com.exceedvote.entity.Choice" %>
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
	#spacc{
		width: 60px;
	}
	#table1{
		margin-top: 20px;
		margin-bottom: 20px;
	}
	#table2{
		margin-top: 20px;
	}
	#test{
		font-size: 32px;
	}
	#test2{
		font-size: 32px;
	}
	#ff{
		margin-top: 10px;
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
			<li class="current_page_item"><a href="Admin.do?type=choice">Edit Choice</a></li>
			<li><a href="Admin.do?type=statement">Edit Statement</a></li>
			<li><a href="Admin.do?type=user">Edit User</a></li>
			<li><a href="Admin.do?type=role">Edit Role</a></li>
			<li><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Choice List</div>
		<br>
		<%
				Choice[] choices = (Choice[]) request.getAttribute("choice");
				out.print("<table id=\"table1\">");
				for(int i = 0 ; i < choices.length ; i ++){
					out.print("<tr> <td>");
					out.print("<form name=\"form1\" method=\"post\" action=\"Delete.do\">");
					out.print(choices[i].getName()+" "+choices[i].getDescription()+" ");
					out.print("<input type=\"hidden\" name=\"id\" value="+choices[i].getId()+">");
					out.print("<input type=\"hidden\" name=\"type\" value=choice>");
					out.print("</td> <td id=\"spacc\"> </td> <td>");
					out.print(" <input class=\"btn\" type=\"submit\" value=Delete>");	
					out.print("</form>");
					out.print("</td> </tr>");
				}
				out.print("</table>");
		%>
		<form name="form1" method="post" action="Add.do">
  			<!--center-->
  			<table id="table2">
			<font id="test2">Add new Choice</font><br>
        		<tr><td>Name :</td><td><input name="name" type="text" id="name"></td></tr>
        		<tr><td>Description :</td><td><input name="des" type="text" id="des"></td></tr>
        		<tr><td>Image URL : </td><td><input name="img" type="text" id="img">
        		<input name="type" type="hidden" value="choice"></td></tr>
			<!--/center-->
			</table>
			<input id="ff" class="btn" type="submit" name="Submit" value="Add">
		</form>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>

</body>
</html>