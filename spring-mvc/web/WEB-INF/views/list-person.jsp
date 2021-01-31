<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>List Person</title>


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
            <h1>Müşteri Takip Sistemi</h1>
        </div>
        <div class="container">
            <button type="button" class="btn btn-success"
                    onclick="window.location.href='showFormForAdd';return false;">Add
                New Customer
            </button>
        </div>
        <br>
        <div class="container">
            <div class="d-flex align-items-start">
                <form:form action="search" method="GET">
                    Search customer: <input type="text" name="theSearchName"/>
                    <input type="submit" value="Search" class="add-button"/>
                </form:form>
            </div>
        </div>
        <br>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Birth Date</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="person" items="${personList}">

                        <c:url var="updateLink" value="showFormForUpdate">
                            <c:param name="personId" value="${person.id}"></c:param>
                        </c:url>

                        <c:url var="removeLink" value="showFormForDelete">
                            <c:param name="personId" value="${person.id}"></c:param>
                        </c:url>

                        <tr>
                            <td>${person.name}</td>
                            <td>${person.surName}</td>
                            <td>${person.birthDate}</td>
                            <td>
                                <button type="button" class="btn btn-link"
                                        onclick="window.location.href='${updateLink}';return false;">Update
                                </button>
                                <button type="button" class="btn btn-link"
                                        onclick=" if(confirm('Are you sure you want to delete this customer?'))
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