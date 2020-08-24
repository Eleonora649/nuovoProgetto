<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rental Car</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="jumbotron jumbotron-billboard">
		<div class="img"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>${intestazione}</h2>
					<p>${saluti}</p>
					<a href="#" id="SignUp" class="btn btn btn-primary btn-lg">Accedi</a>
					<a href="#" id="SignIn" class="btn btn-success btn-lg">Registrati</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
