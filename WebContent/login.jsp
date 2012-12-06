<!-- 
 login.jsp is a JSP file with checking the username and password for authentication. 
 @author Tanachot Teachajarupan
 @author Kunat Pipatanakul
 @version 2012.11.07
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.exceedvote.factory.JpaFactory"%>
<%@page import="com.exceedvote.factory.IFactory"%>
<%@page import="com.exceedvote.core.*"%>
<%@page import="com.exceedvote.controller.*" %>
<%@page import="com.exceedvote.jpa.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Process</title>
</head>
<body>
  <%
  	//get username & pass from user
      String name = request.getParameter("username");
      String pass = request.getParameter("password");
       //check login ok?
    	IFactory b = JpaFactory.getInstance();
        Authentication a = new Authentication(b);
        String ip = request.getRemoteAddr();
      	User usr = a.login(name, pass, ip);
        if(usr!=null){
      		//login ok
      		//System.out.println(usr.getBallot());
      		Client client = new Client(b);
      		//session.setAttribute("name", name);
      		//session.setAttribute("pass", pass);
      		session.setAttribute("Cl", client);
      		session.setAttribute("user", usr);
      		response.sendRedirect("main.jsp");
      	}
      	//login not ok
      	else response.sendRedirect("loginf.jsp");
  %>
</body>
</html>