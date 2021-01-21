<%--
  Created by IntelliJ IDEA.
  User: elifakgun
  Date: 21.01.2021
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Persons</title>
    </head>
    <body>
        <c:forEach var="person" items="${persons}">
            Id: ${person.id}<br/>
            Name:  ${person.name}<br/>
            SurName: ${person.surName}<br/>
            Birth Date: ${person.birthDate}<br/><br/>
        </c:forEach>
    </body>
</html>
