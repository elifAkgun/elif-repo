<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
    <head>
        <title>Visitor Count</title>
    </head>
    <body>
        Time is <c:out value="${time}"></c:out>  </br>
        Your session is started at <c:out value="${sessionStartTime}"></c:out> !</br>
    </body>
</html>
