<!-- 
 login.jsp is a JSP file with checking the username and password for authentication. 
 @author Tanachot Teachajarupan
 @author Kunat Pipatanakul
 @version 2012.11.07
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.exceedvote.controller.*" %>
<%@ page import="com.exceedvote.core.*" %>
<%@ page import="com.exceedvote.web.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Process</title>
</head>
<body>
  <%
  //get DatabaseManager
  DatebaseManager dm = DatebaseManager.getDatabaseManager();
  //get username & pass from user
  String name = request.getParameter("username");
  String pass = request.getParameter("password");
   //check login ok?
    Authentication a = new Authentication();
  	if(a.login(name,pass)){
  		//login ok
  		UserInfo usr = new UserInfo(a.getUserId(),a.getNoBallot());
  		Client client = new Client();
  		session.setAttribute("Cl", client);
  		session.setAttribute("user", usr);
  		session.setAttribute("DB", dm);
  		response.sendRedirect("main.jsp");
  	}
  	//login not ok
  	else response.sendRedirect("loginf.jsp");%>
</body>
</html>