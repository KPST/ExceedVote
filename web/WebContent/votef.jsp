<!-- can't vote because full quota
@author Kunat Pipatanakul
@version 2012.11.07
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote fail</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
  <style>
    #loginrow{
      margin-top: 50px;
      margin-bottom: 20px;
    }
    input{

    }
    #lo{
      color:#d71700;
      font-size: 32px;
    }
    body{
      background-color:#000011;
    }
  </style>
</head>
<body>
<br>
<br>
<center>
  <div class="container" border="1">
      <font size ="7" id="lo">You are Out of Ballot!</font>
<br>
<br>
<form method="POST" action="main.jsp">
  <input class="btn" type="submit" value="Back">
</form>

</body>
</html>