<%-- <%@ page session="true" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="">
	<!--<c:out value="${requestScope.automobile}"/>-->
		<table class="table">
			<thead>
				<tr>
            		<th>Model</th><th>License Plate</th><th>Manufacturer</th><th>Year of registration</th><th>Category</th><th></th>
        		</tr> 
			</thead>
			<tbody>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td>${car.model}</td>
					<td>${car.carLicensePlate}</td>
					<td>${car.manufacturer}</td>
					<td>${car.yearOfRegistration}</td>
					<td>${car.category.name}</td>
				</tr> 
 			</c:forEach>
				<tr> <td></td><td></td> 
				<form:form method="post" modelAttribute="booking" action="booking">
					<td>
						<form:label path="startBooking"> Seleziona data di inizio noleggio</form:label>
						<form:input path="startBooking" type="date" name="startBooking" min="${today}" max="2021-31-07" />
					</td>
					<td>
						<form:label path="endOfBooking"> Seleziona data di fine noleggio</form:label>
						<form:input path="endOfBooking" type="date" name="endOfBooking" min="${today}" max="2021-31-07" />
					</td>
					<td>
					 	<form:button type="submit" class="btn btn-primary"> Confirm </form:button>
					</td> 
				</form:form>
				<td></td><td></td> </tr>
		</tbody>
	</table>


</div>
