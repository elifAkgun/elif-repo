<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>List Customer</title>
<!-- Link our css style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom-dialog.js"></script>
</head>
<body>


	<div id="wrapper">
		<div id="header">
			<h1>CRM- Müşteri Takip Sistemi</h1>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>

						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="tempCustomer" items="${customerList}">
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



</body>
</html>