<%@page import="com.exceedvote.jpa.Statement"%>
<%@page import="com.exceedvote.jpa.Ballot"%>
<%@page import="com.exceedvote.jpa.User"%>
<%@page import="com.exceedvote.controller.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleting Process</title>
</head>
<body>
Delete<%=request.getParameter("id") %>
<%
int id = Integer.parseInt(request.getParameter("id"));
User userinfo = (User)session.getAttribute("user");
Client cl = (Client)session.getAttribute("Cl");
Ballot b = cl.findBallot(id);
if(cl.findBallot(id).getUser()==userinfo.getId()){
	int qid = b.getQuestionid();
	cl.DeleteBallot(id);
	Statement st  = cl.getStatement(qid);
	session.setAttribute("Statement", st);
	response.sendRedirect("vote.jsp");
}
else
out.print("NO");
%>
</body>
</html>