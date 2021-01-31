<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>model-view-home</title>
        <meta charset="UTF-8">
    </head>
    <body>

        <h1>Person Form</h1>

        </br>

        <form:form modelAttribute="person">

            <form:label path="name">Name</form:label>
            <form:input path="name"></form:input>

            <form:label path="surName">SurName</form:label>
            <form:input path="surName"></form:input>

            <input type="submit">
        </form:form>

        Name : <c:out value="${name}"></c:out><br/>
        SurName : <c:out value="${surname}"></c:out>
    </body>
</html>