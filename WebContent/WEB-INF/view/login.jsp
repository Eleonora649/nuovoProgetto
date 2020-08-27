<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="header.jsp" />
<jsp:include page="index.jsp" />

<div class="container">

	<!-- <body onload='document.loginForm.username.focus();'> -->
	<br/><h3>Login To Enter</h3>

		<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
		<c:if test="${not empty message}"><div class="alert alert-danger">${message}</div></c:if>
 
		<form:form method='post' class="form-horizontal"> <!--action="<c:url value='loginform' />"-->
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type='email' name='email' value='' class="form-control" required/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' class="form-control" required/></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="submit" class="btn btn-primary bottone"/></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
</div> <br/>
<jsp:include page="footer.jsp" />
