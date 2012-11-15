<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.exceedvote.controller.Client"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statement Edit</title>
</head>
<body>
<% Client c = (Client)session.getAttribute("Cl");
	for(int i = 0 ; i < c.statements.length ; i ++){
		out.print(c.statements[i].getDescription()+" ");
		out.print("<a href=\"delete.jsp?id="+c.statements[i].getId()+"&type=statement\">delete</a>");
		out.print("<br>");
	}
%>
<form name="form1" method="get" action="add.jsp">
  <center>
  <div class="container">
      <div class="row" id="loginrow"><font id="lo">add new Statement</font></div>
      <div class="row" id="userow">
        &nbsp;
      </div>
      <div class="row">
        &nbsp;
        Des <input name="des" type="text" id="des">
        <input name="type" type="hidden" value="statement"> 
      </div>
  </div>
  <br>
  <input class="btn" type="submit" name="Submit" value="Add">
</center>
</form>
</body>
</html>