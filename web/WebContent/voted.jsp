<!-- voted page nothing here
@author Kunat Pipatanakul
@version 2012.11.07
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voted</title>
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
      background-color:#DDDDDD;
    }
  </style>
</head>
<body>
<center>
<br>
<font size = "7">
You have already voted.</font>
<br>
<br>
<form method="POST" action="main.jsp">
  <input class="btn"  style="height: 30px; width: 100px" type="submit" value="Back to Main">
</form>
</center>
</body>
</html>