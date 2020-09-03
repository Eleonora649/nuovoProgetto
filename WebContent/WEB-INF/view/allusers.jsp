<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>
    <h2>List of Customer</h2>  
<br>
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
            <td><a href="<c:url value='/update/${user.idUser}'/>">update</a></td>
            <td><a href="<c:url value='/delete-${user.idUser}-user'/>">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
<jsp:include page="footer.jsp"/>