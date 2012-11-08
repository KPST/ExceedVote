<!-- 
vote page collect the information and send it to voting page
@author Kunat Pipatanakul
@version 2012.11.07
 -->
<%@page import="com.exceedvote.jpa.Auth"%>
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
<% Auth useri = (Auth) session.getAttribute("user");
if(c.findBallot(useri.getId(),snum).length>=useri.getNoBallot())
	response.sendRedirect("votef.jsp");
%>
<head>

	<meta charset="utf-8">

	<title>Exceed Vote</title>
	
	<!-- Required CSS -->
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
		#slider { width: 800px; }
		#slider li { width: 300px; }
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

		<h1 class="demo-title">Exceed Vote</h1>

	

		<!-- MovingBoxes Slider -->
		<ul id="slider1">
		<!-- 
			<li>
			<img src="demo/1.jpg" alt="picture">
				<h2>Bolt Runner</h2>
				<p>Add a short exerpt here... <a href="http://flickr.com/photos/justbcuz/112479862/">more</a></p>
			</li>

			<li>
				<img src="demo/2.jpg" alt="picture">
				
				<h2>News Heading</h2>
				<p></p>
			</li>

			<li>
				<img src="demo/3.jpg" alt="picture">
				<h2>News Heading</h2>
				<p>Add a short exerpt here... <a href="http://flickr.com/photos/ruudvanleeuwen/468309897/">more</a></p>
			</li>

			<li>
				<img src="demo/4.jpg" alt="picture">
				<h2>News Heading</h2>
				<p>Add a short exerpt here... <a href="http://flickr.com/photos/emikohime/294092478/">more</a></p>
			</li>

			<li>
				<img src="demo/5.jpg" alt="picture">
				<h2>News Heading</h2>
				<p>Add a short exerpt here... <a href="http://www.flickr.com/photos/fensterbme/499006584/">more</a></p>
			</li>
            
            -->
            <%
            
            //vote choice edit here
				for(int i = 0 ; i < cs ;i++){
				out.println("<li><p>");
				out.println(c.getChoice(i).toString());
				out.println("</p></li>");
		     } %>
		      
		</ul><!-- end Slider #1 -->

	</div><!-- end wrapper -->
<center>
<input name = "Submit" style="height: 50px; width: 100px" type="button" value = "Vote" onClick ="getVote()">
<form method="POST" action="main.jsp">
  <input class="btn" style="height: 30px; width: 100px" type="submit" value="Back to Main">
</form>
</center>
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