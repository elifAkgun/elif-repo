<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Organization Home Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <ul>
             <li> <a href="${contextPath}/organization-list"> Organisation list using JDBC</a></li>
             <li> <a href="${contextPath}/jndi-example">Organisation list using JNDI</a></li>
        </ul>
        <c:out value="${greeting}"></c:out>
    </body>
</html>