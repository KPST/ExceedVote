<%@page import="com.exceedvote.factory.JpaFactory"%>
<%@page import="com.exceedvote.controller.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script language="JavaScript" type="text/javascript">
	var count = 4
	var redirect = "index.jsp"

	function countDown() {
		if (count <= 0) {
			window.location = redirect;
		} else {
			count--;
			document.getElementById("timer").innerHTML = "This page will automaticly redirect in "
					+ count + " seconds."
			setTimeout("countDown()", 1000)
		}
	}
</script>

<body>
	<center>
		<br>
		<%
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			Authentication c = new Authentication(JpaFactory.getInstance());
			String ip = request.getRemoteAddr();
			
			//check and add username in DB
			if (c.addUser(user, pass, 1, ip)) {
				out.println("Registration Complete!");
			} else {
				out.println("FAIL for Registration! Please try again.");
			}
			session.invalidate();
		%>
		<br>
		<br> <span id="timer"> <script>
			countDown();
		</script>
		</span>
	</center>
</body>
</html>