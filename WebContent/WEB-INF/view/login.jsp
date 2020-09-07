<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="header.jsp" />
<jsp:include page="index.jsp" />

<div class="container">

	<br/><h3>Login To Enter</h3>

		
		<form:form method="post" action="do-login" modelAttribute="user" class="form-horizontal">
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
					<td><button id="register" name="register" class="btn btn-primary" value="Login">Login</button></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
</div> <br/>
<jsp:include page="footer.jsp" />
