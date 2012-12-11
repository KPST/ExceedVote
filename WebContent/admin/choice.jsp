
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
		<b>Choice List</b>
		<br>
		<%
				Choice[] choices = (Choice[]) request.getAttribute("choice");
				for(int i = 0 ; i < choices.length ; i ++){
					out.print("<form name=\"form1\" method=\"post\" action=\"Delete.do\">");
					out.print(choices[i].getName()+" "+choices[i].getDescription()+" ");
					out.print("<input type=\"hidden\" name=\"id\" value="+choices[i].getId()+">");
					out.print("<input type=\"hidden\" name=\"type\" value=choice>");
					out.print(" <input class=\"btn\" type=\"submit\" value=Delete>");	
					out.print("</form>");
					out.print("<br>");
				}
		%>
		<form name="form1" method="post" action="Add.do">
  			<!--center-->
  			<div class="container">
      		<div class="row" id="loginrow"><font id="lo">Add new Choice</font></div>
      		<div class="row" id="userow">
        		&nbsp;
        		Name : <input name="name" type="text" id="name">
      		</div>
      		<div class="row">
        		&nbsp;
        		Description : <input name="des" type="text" id="des">
        		Image URL : <input name="img" type="text" id="img">
        		<input name="type" type="hidden" value="choice"> 
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