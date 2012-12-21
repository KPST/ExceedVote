
<%@page import="com.exceedvote.entity.Time" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Edit</title>
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
	#special{
		color: #cd0000;
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
			<li><a href="Admin.do?type=project">Edit Project</a></li>
			<li><a href="Admin.do?type=criteria">Edit Criteria</a></li>
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
			<div id="test2">Edit VoteEnd Time</div>
  			<form name="form1" method="post" action="Add.do">
  			<table id="table2">
  				<input type="hidden" name="type" value="time">
  				<tr><td>Select a date: <input type="date" name="date">
  				<div id="special"> Note: format yyyy-mm-dd </div>
  				<tr><td>Select a time: <input type="time" name="time"><div id="special"> Note: format hh:mm </div>
   				<tr><td><div id="special"> Note: Date and Time Picker won't work with IE,Firefox. </div>
			</table>
			
	<input class="btn" type="submit" name="Submit" value="Add">
	</form>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 KPST. All rights reserved.Design by <a href="http://www.freecsstemplates.org">freecsstemplates.org</a>. </p>
</div>

</body>
</html>