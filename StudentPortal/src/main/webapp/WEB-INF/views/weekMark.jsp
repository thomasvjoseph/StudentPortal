<%@page import="com.studentportal.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.studentportal.dao.*"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>WeekMark</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">StudentPortal</a>
    </div>
    <ul class="nav navbar-nav navbar-left"><br>
      <li><form action="dayView" method="post">
      	<input type="text" value="<%= request.getAttribute("id") %>" name="duid" hidden>
      	<button type="submit"><span class="glyphicon glyphicon-calendar"></span> Day</button>
      </form>
      </li>
      <li><form action="weekView" method="post">
      	<input type="text" value="<%= request.getAttribute("id") %>" name="wuid" hidden>
      	<button type="submit"><span class="glyphicon glyphicon-calendar"></span>Week</button>
      </form>
      </li>
    </ul>
  </div>
</nav>
<br>

<% ArrayList<Week> d = (ArrayList<Week>)request.getAttribute("wm");%>
<div class="row">												
<div class="col-sm-2"></div>
<div class="col-sm-7">
	<table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Start Date</th>
	       <th scope="col">End Date</th>
	      <th scope="col">Viva Score(5)</th>
	      <th scope="col">Code Completion(1)</th>
	      <th scope="col">Project Completion(1)</th>
	    </tr>
	  </thead>
	  <tbody>
	     <%  for(Week w : d){ %>
	     <tr>
	     <th scope="row">*</th>
	     <td><%=w.getSdate() %></td>
	     <td><%=w.getEdate() %></td>
	     <td><%=w.getViva() %></td>
	     <td><%=w.getCc() %></td>
	     <td><%=w.getPc() %></td>
	     </tr>
	     <%} %>
	  </tbody>
	</table>
</div>
</div>
</body>
<br>
<footer class="page-footer font-small blue">
  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <a href="#"> thomaz joseph</a>
  </div>
  <!-- Copyright -->
</footer>	
</html>
