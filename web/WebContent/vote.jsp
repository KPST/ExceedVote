<%@page import="com.exceedvote.core.Statement"%>
<%@ page import="com.exceedvote.core.*"%>
<%@ page import="com.exceedvote.web.UserInfo"%>
<%@ page import="com.exceedvote.controller.*"%>
<%@ page import="com.mysql.jdbc.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<!-- get user id & question id -->
<% Client c = (Client) session.getAttribute("Cl");
   Statement s  = (Statement) session.getAttribute("Statement");
   int snum = (Integer) session.getAttribute("snum");
   int cs = c.choice.length;
   %>
<% UserInfo useri = (UserInfo) session.getAttribute("user"); %>
<head>

	<meta charset="utf-8">

	<title>Exceed Vote</title>
	
	<!-- Required CSS -->
	<link href="css/movingboxes.css" rel="stylesheet">

	<!-- Required script -->
	<!--  <script src="http://code.jquery.com/jquery-1.8.0.min.js"></script> -->
	<!-- <script src="http://code.jquery.com/jquery.min.js"></script> -->
	<!--  <script src="js/jquery.movingboxes.min"></script>-->
	<script src="js/jquery-1.8.2.js"></script>
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
				for(int i = 0 ; i < cs ;i++){
				out.println("<li><h2>News Heading</h2>");
				//out.println(c.getChoice(i));
				out.println("</li>");
		      } %>
		</ul><!-- end Slider #1 -->

	</div><!-- end wrapper -->
<input name = "Submit" type="button" value = "Button" onClick ="getVote()">
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
			post("voting.jsp",'<%= useri.getUserid()%>','<%=snum %>',h[1]);
		}
	}
	else{
			post("voting.jsp",'<%= useri.getUserid()%>','<%=snum %>',1);
	}
}

</script>
<script type="text/javascript">
//Post to the provided URL with the specified parameters.
function post(path, id , question , choice) {
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
</script>
</body>

</html>