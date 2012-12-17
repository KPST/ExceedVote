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
<script src="js/timer.js"></script>
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
  <style type="text/css">
.numbers {
width: 55px;
text-align: center; 
font-family: Arial; 
font-size: 28px;
font-weight: bold; /* options are normal, bold, bolder, lighter */
font-style: normal; /* options are normal or italic */
color: #cd0000; /* change color using the hexadecimal color codes for HTML */
}
.title {/* the styles below will affect the title under the numbers, i.e., "Days", "Hours", etc. */
width: 55px;
text-align: center; 
font-family: Arial; 
font-size: 10px;
font-weight: bold; /* options are normal, bold, bolder, lighter */
color: #000000; /* change color using the hexadecimal color codes for HTML */
}
#table {
width: 400px;
height: 48px;
border-style: none;
background-color: transparent;
margin: 0px auto;
position: relative; /* leave as "relative" to keep timer centered on your page, or change to "absolute" then change the values of the "top" and "left" properties to position the timer */
top: 0px; /* change to position the timer */
left: 0px; /* change to position the timer; delete this property and it's value to keep timer centered on page */
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
	<table id="table" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center" colspan="6"><div class="numbers" id="count2" style="padding: 5px 1 0 0; "></div></td>
    </tr>
    <tr id="spacer1" height="30">
        <td align="center" ><div class="numbers" ></div></td>
        <td align="center" ><div class="numbers" id="dday"></div></td>
        <td align="center" ><div class="numbers" id="dhour"></div></td>
        <td align="center" ><div class="numbers" id="dmin"></div></td>
        <td align="center" ><div class="numbers" id="dsec"></div></td>
        <td align="center" ><div class="numbers" ></div></td>
    </tr>
    <tr id="spacer2" height="12">
        <td align="center" ><div class="title" ></div></td>
        <td align="center" ><div class="title" id="days">Days</div></td>
        <td align="center" ><div class="title" id="hours">Hours</div></td>
        <td align="center" ><div class="title" id="minutes">Minutes</div></td>
        <td align="center" ><div class="title" id="seconds">Seconds</div></td>
        <td align="center" ><div class="title" ></div></td>
    </tr>
</table>
<script type="text/javascript">window.onload = CreateTimer("dday","dhour","dmin","dsec", <%=request.getAttribute("timer")%>);</script>
<br>
</div>
<div id="footer">
	<p>Copyright (c) 2012 KPST. All rights reserved.Design by <a href="http://www.freecsstemplates.org">freecsstemplates.org</a>. </p>
	</div>
</body>
</html>	