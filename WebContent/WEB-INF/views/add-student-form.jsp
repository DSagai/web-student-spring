<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>


<html>
<head>
	<meta charset="utf-8">
	<title>Student Tracker App</title>
	<link type="text/css" rel="stylesheet" href="static/css/style.css">
	<link type="text/css" rel="stylesheet" href="static/css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Student</h3>
		<sf:form action="${pageContext.request.contextPath}/ADD" method ="post" commandName="student">
			<table>
				<tbody>
					<tr>
						<td>
							First name:
						</td>
						<td>
							<sf:input type="text" name = "firstName" placeholder="enter Fist Name here" path="firstName"/>
							<br/>
								 <sf:errors path="firstName" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>
							Last name:
						</td>
						<td>
							<sf:input type="text" name = "lastName" placeholder="enter Last Name here" path="lastName"/>
							<br/>
								 <sf:errors path="lastName" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td>
							Email:
						</td>
						<td>
							<sf:input type="text" name = "email" placeholder="enter Email here" path="email"/>
							<br/>
								 <sf:errors path="email" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Save"/>
						</td>
					</tr>
				</tbody>
			</table>		
		</sf:form>
		
		<div style="clear:both"></div>
		<p>
			<a href="${pageContext.request.contextPath}/">Back to student list</a>
		</p>
	</div>
</body>

</html>