<%--
  Created by IntelliJ IDEA.
  User: elifakgun
  Date: 10.08.2020
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="code.elif.util.Mappings" %>
<html>
<head>
    <title>Todo Application</title>
</head>
<body>
<div align="center">
    <c:url var="listItemLink" value="${Mappings.ITEMS}"></c:url>
    <h2><a href="${listItemLink}">Show TODO items</a></h2>
</div>
</body>
</html>
