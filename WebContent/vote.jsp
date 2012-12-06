<!-- 
vote page collect the information and send it to voting page
@author Kunat Pipatanakul
@version 2012.11.07
 -->
<%@page import="com.exceedvote.jpa.User"%>
<%@ page import="com.exceedvote.jpa.Statement"%>
<%@ page import="com.exceedvote.core.*"%>
<%@ page import="com.exceedvote.controller.*"%>
<%@ page import="com.mysql.jdbc.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<!-- get user id & question id -->
<% Client c = (Client) session.getAttribute("Cl");
   Statement s  = (Statement) session.getAttribute("Statement");
   int snum = s.getId();
   int cs = c.choices.length;
   %>
<!-- check if there is vote quota left ? if not sent to votef page -->
<% User useri = (User) session.getAttribute("user");
if(c.findBallot(useri.getId(),snum).length>=Math.floor(useri.getBallot())*s.getBallotMultiply())
	response.sendRedirect("votef.jsp");
%>
<head>

	<meta charset="utf-8">

	<title>Exceed Vote</title>
	
	<!-- Required CSS -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"></link>
	<link href="bootstrap/css/default.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/movingboxes.css" rel="stylesheet">

	<!-- Required script -->
	<!--  <script src="http://code.jquery.com/jquery-1.8.0.min.js"></script> -->
	<!-- <script src="http://code.jquery.com/jquery.min.js"></script> -->
	<!--  <script src="js/jquery.movingboxes.min"></script>-->
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="js/jquery.movingboxes.js"></script>
	<script type="text/javascript" src="jx.js"></script>
	<!-- get No.question  -->
	
	<!-- Demo only -->
	<link href="demo/demo.css" rel="stylesheet">

	<style>
		/* Dimensions set via css in MovingBoxes version 2.2.2+ */
		#slider { width: 500px; }
		#slider li { width: 300px; }
		#wrapper2{
			width: 800px;
			margin:auto;
		}
		#welcome{
    	min-height: 350px;
    	}
    	#fc{
    		text-align: center;
    	}
	</style>

	<script>
	$(function(){

		$('#slider1').movingBoxes({
			/* width and panelWidth options deprecated, but still work to keep the plugin backwards compatible
			width: 500,
			panelWidth: 0.5,
			*/
			startPanel   : 1,      // start with this panel
			wrap         : false,   // if true, the panel will "wrap" (it really rewinds/fast forwards) at the ends
			buildNav     : true,   // if true, navigation links will be added
			navFormatter : function(){ return "&#9679;"; } // function which returns the navigation text for each panel
		});

	});
	</script>

</head>

<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Exceed<span>Vote</span></a></h1>
			<p>Vote the projects in eXceed Camp .</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="main.jsp">Main Menu</a></li>
			<li><a href="history.jsp">History</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="welcome">
		<div id="wrapper2" >
		<!-- MovingBoxes Slider -->
		<ul id="slider1">
            <%
            
            //vote choice edit here
				for(int i = 0 ; i < cs ;i++){
				out.println("<li>");
				out.println("<img src="+c.choices[i].getImg()+">");
				out.println("<p>");
				out.println("id = "+c.choices[i].getId());
				out.println("<br>name = "+c.choices[i].getName());
				out.println("<br>des = "+c.choices[i].getDescription());
				out.println("</p></li>");
		     } %>
		      
		</ul><!-- end Slider #1 -->
		</div><!-- end wrapper2 -->
		<div id="fc">
			<input class="btn" id="votebtn" name = "Submit" style="height: 50px; width: 100px" type="button" value = "Vote" onClick ="getVote()">
		</div>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">KSPT</a>. </p>
</div>
<!-- getvote get number after # and send it to post function -->
<script>
function getVote()
{
	var i = window.location.hash;
	var h = i.split("=");
	var j = <%= cs %>
	if(h.length!=1){
		if(h[1]>j){
			window.alert("Hacked");
		}
		else{ 		
			post("voting.jsp",'<%= useri.getId()%>','<%=snum %>',h[1]);
		}
	}
	else{
			post("voting.jsp",'<%= useri.getId()%>','<%=snum %>',1);
	}
}

</script>
<script type="text/javascript">
//send post to voting
function post(path, id , question , choice) {
	if(confirm("Do you choose "+choice+" ?")){
    var form = $('<form></form>');
    form.attr("method", "get");
    form.attr("action", path);
        	var field = $('<input></input>');
            field.attr("type", "hidden");
            field.attr("name", "id");
            field.attr("value", id);
			form.append(field);
			var field2 = $('<input></input>');
            field2.attr("type", "hidden");
            field2.attr("name", "question");
            field2.attr("value", question);
			form.append(field2);
			var field3 = $('<input></input>');
            field3.attr("type", "hidden");
            field3.attr("name", "choice");
            field3.attr("value", choice);
			form.append(field3);
			
        
    $(document.body).append(form);
    form.submit();
	}
}
</script>
</body>

</html>