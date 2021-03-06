<%@page import="java.util.Collection"%>
<%@page import="com.exceedvote.entity.Project" %>
<%@page import="com.exceedvote.entity.Criteria" %>
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
			<li><a href="Main.do">Main Menu</a></li>
			<li><a href="History.do">History</a></li>
			<li><a href="admin/">Go to Admin Panel</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="banner"></div>
	<div id="welcome">
		<div id="test">Vote Timeout.<br></div>
		<br>
		<%
			@SuppressWarnings("unchecked")
			List<Collection<Object[]>> cols = (List<Collection<Object[]>>) request.getAttribute("rank");
			Criteria[] st = (Criteria[]) request.getAttribute("st");
				for(int i = 0 ; i < st.length ; i++){
		%>
			<div id="topic"><b>
			<%
				out.print("Criteria : "+st[i].getDescription());
			%>
			</div></b>
			<%
				Iterator<Object[]> it = cols.get(i).iterator();
				out.print("<br>");
				int count = 1;
				while(it.hasNext()){
					Object[] temp = it.next();
					Project choice = (Project) temp[0];
			%><div id="general">
			<% 
				out.print(count+++" . "+choice.getName());
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