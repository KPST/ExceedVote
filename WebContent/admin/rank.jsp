<%@page import="java.util.Collection"%>
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
<style type="text/css">
	#test{
		font-size: 32px;
	}
	#topic{
		font-size: 20px;
		color: #cd0000;
	}
	#general{
		font-size: 16px;
	}
	#table1{
		margin-top: 20px;
	}
	#spacc{
		width: 60px;
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
			<li class="current_page_item"><a href="Admin.do?type=rank">Show Score</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Score List<br></div>
		<br>
		<%
	@SuppressWarnings("unchecked")
	List<Collection<Object[]>> cols = (List<Collection<Object[]>>) request.getAttribute("rank");
	Statement[] st = (Statement[]) request.getAttribute("st");
		for(int i = 0 ; i < st.length ; i++){%>
			<div id="topic"><b>
			<%out.print("Statement : "+st[i].getDescription());%>
			</div></b>
			<%Iterator<Object[]> it = cols.get(i).iterator();
			out.print("<br>");
			int count = 1;
			while(it.hasNext()){
				Object[] temp = it.next();
				Choice choice = (Choice) temp[0];
			%><div id="general">
			<% 
				out.print(count+++". Choice : "+choice.getName());
				for(int j = 1 ; j < temp.length ; j++){
				out.print(" value :"+temp[j] );
				}
			%></div>
			<%
				out.print("<br>");
			}
		}
	%>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 KPST. All rights reserved.Design by <a href="http://www.freecsstemplates.org">freecsstemplates.org</a>. </p>
</div>

</body>
</html>