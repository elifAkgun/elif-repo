<%--
  Created by IntelliJ IDEA.
  User: elifakgun
  Date: 10.08.2020
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="code.elif.util.Mappings" %>
<html>
<head>
    <title>Todo View Item</title>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td> ${todoItem.id} </td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td> ${todoItem.title} </td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td> ${todoItem.deadline}</td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td> ${todoItem.detail}</td>
        </tr>
    </table>
    <c:url var="listItemLink" value="${Mappings.ITEMS}"></c:url>
    <h2><a href="${listItemLink}">Return Todo Items</a></h2>
</div>
</body>
</html>
