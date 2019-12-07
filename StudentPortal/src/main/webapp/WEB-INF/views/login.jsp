<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>Login</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">StudentPortal</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signup" ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-4">
		<form action="login" method="post">
			<h2>Login</h2>
			<input type="text" class="form-control"   name="username" id="username"><br>
			<input type="password" class="form-control" id="password" name="password"><br>
			<button type="submit" class="btn btn-primary">Login</button> <br><br><br>
		</form>
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