<%@page import="com.studentportal.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.studentportal.dao.*"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>Home</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">StudentPortal</a>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li><br>
	      <form action="dayView" method="post">
	      	<input type="text" value="<%= request.getAttribute("id") %>" name="duid" hidden>
	      	<button type="submit"><span class="glyphicon glyphicon-calendar"></span> Day</button>
	      </form>
      </li>
      <li><br>
	      <form action="weekView" method="post">
	      	<input type="text" value="<%= request.getAttribute("id") %>" name="wuid" hidden>
	      	<button type="submit"><span class="glyphicon glyphicon-calendar"></span>Week</button>
	      </form>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><br>
    	<form class="form-inline" action="markSearch" method="post">
    		<input type="text" value="<%= request.getAttribute("id") %>" name="duid" hidden>
		    <input class="form-control mr-sm-2" type="date" placeholder="Search for mark" aria-label="Search" name="fdate">
		    <button class="btn btn-success" type="submit">Search</button>
		 </form>
    </li>
    </ul>
  </div>
</nav>
<br>
Welcome  <%= request.getAttribute("firstname") %>
<div class="row">
  <div class="col-sm-6">
    <div class="card" >
    <% ArrayList<Day> d = (ArrayList<Day>)request.getAttribute("date");%>	
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        
      </div>
    </div>
  </div>
 </div>
</body>
<footer class="page-footer font-small blue">
  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <a href="#"> thomaz joseph</a>
  </div>
  <!-- Copyright -->
</footer>
</html>
