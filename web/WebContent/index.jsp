<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<% if(session.getAttribute("user")!=null&&session.getAttribute("Cl")!=null){
	response.sendRedirect("main.jsp");
}
else{
	response.sendRedirect("login.html");
}%>
</body>
</html>