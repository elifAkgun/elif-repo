<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
	Customer Confirmed: ${customer.firstName} ${customer.lastName}
	<br> Customer has Free Passes : ${customer.freePasses}
	<br> Customer Postal Code : ${customer.postalCode}
</body>
</html>