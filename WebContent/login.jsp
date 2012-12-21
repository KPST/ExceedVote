<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.exceedvote.entity.Role"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Welcome to eXceed Vote!</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
  <link href="bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
  <style>
    #ttt{
		color: black;
	}
	#ddd{
		margin-left: 30px;
		margin-right: 10px;
	}
  </style>
</head>
<body>
<form name="form1" method="post" action="goLogin.do">
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
			<li class="current_page_item"><a href="#">Login</a></li>
		</ul>
	</div>
	<div id="banner"><img src="images/headerpic.jpg" width="1200" height="400" alt="" /></div>
	<div id="welcome">
		<h2 class="title"><a href="#">Welcome to eXceed Vote</a></h2>
		<div class="content">
				&nbsp;
				<input name="username" placeholder="username" type="text" id="username">
				<br>
				&nbsp;
				<input name="password" placeholder="password" type="password" id="password">
				<br>
				<br>
				<div class="row">
					<input class="btn" type="submit" name="Submit" value="Login" id="ddd">
				</div>
		</div>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 KPST. All rights reserved.Design by <a href="http://www.freecsstemplates.org">freecsstemplates.org</a>. </p>
	</div>
</form>
</body>
</html>