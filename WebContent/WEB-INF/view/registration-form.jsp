<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
            <form:form modelAttribute="user" method="post">
               <a href="home.jsp">Home</a>
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="name">Name</form:label>
                        </td>
                        <td>
                            <form:input path="name" name="name" id="name" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="surname">Surname</form:label>
                        </td>
                        <td>
                            <form:input path="surname" name="surname" id="surname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                          	<form:label path="dateOfBirth">Date Of Birth</form:label> 
                        </td>
                        <td>
                        
                        	<form:input path="dateOfBirth" name="dateofbirth" id="dateofbirth" /> 
                       
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="email">Mail</form:label>
                        </td>
                        <td>
                            <form:input path="email" name="mail" id="mail" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                  
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
                 
            </form:form>
        </body>
        </html>