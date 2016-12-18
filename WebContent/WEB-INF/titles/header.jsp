<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div id="container">

	<table>
		<tr>
			<th>
				<h2>FooBar University</h2>
			</th>
			<th><sec:authorize access="!isAuthenticated()">
					<a href="<c:url value='/add-user-form'/>">Add user</a>
				</sec:authorize> <sec:authorize access="isAuthenticated()">
					<sec:authentication var="user" property="principal" />
					${user.username}
					<a href="<c:url value='/logout'/>">Log out</a>
				</sec:authorize></th>
		</tr>
	</table>

</div>



