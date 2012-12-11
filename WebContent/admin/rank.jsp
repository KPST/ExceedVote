<%@page import="com.exceedvote.entity.Choice" %>
<%@page import="com.exceedvote.entity.Statement" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Score</title>
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
			<li><a href="Admin.do?type=choice">Edit Choice</a></li>
			<li><a href="Admin.do?type=statement">Edit Statement</a></li>
			<li><a href="Admin.do?type=user">Edit User</a></li>
			<li><a href="Admin.do?type=role">Edit Role</a></li>
			<li class="current_page_item"><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<b>Score List</b>
		<br>
		<%
	@SuppressWarnings("unchecked")
	List<Map<Choice,Integer>> maps = (List<Map<Choice,Integer>>) request.getAttribute("map");
	Statement[] st = (Statement[]) request.getAttribute("st");
		for(int i = 0 ; i < st.length ; i++){
			Set<Choice> key = maps.get(i).keySet();
			out.print("Statement : "+st[i].getDescription());
			Iterator<Choice> it = key.iterator();
			out.print("<br>");
			while(it.hasNext()){
				Choice temp = it.next();
				out.print("Choice :"+temp.getName()+" value :"+maps.get(i).get(temp) );
				out.print("<br>");
			}
		}
	%>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>

</body>
</html>