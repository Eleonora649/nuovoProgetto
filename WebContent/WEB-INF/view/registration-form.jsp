<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp" />
<jsp:include page="index.jsp" />

<br>
	<form:form modelAttribute="user" method="post">
		<div class="form-group">
			<table align="center">
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input type="text" path="name" name="name" id="name" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="surname">Surname</form:label></td>
					<td><form:input type="text" path="surname" name="surname" id="surname" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="dateOfBirth">Date Of Birth</form:label>
					</td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.dateOfBirth}"/>
					<td><form:input type="date" path="dateOfBirth" name="dateOfBirth" id="dateOfBirth" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Mail</form:label></td> 		
					<td><form:input type="email" path="email" name="mail" id="mail" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" name="password" id="password" class="form-control" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button id="register" name="register" class="btn btn-primary">Register</form:button></td>
				</tr>
			</table>
			
		</div>
		</form:form>
			<br>
	<jsp:include page="footer.jsp" />