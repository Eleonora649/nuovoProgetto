<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

  <jsp:include page="header.jsp"/>
  <jsp:include page="index.jsp"/>
  
  <br>
            <form:form modelAttribute="car" method="post">
            <form:input path="idCar" type="hidden"/>
              <div class="form-group">
                <table align="center">
                    <tr>
                            <td><form:label path="carModel">Model</form:label></td>
							<td><form:input path="carModel" name="carModel" id="carModel" class="form-control" /></td>
                    </tr>
                    <tr>
							<td><form:label path="carLicensePlate">Car license plate</form:label></td>
							<td><form:input path="carLicensePlate" name="carLicensePlate" id="carLicensePlate" class="form-control" /></td>                    </tr>
                    <tr>
                      		<td><form:label path="manufacturer">Manufacturer</form:label></td>
							<td><form:input path="manufacturer" name="manufacturer" id="manufacturer" class="form-control" /></td>
                    </tr>
                    <tr>
                        	<td><form:label path="yearOfRegistration">Year of registration</form:label></td>
							<td><form:input path="yearOfRegistration" name="yearOfRegistration" id="yearOfRegistration" class="form-control" /></td>
                    </tr>
                    <tr>
					<br><br>
						<td>Category:</td>
							<td><form:select path="category">
								<form:option value="none" label="Select"/>
								<form:options items="${listCategory}" itemLabel="name" itemValue="idCategory"/>
							</form:select> 
						</td>
					</tr>
                  
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="update" name="update" class="btn btn-primary">Update</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
			</div>                 
            </form:form>
<br>
<jsp:include page="footer.jsp"/>