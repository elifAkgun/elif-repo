<%--
  Created by IntelliJ IDEA.
  User: elifakgun
  Date: 14.01.2021
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>Organizations</title>
</head>
<body>
    <sql:query var="rs" dataSource="jdbc/spring_db">
        select * from organization
    </sql:query>

    <c:forEach var="row" items="${rs.rows}">
        Name: ${row.company_name} <br/>
        Year: ${row.year_of_incorporation} <br/>
        Zip: ${row.postal_code} <br/>
        Emp Count: ${row.employee_count} <br/>
        Slogan: ${row.slogan} <br/><br/>
    </c:forEach>
    <c:out value="${greeting}"></c:out>
</body>
</html>
