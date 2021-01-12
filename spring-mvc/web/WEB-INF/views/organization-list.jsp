<%--
  Created by IntelliJ IDEA.
  User: elifakgun
  Date: 11.01.2021
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Organizations</title>
</head>
<body>
    <c:forEach var="organization" items="${allOrganisations}">
        <c:out value="${organization}"></c:out>
    </c:forEach>
</body>
</html>
