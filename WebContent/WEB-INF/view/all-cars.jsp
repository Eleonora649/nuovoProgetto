<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>
    <h2>List of Car</h2>  
<br>
    <table class="table">
       <thead> 
       		<tr>
            	<th>Model</th><th>License Plate</th><th>Manufacturer</th><th>Year of registration</th><th>Category</th><th></th>
        	</tr> 
        </thead>
        <tbody>
        <c:forEach items="${cars}" var="car">
            <tr>
            <td>${car.carModel}</td>
            <td>${car.carLicensePlate}</td>
            <td>${car.manufacturer}</td>
            <td>${car.yearOfRegistration}</td>
            <td>${car.category}</td>
            <td><a href="<c:url value='/update-${car.idCarr}-car'/>">update</a></td>
            <td><a href="<c:url value='/delete-${car.idCar}-car'/>">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
<jsp:include page="footer.jsp"/>