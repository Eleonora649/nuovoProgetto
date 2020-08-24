<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
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
                            <form:label path="dateofbirth">Date Of Birth</form:label>
                        </td>
                        <td>
                            <form:input path="dateofbirth" name="dateofbirth" id="dateofbirth" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="mail">Mail</form:label>
                        </td>
                        <td>
                            <form:input path="mail" name="mail" id="mail" />
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
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>