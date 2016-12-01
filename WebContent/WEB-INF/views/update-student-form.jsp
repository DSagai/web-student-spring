<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
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
		<h3>Update Student</h3>
		<form action="${pageContext.request.contextPath}/UPDATE" method ="post">
			<input type="hidden" name="id" value="${STUDENT.id}"/>
			<table>
				<tbody>
					<tr>
						<td>
							First name:
						</td>
						<td>
							<input type="text" name = "firstName" value="${STUDENT.firstName}" required/>
						</td>
					</tr>
					<tr>
						<td>
							Last name:
						</td>
						<td>
							<input type="text" name = "lastName" value="${STUDENT.lastName}" required/>
						</td>
					</tr>
					<tr>
						<td>
							Email:
						</td>
						<td>
							<input type="text" name = "email" value="${STUDENT.email}" required/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Update"/>
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