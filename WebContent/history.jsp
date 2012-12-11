<%@page import="com.exceedvote.entity.Statement"%>
<%@page import="com.exceedvote.entity.Ballot"%>
<%@page import="java.util.List" %>
<%@page import="com.exceedvote.entity.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	
	Statement[] statements = (Statement[]) request.getAttribute("statement");
	@SuppressWarnings("unchecked")
	List<List<Ballot>> ballots = (List<List<Ballot>>) request.getAttribute("ballot");
	for(int i = 0 ; i < statements.length ;i++){
	int sid = statements[i].getId();
	out.println(statements[i].getDescription());
	out.print("<br>");
	out.print("<br>");
	for(int j = 0 ; j < ballots.get(i).size() ;j++){
			out.print("<form name=\"form1\" method=\"post\" action=\"DeleteVote\">");
			out.print(" - Your vote is "+ballots.get(i).get(j).getChoice().getName()+" ");
			out.print("<input type=\"hidden\" name=\"id\" value="+ballots.get(i).get(j).getId()+">");
			out.print(" <input class=\"btn\" type=\"submit\" value=Delete >");	
			out.print("</form>");
			out.print("<br>");
		
	}
	
	out.print("<br>");
}
%>	
</font>
</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>
</body>
</html>