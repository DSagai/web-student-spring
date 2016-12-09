<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
<title>student Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update student</h3>

		<sf:form action="${pageContext.request.contextPath}/UPDATE"
			method="post" commandName="student">
			<sf:input type="hidden" name="id" value="${student.id}" path="id" />
			<table>
				<tbody>
					<tr>
						<td>First name:</td>
						<td><sf:input type="text" name="firstName" path="firstName"
								value="${student.firstName}" required = "true" />
								<br/>
								 <sf:errors path="firstName" cssClass="error"/></td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td><sf:input type="text" name="lastName" path="lastName"
								value="${student.lastName}" required = "true"  /> <sf:errors
								path="lastName" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><sf:input type="text" name="email"
								value="${student.email}" path="email" required = "true"  /> <sf:errors
								path="email" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Update" /></td>
					</tr>
				</tbody>
			</table>
		</sf:form>


		<div style="clear: both"></div>
		<p>
			<a href="${pageContext.request.contextPath}/">Back to student
				list</a>
		</p>
	</div>
</body>

</html>