<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript">
$(document).ready(function() {
	document.f.j_username.focus();
});
</script>

	<c:if test="${param.error != null }">
		<p class="error">Login failed. Check your login and password.</p>
	</c:if>

	<div id="container">
		<form name='f'
			action='${pageContext.request.contextPath}/j_spring_security_check'
			method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td>Remember me:</td>
					<td><input type='checkbox' class = 'checkbox' name='_spring_security_remember_me' checked = 'checked' /></td>
				</tr>
				<tr>
					<td />
					<td colspan='2'><input name="submit" type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>


