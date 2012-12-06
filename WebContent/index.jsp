<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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