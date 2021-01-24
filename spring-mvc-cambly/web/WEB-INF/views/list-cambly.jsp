<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>List Cambly</title>


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
            <h1>My Mistakes and Corrections</h1>
        </div>
        <div class="container">
            <button type="button" class="btn btn-success"
                    onclick="window.location.href='showFormForAdd';return false;">Add
                New Record
            </button>
        </div>
        <br>
        <div class="container">
            <div class="d-flex align-items-start">
                <form:form action="search" method="GET">
                    Search record: <input type="text" name="theSearchName"/>
                    <input type="submit" value="Search" class="add-button"/>
                </form:form>
            </div>
        </div>
        <br>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>

                        <th scope="col">Mistake</th>
                        <th scope="col">Correction</th>
                        <th scope="col">Date</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="cambly" items="${camblyList}">

                        <c:url var="updateLink" value="showFormForUpdate">
                            <c:param name="camblyId" value="${cambly.id}"></c:param>
                        </c:url>

                        <c:url var="removeLink" value="showFormForDelete">
                            <c:param name="camblyId" value="${cambly.id}"></c:param>
                        </c:url>

                        <tr>
                            <td>${cambly.mistake}</td>
                            <td>${cambly.correction}</td>
                            <td>${cambly.date}</td>
                            <td>
                                <button type="button" class="btn btn-link"
                                        onclick="window.location.href='${updateLink}';return false;">Update
                                </button>
                                <button type="button" class="btn btn-link"
                                        onclick=" if(confirm('Are you sure you want to delete this record?'))
                                                window.location.href='${removeLink}'
                                                else
                                                return false;">
                                    Remove
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

    </body>
</html>