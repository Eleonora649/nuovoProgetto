<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="header.jsp" />
<jsp:include page="index.jsp" />

<div class="container">

	<br/><h3>Login To Enter</h3>
		<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
		<c:if test="${not empty message}"><div class="alert alert-danger">${message}</div></c:if>
 
		<form:form method="post" action="loginform" modelAttribute="login" class="form-horizontal"> 
			<table>
				<tr>
					<td><form:label path="email"> Email: </form:label></td>
					<td><form:input path="email" type="email" name="email" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="password"> Password: </form:label></td>
					<td><form:input path="password" type="password" name="password" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:button id="register" name="register" class="btn btn-primary">Login</form:button></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
</div> <br/>
<jsp:include page="footer.jsp" />
