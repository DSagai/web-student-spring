<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>



	<div id="container">
		<h3>Add Student</h3>
		<sf:form id="user_form" action="${pageContext.request.contextPath}/ADD_USER"
			method="post" commandName="user">
			<table>
				<tbody>
					<tr>
						<td>Login:</td>
						<td><sf:input type="text" name="login"
								placeholder="enter Login here" path="login" /> <br /> <sf:errors
								path="login" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><sf:password name="password" id="password"
								placeholder="enter password here" path="password" /> <br /> <sf:errors
								path="password" cssClass="error" /></td>
					</tr>

					<tr>
						<td>Confirm password:</td>
						<td><input type="password" name="confirmpass"
							id="confirmpass" placeholder="enter password here" required /> <br />
							<div id="matchpass"></div></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><sf:input type="text" name="email"
								placeholder="enter Email here" path="email" /> <br /> <sf:errors
								path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</tbody>
			</table>
		</sf:form>

		<div style="clear: both"></div>
		<p>
			<a href="${pageContext.request.contextPath}/login">Back to login
				page</a>
		</p>
	</div>
