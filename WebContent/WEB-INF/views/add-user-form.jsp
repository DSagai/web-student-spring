<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="utf-8">
<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<link type="text/css" rel="stylesheet"
	href="static/css/add-student-style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<script type="text/javascript">
function onLoad(){
	$("#password").keyup(checkPasswordMatch);
	$("#confirmpass").keyup(checkPasswordMatch);
	$("#user_form").submit(canSubmit);
	
}	

function canSubmit(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if (password == confirmpass){
		return true;
	}
	else {
		return false;
	}
}

function checkPasswordMatch(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if (password.length > 3 || confirmpass.length > 3){
		if (password == confirmpass){
			$("#matchpass").text("Passwords match.");
			$("#matchpass").addClass("valid");
			$("#matchpass").removeClass("error");
		}
		else {
			$("#matchpass").text("Passwords do not match.");
			$("#matchpass").addClass("error");
			$("#matchpass").removeClass("valid");
		}
	}
	
}

$(document).ready(onLoad);
</script>

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

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
</body>

</html>