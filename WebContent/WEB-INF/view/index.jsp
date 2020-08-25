<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Rental Car</title>

			<!-- Bootstrap CSS -->
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
			<link type="text/css" rel="stylesheet" href="css/style.css">
		</head>
		<body>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">RentalCar</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="start"> Home <span class="sr-only">(current)</span></a>
					</li>
				
					<li class="nav-item">
						<a class="nav-link" href="listaautomobili">Catalogo</a>
					</li>
				</ul>
				
				<a class="nav-link" href="login">Sing in</a></li>
				<a class="nav-link" href="registrautente">Sign up</a></li>
				<c:if test="${sessionScope.currentUser !=null }">
					<a class="nav-link" href="areapersonale">Area Personale</a>
					<a class="nav-link" href="logout">Logout</a>
				</c:if>
			</div>
			</nav>
		</body>
	</html>