<%@page import="com.exceedvote.controller.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choice Edit</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>

<link href="/ExceedVote/bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
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
			<li class="current_page_item"><a>Edit Choice</a></li>
			<li><a href="statement.jsp">Edit Statment</a></li>
			<li><a href="user.jsp">Edit User</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<b>Choice List</b>
		<br>
		<% Client c = (Client)session.getAttribute("Cl");
		for(int i = 0 ; i < c.choices.length ; i ++){
			out.print(c.choices[i].getName()+" "+c.choices[i].getDescription()+" ");
			out.print("<a href=\"delete.jsp?id="+c.choices[i].getId()+"&type=choice\">delete</a>");
			out.print("<br>");
		}
		%>
		<form name="form1" method="get" action="add.jsp">
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
		<form method="POST" action="index.jsp">
  			<input class="btn" style="height: 40px; width: 100px" type="submit" value="Back to Menu">
		</form>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>

</body>
</html>