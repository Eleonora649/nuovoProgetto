<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp" />
<jsp:include page="index.jsp" />

<br>
<body>
	<form:form modelAttribute="car" method="post">
		<div class="form-group">
			<table align="center">
				<tr>
					<td><form:label path="carModel">Model</form:label></td>
					<td><form:input path="carModel" name="carModel" id="carModel"
							class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="carLicensePlate">Car license plate</form:label>
					</td>
					<td><form:input path="carLicensePlate" name="carLicensePlate"
							id="carLicensePlate" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="manufacturer">Manufacturer</form:label>
					</td>
					<td><form:input path="manufacturer" name="manufacturer"
							id="manufacturer" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="yearOfRegistration">Year of registration</form:label>
					</td>
					<td>
						<form:input path="yearOfRegistration" name="yearOfRegistration" id="yearOfRegistration" class="form-control" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="category"> City Car </form:label> 
						<form:radiobutton path="category" name="category" value="1" />
					
						<form:label path="category"> Suv </form:label> 
						<form:radiobutton path="category" name="category" value="2" />
					
						<form:label path="category"> Furgone </form:label> 
						<form:radiobutton path="category" name="category" value="3" />
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<form:button id="register" name="register" class="btn btn-primary">Register</form:button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<jsp:include page="footer.jsp" />