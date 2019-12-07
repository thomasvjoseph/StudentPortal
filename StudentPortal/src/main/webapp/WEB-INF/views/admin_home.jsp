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
      <li><a href="day" ><span class="glyphicon glyphicon-calendar"></span> Day</a></li>
      <li><a href="week" ><span class="glyphicon glyphicon-calendar"></span> Week</a></li>
      <li><a href="" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span> Add Student</a></li>
    </ul>
  </div>
</nav>
<% String x= (String)request.getAttribute("a");

%>
<div class="row">
	<div class="col-sm-1">
		<div class="modal fade" id="myModal" role="dialog">
	    	<div class="modal-dialog">  
	      		<!-- Modal content-->
	      		<div class="modal-content">
	       			 <div class="modal-header">
	         			<button type="button" class="close" data-dismiss="modal">&times;</button>
	        		</div>
					<!--omit bootstrap boilerplate-->  
	        		<div class="modal-body">
				        <form action="adduser" method="post">
							<h2>Student Registration</h2>
							<input type="text" class="form-control"  placeholder="First Name" name="fname"required><br>
							<input type="text" class="form-control"  placeholder="Last Name" name="lanme"><br>
							<input type="text" class="form-control" placeholder="Email"name="email" required><br>							
							<input type="text" class="form-control"  placeholder="Mobile Number" name="phone" min="0" max= "10"required><br>
							<input type="date" class="form-control"  placeholder="Date of Birth"  name="dob" required><br>
							<select name="batch" class="form-control" >
								<option>Select Batch</option><option value="Batch-1">Batch-1</option><option value="Batch-2">Batch-2</option><option value="Batch-3">Batch-3</option>
							</select><br>
							<input type="text" class="form-control"  placeholder="User Name"  name="username" required><br>		
							<input type="password" class="form-control"  placeholder="Password"  name="password" required><br>							
							<input type="password" class="form-control"  placeholder="Confirm Password" ><br>							
							<input type="submit" class="btn btn-primary" value="Register"><br>
						</form>	  	
	       			</div>
	        	<div class="modal-footer">
	          		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        	</div>
	      	</div>
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
