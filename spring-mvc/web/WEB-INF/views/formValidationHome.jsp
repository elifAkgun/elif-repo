<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <div class="container">
            <h1>Welcome to OrganizationRegister Validation</h1>


            <form:form action="registerOrgRep" modelAttribute="orgRep">
                <div class="form-group">
                    <form:label path="firstName" for="firstName">First Name</form:label>
                    <form:input path="firstName" id="firstName" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="firstName"></form:errors>
                </div>

                <div class="form-group">
                    <form:label path="phone" for="phone">Phone Number</form:label>
                    <form:input cssClass="form-control" path="phone" id="phone"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="phone"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="email" for="email">Email</form:label>
                    <form:input path="email" id="email" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="email"></form:errors>
                </div>
                <div class="form-group">
                    <button type="submit" value="Submit" class="btn btn-primary">Submit</button>
                </div>
                <div class="form-group">
                    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
                    <c:if test="${contextPath ne null}">
                        <a href="${contextPath}/validationDemo/home">Click here to refresh the form!</a>
                    </c:if>
                </div>
            </form:form>
        </div>
    </body>
</html>
