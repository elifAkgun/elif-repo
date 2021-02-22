<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
    <head>
        <title>Visitor Count</title>
    </head>
    <body>
        You are the <c:out value="${id}"></c:out> number of person in our system!</br>
        Total count is <c:out value="${count}"></c:out> !</br>
    </body>
</html>
