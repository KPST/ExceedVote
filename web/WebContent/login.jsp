<!-- 
 login.jsp is a JSP file with checking the username and password for authentication. 
 @author Tanachot Teachajarupan
 @version 2012.10.23
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
<title>Insert title here</title>
</head>
<body>
  <%
  DatebaseManager dm = new DatebaseManager();
  dm.init_Database();
  String name = request.getParameter("username");
  String pass = request.getParameter("password");
    Authentication a = new Authentication();
  	boolean check = a.login(name,pass);
  	if(check){
  		UserInfo usr = new UserInfo(a.getUserId(),a.getNoBallot());
  		Client client = new Client();
  		session.setAttribute("Cl", client);
  		session.setAttribute("user", usr);
  		session.setAttribute("DB", dm);
  		response.sendRedirect("main.jsp");
  	}else response.sendRedirect("loginf.jsp");%>
</body>
</html>