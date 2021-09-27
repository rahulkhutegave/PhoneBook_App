<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
</head>
<body>
			<h1>Enter Contact Details</h1>
			
			<p>
					<font color="green" >${succMsg }</font>
			</p>
			<p>
					<font color="red" >${errMsg }</font>
			</p>


	<form:form action="saveContact?contactId=${contact.contactId }" modelAttribute="contact" method="POST">
	
		<table>
				<tr>
					<td>Contact Name</td>
					<td><form:input path="contactName" /></td>
				</tr>
				<tr>
					<td>Contact Email</td>
					<td><form:input path="contactEmail" /></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><form:input path="contactNumber" /></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="save" /></td>
				</tr>
		
		</table>
	
	
	</form:form>

	<a href="viewContacts?pno=1">ViewAllContacts</a>

</body>
</html>