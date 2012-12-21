<%@page import="com.exceedvote.entity.Criteria"%>
<%@page import="com.exceedvote.entity.Ballot"%>
<%@page import="java.util.List" %>
<%@page import="com.exceedvote.entity.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="js/timer.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote History</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
<link href="bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
<style>
    .row{
    	margin-top: 15px;
    	margin-left: 10px;
    }
    #lo{
      color:#d71700;
      font-size: 32px;
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
	User user = (User)session.getAttribute("user");
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
			<li><a href="Main.do">Main Menu</a></li>
			<li class="current_page_item"><a>History</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="welcome">
		<font size="3">
<%
	Criteria[] criterias = (Criteria[]) request.getAttribute("criteria");
	@SuppressWarnings("unchecked")
	List<List<Ballot>> ballots = (List<List<Ballot>>) request.getAttribute("ballot");
	for(int i = 0 ; i < criterias.length ;i++){
	int sid = criterias[i].getId();
	out.println(criterias[i].getDescription());
	out.print("<br>");
	out.print("<br>");
	for(int j = 0 ; j < ballots.get(i).size() ;j++){
	out.print("<form name=\"form1\" method=\"post\" action=\"DeleteVote.do\">");
	out.print(" - Your vote is "+ballots.get(i).get(j).getProject().getName()+" ");
	out.print("<input type=\"hidden\" name=\"id\" value="+ballots.get(i).get(j).getId()+">");
	out.print("<input class=\"btn\" type=\"submit\" value=Delete >");	
	out.print("</form>");
	out.print("<br>");
		
	}
	
	out.print("<br>");
}
%>	
</font>
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