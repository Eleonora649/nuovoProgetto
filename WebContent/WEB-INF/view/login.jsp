<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="header.jsp" />
<jsp:include page="index.jsp" />

<div class="container">

	<br/><h3>Login To Enter</h3>

		<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
		<c:if test="${not empty message}"><div class="alert alert-danger">${message}</div></c:if>
		<form:form method="post" action="loginform" modelAttribute="user" class="form-horizontal"> 
			<table>
				<tr>
					<td> Email: </td>
					<td><input name="email" type="email" class="form-control"/></td>
				</tr>
				<tr>
					<td> Password:</td>
					<td><input name="password" type="password" class="form-control"/></td>
				</tr>
				<tr>
					<td><button id="register" name="register" class="btn btn-primary">Login</button></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
</div> <br/>
<jsp:include page="footer.jsp" />
