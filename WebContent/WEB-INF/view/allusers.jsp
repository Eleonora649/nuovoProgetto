<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
 	
 	 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="css/style.css">
 
</head>
 
 
<body>
    <h2>List of Customer</h2>  
    <table class="table">
       <thead> 
       		<tr>
            	<th>Name</th><th>Surname</th><th>Date of birth</th><th>Email</th><th></th><th></th>
        	</tr> 
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.email}</td>
            <td><a href="<c:url value='/update-${user.idUser}-user' />">update</a></td>
            <td><a href="<c:url value='/delete-${user.idUser}-user' />">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</body>
</html>