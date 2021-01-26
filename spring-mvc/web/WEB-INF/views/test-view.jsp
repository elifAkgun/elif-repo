<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Test</title>
        <meta charset="UTF-8">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
              crossorigin="anonymous">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
                crossorigin="anonymous"></script>
        <script
                src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
                crossorigin="anonymous"></script>
        <script
                src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
                crossorigin="anonymous"></script>

        <div class="d-flex justify-content-center">

            <c:forEach var="testParameter" items="${param}">
                <div class="d-flex flex-column">
                    <div class="p-2">
                        <c:out value=" ${testParameter.key}"/> = <c:out value="${testParameter.value}"/>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="d-flex justify-content-center">
                <div class="d-flex flex-column">
                    <div class="p-2">
                        <c:out value="test"/> = <c:out value="${test}"/>
                    </div>
                </div>
        </div>
        <div class="d-flex justify-content-center">
            <div class="d-flex flex-column">
                <div class="p-2">
                    <c:out value="model"/> = <c:out value="${model}"/>
                </div>
            </div>
        </div>
    </body>
</html>
