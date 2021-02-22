<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Organization Home Page</title>
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
            <div class="d-flex flex-column">
                <div class="p-2"><h1>Business System</h1></div>
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <div class="p-2">
                    <div class="d-flex justify-content-around">
                        <a class="btn btn-primary" href="${contextPath}/organization-list" role="button">
                            Organisations</a>
                        </br>
                        <a class="btn btn-primary" href="${contextPath}/person/list" role="button">Persons</a>
                    </div>
                </div>
                <div class="p-2">
                    <div class="d-flex justify-content-around">
                        <a class="btn btn-primary" href="${contextPath}/session/visitorId" role="button">Visitor Count</a>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>