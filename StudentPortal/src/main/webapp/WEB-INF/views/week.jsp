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
      <li><a href="day" ><span class="glyphicon glyphicon-calendar"></span> Day</a></li>
      <li><a href="week" ><span class="glyphicon glyphicon-calendar"></span> Week</a></li>
      <li><a href="" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span> Add Student</a></li>
    </ul>
  </div>
</nav>
<script type="text/javascript">
$(document).ready(function() {
	$('#uname').on('change', function(e) {
            var uname = this.value
            var data ='uname='+uname;
            $.ajax({
                url : "nameSelect",
                data : data,
                type : "POST",
				datatype:'json',
                success : function(response) {  
                	response = JSON.parse(response);
                	console.log(response);
                	for (var i = 0; i < response.length; i++) {
						    console.log(response[i].fname);
						    $('#fname').val(response[i].fname);  
						    $('#lname').val(response[i].lanme); 
						    $('#batch').val(response[i].batch); 
						}
                		
                		  		 
                },
                error : function(xhr, status, error) {
                }
            });
            return false;
        });
    });
</script>
<%ArrayList<User> p = (ArrayList<User>)request.getAttribute("user");%>
<div class="row"><div class="col-sm-3"></div>
	<div class="col-sm-3">
		<form action="weekmark" method="post" >
		
			<select class="form-control" id="uname" name="uname">	
			<option value="" label="--- Select user---" />		    
			     <%  for(User us : p){ %>			     
			      <option value="<%= us.getUsername() %>"><%= us.getUsername() %></option>
			 <%} %>
			 </select><br>
			<input type="text" id="fname" value="" class="form-control"  placeholder="First Name"><br>
			<input type="text" id="lname" value="" class="form-control"  placeholder="Last Name"><br>
			<input type="text" id="batch" value="" class="form-control"  placeholder="Batch Number"><br>
			<input type="date" class="form-control"  placeholder="Start Date" name="sdate"required><br>
			<input type="date" class="form-control"  placeholder="End Date" name="edate"required>
			Viva
			<select name="viva" class="form-control" >
				<option>--Select Mark</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>
			</select>
			Code Convention
			<select name="cc" class="form-control">
				<option>--Select Mark</option><option value="0">0</option><option value="1">1</option>
			</select>
			Project Completion
			<select name="pc" class="form-control">
				<option>--Select Mark</option><option value="0">0</option><option value="1">1</option>
			</select><br>
			<input type="submit" class="btn btn-primary" value="Add Mark"><br>
		</form>
	</div>
</div>
<div class="row">
	<div class ="col-sm-3"> 
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
								<option value="Batch-1">Batch-1</option><option value="Batch-2">Batch-2</option><option value="Batch-3">Batch-3</option>
							</select>
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
