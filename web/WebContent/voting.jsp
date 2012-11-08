<!-- 
voting page get vote from vote page and run the client.vote()
@author Kunat Pipatanakul
@version 2012.11.07
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.exceedvote.controller.*"%>
<%@page import="com.exceedvote.jpa.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voting Process</title>
</head>
<body>
<% 
   //get client
   Client c =(Client) session.getAttribute("Cl");
   //get information about vote
    Auth useri = (Auth) session.getAttribute("user");
   	Statement s = (Statement) session.getAttribute("Statement");
   if(c.findBallot(useri.getId(),s.getId()).length>=useri.getNoBallot())
		response.sendRedirect("votef.jsp");
   else{
   int id = Integer.parseInt(request.getParameter("id"));
   int question = Integer.parseInt(request.getParameter("question"));
   int choice = Integer.parseInt(request.getParameter("choice"));
   //vote
   c.vote(id, question, choice);
%>
<!-- Redirect to main project page -->
<% response.sendRedirect("voted.jsp");
}%>
</body>
</html>