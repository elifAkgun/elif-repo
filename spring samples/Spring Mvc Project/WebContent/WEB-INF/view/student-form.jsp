<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name:  <form:input path="firstName" />
		<br>
		Last Name: <form:input path="lastName" />
		<br>
		Country : <form:select path="country">
			<%-- <form:option value="India" label="India" />
			<form:option value="Turkey" label="Turkey" />
			<form:option value="USA" label="USA" />
			<form:option value="Germany" label="Germany" /> --%>

			<form:options items="${theCountryOptions}" />
		</form:select>
		<br>
		<br>
		
		Languages : <form:radiobuttons path="language"
			items="${theLanguageOptions}" />
	<br>
	<form:checkboxes items="${theOperatingSystems}" path="operatingSystems" />

		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>