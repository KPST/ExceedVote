<%@page import="com.exceedvote.jpa.Ballot"%>
<%@page import="com.exceedvote.controller.*" %>
<%@page import="com.exceedvote.jpa.Auth" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote History</title>
</head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
<style>
    #loginrow{
      margin-top: 50px;
      margin-bottom: 20px;
    }
    input{

    }
    #lo{
      color:#d71700;
      font-size: 32px;
    }
    body{
      background-color:#DDDDDD;
    }
  </style>
<body>
<%
Auth user = (Auth)session.getAttribute("user");
Client c = (Client)session.getAttribute("Cl");
%>
<br>
<font size="3">
<%
int statementlength = c.statements.length;	
for(int i = 0 ; i < statementlength ;i++){
	int sid = c.statements[i].getId();
	%>
	<font size="5" color="#d71700">
	<%
	out.println(c.statements[i].getDescription());
	Ballot[] b = c.findBallot(user.getId(), sid);
	out.print("</font><br>");
	for(int j = 0 ; j < b.length ;j++){
		out.print(" - Your vote is "+b[j].getChoice()+" ");
		out.print("<a href=\"delete.jsp?id="+b[j].getId()+"\">edit</a>");
		
		out.print("<br>");
		
	}
	out.print("<br>");
}
%>
<form method="POST" action="main.jsp">
  <input class="btn" style="height: 30px; width: 100px" type="submit" value="Back to Main">
</form>

</font>
</body>
</html>