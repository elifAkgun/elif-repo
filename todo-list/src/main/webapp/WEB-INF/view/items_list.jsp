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
    <title>Todo Items</title>
</head>
<body>
<div align="center">
    <c:url var="addItemLink" value="${Mappings.ADD_ITEM}"></c:url>
    <h2><a href="${addItemLink}">Add TODO items</a></h2>

    <table border="1" cellpadding="5">
        <caption><h2>Todo Items</h2></caption>
        <tr>
            <th>Title</th>
            <th>DeadLine</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="item" items="${todoData.items}">
            <c:url var="deleteItemLink" value="${Mappings.DELETE_ITEM}">
                <c:param name="id" value="${item.id}"></c:param>
            </c:url>
            <c:url var="editItemLink" value="${Mappings.ADD_ITEM}">
                <c:param name="id" value="${item.id}"></c:param>
            </c:url>
            <c:url var="showItemLink" value="${Mappings.ITEM}">
                <c:param name="id" value="${item.id}"></c:param>
            </c:url>
            <h2></h2>

            <tr>
                <td><c:out value="${item.title}"></c:out></td>
                <td><c:out value="${item.deadline}"></c:out></td>
                <td><a href="${showItemLink}">View</a></td>
                <td><a href="${editItemLink}">Edit</a></td>
                <td><a href="${deleteItemLink}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
