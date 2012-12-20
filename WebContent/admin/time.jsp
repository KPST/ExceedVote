
<%@page import="com.exceedvote.entity.Time" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Edit</title>
<link rel="stylesheet" href="/ExceedVote/bootstrap/css/bootstrap.min.css"></link>
<link href="/ExceedVote/bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
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
	#time{
	    color: #cd0000;
	    font-size: 20px;
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
			<li><a href="Admin.do?type=user">Edit User</a></li>
			<li><a href="Admin.do?type=role">Edit Role</a></li>
			<li class="current_page_item"><a href="Admin.do?type=time">Edit Time</a></li>
			<li><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Time</div>
		<br>
		<%
	List<Time> times = (List<Time>) request.getAttribute("time");
	for(int i = 0 ; i < times.size(); i ++){
	out.print("<table id=\"table1\">");
	out.print("<form name=\"form1\" method=\"post\"><tr><td><div id =\"time\">");
	out.print(times.get(i).getYear()+"/"+times.get(i).getMonth()+"/"+times.get(i).getDay()+" "+times.get(i).getHour()+":"+times.get(i).getMin()+" Timezone :"+times.get(i).getTimezone());
	out.print("");	
	out.print("</div></td></tr></form>");
	}
	out.print("</table>");
%>
		<form name="form1" method="post" action="Add.do">			
  			<!--center-->
  			<div id="test2">Edit Time</div>
  			<table id="table2">
  				<tr><td>
        		Year :</td><td><input name="year" type="text" id="year"></td></tr>
       			<tr><td>Month :</td><td><input name="month" type="text" id="month"></td>
       			<tr><td>Day :</td><td><input name="day" type="text" id="day"></td>
       			<tr><td>Hour :</td><td><input name="hour" type="text" id="hour"> in 24 format</td>
       			<tr><td>Min :</td><td><input name="min" type="text" id="min"></td>
       			<tr><td>Timezone :</td><td><input name="timezone" type="text" id="timezone"> Bangkok is +7</td>
        		<td><input name="type" type="hidden" value="time"></td></tr>
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