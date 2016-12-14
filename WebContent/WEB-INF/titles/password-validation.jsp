<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


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

