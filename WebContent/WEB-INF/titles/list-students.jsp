<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	
	<div id="container">
		<div id="content">
			<input type="button" value="Add Student"
			onclick="window.location.href='<c:url value='/add-form'/>'; return false;"
			class="add_student-button"/>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				

				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
						<c:url var="tempLink" value = "/update-form">
							<c:param name="id" value="${tempStudent.id}"/>
						</c:url>
						
						<c:url var="deleteLink" value = "/DELETE">
							<c:param name="id" value="${tempStudent.id}"/>
						</c:url>
				
						<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							| 
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you shure you want to delete this student?'))) return false">
								Delete
							</a>
						</td>
						</tr>
				</c:forEach>
				
			
			</table>
			
		
		</div>
	
	</div>

