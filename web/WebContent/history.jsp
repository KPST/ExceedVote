<%@page import="com.exceedvote.core.Ballot"%>
<%@page import="com.exceedvote.controller.*" %>
<%@page import="com.exceedvote.web.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote History</title>
</head>
<body>
<%
UserInfo user = (UserInfo)session.getAttribute("user");
Client c = (Client)session.getAttribute("Cl");
int statementlength = c.st.length;	
for(int i = 0 ; i < statementlength ;i++){
	out.println(c.getStatement(i).description);
	Ballot[] b = c.findBallot(user.getUserid(), i);
	out.print(b.length);
	out.print("\n");
	for(int j = 0 ; j < b.length ;j++){
		out.print("J = "+b[j].getId()+" "+b[j].getUserid()+" : "+b[j].getQuestion()+" : "+b[j].getChoice());
		
		out.print("<a href=\"delete.jsp?id="+b[j].getId()+"\">delete</a>");
		out.print("\n");
	}
}
%>
</body>
</html>