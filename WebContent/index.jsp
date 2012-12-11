<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<% if(session.getAttribute("user")!=null){
	response.sendRedirect("Main.do");
}
else{
	response.sendRedirect("Login.do");
}%>
</body>
</html>