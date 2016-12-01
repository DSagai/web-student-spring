<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>
	<meta charset="utf-8">
	<title>Student Tracker App</title>
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
		<h3>Add Student</h3>
		<form action="${pageContext.request.contextPath}/ADD" method ="post">
			<table>
				<tbody>
					<tr>
						<td>
							First name:
						</td>
						<td>
							<input type="text" name = "firstName" placeholder="enter Fist Name here" required/>
						</td>
					</tr>
					<tr>
						<td>
							Last name:
						</td>
						<td>
							<input type="text" name = "lastName" placeholder="enter Last Name here" required/>
						</td>
					</tr>
					<tr>
						<td>
							Email:
						</td>
						<td>
							<input type="text" name = "email" placeholder="enter Email here" required/>
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
		</form>
		
		<div style="clear:both"></div>
		<p>
			<a href="${pageContext.request.contextPath}/">Back to student list</a>
		</p>
	</div>
</body>

</html>