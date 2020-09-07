<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">RentalCar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home">
					Home <span class="sr-only">(current)</span>
			</a></li>
		
			<li class="nav-item"><a class="nav-link" href="listcar">Catalogo</a>
			</li>
		</ul>
			
			<c:if test="${user == null}">
				<a class="nav-link" href="login">Sign in</a><br><br>
				<a class="nav-link" href="userregistration">Sign up</a>
			</c:if>
			<c:if test="${user != null}">
				<a class="nav-link" href="areapersonale">Area Personale</a>
				<a class="nav-link" href="logout">Logout</a>
			</c:if>
	</div>
</nav>
			
<c:url value="logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
 <c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>