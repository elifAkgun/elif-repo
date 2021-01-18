<%--
  Created by IntelliJ IDEA.
  User: elifakgun
  Date: 11.01.2021
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Organizations</title>
</head>
<body>

    <c:forEach var="organization" items="${allOrganisations}">
        Id: ${organization.id}<br/>
        Name:  ${organization.companyName}<br/>
        Employee Count:  ${organization.employeeCount}<br/>
        Postal Code:  ${organization.postalCode}<br/>
        Slogan: ${organization.slogan}<br/>
        Year Of Incorporation: ${organization.yearOfIncorporation}<br/><br/>
    </c:forEach>

    <c:out value="${greeting}"></c:out>
</body>
</html>
