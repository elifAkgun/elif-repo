<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Organization Result</title>
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
            <h1>Organization Registration Summary</h1>
        </div>
        </br>
        <div class="container">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="company-name">Company Name</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="company-name"
                           value="${orgRegistration.organization.companyName}">
                </div>


                <label class="col-sm-2 col-form-label" for="yearOfIncorporation">Year Of Incorporation</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="yearOfIncorporation"
                           value="${orgRegistration.organization.yearOfIncorporation}">
                </div>

                <label class="col-sm-2 col-form-label" for="city">City</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="city"
                           value="${orgRegistration.organization.city}">
                </div>

                <label class="col-sm-2 col-form-label" for="postal-code">Postal Code</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="postal-code"
                           value="${orgRegistration.organization.postalCode}">
                </div>

                <label class="col-sm-2 col-form-label" for="benefits">Benefits</label>
                <div class="col-sm-10">
                    <c:forEach var="entry" items="${organizationBenefitResources}">
                        <c:if test="${fn:contains( orgRegistration.organization.benefits , entry.key)}">
                            <input type="text" readonly class="form-control-plaintext" id="benefits"
                                   value="${entry.value}">
                        </c:if>
                    </c:forEach>
                </div>

                <label class="col-sm-2 col-form-label" for="slogan">Slogan</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="slogan"
                           value="${orgRegistration.organization.slogan}">
                </div>

                <label class="col-sm-2 col-form-label" for="employee-count">Employee Count</label>
                <div class="col-sm-10">
                    <c:forEach var="entry" items="${organizationEmployeeResources}">
                        <c:if test="${orgRegistration.organization.employeeCount eq entry.key}">
                            <input type="text" readonly class="form-control-plaintext" id="employee-count"
                                   value="${entry.value}">
                        </c:if>
                    </c:forEach>
                </div>

                <label class="col-sm-2 col-form-label" for="manager">Manager Count</label>
                <div class="col-sm-10">
                    <c:forEach var="entry" items="${organizationResources}">
                        <c:if test="${orgRegistration.organization.managerCount eq entry.key}">
                            <input type="text" readonly class="form-control-plaintext" id="manager"
                                   value="${entry.value}">
                        </c:if>
                    </c:forEach>

                </div>

                <label class="col-sm-2 col-form-label" for="like">Do you like our website?</label>
                <div class="col-sm-10">
                    <c:forEach var="entry" items="${yesNoResources}">
                        <c:if test="${orgRegistration.likeOurWebSite eq entry.key}">
                            <input type="text" readonly class="form-control-plaintext" id="like"
                                   value="${entry.value}">
                        </c:if>
                    </c:forEach>
                </div>

                <label class="col-sm-2 col-form-label" for="visit">Do you want to visit again?</label>
                <div class="col-sm-10">
                    <c:choose>
                        <c:when test="${orgRegistration.visitAgain eq 'Yes'}">
                            <input type="text" readonly class="form-control-plaintext" id="visit"
                                   value="Yes">
                        </c:when>
                        <c:otherwise>
                            <input type="text" readonly class="form-control-plaintext" id="visit"
                                   value="You don't want to visit again.">
                        </c:otherwise>
                    </c:choose>
                </div>

                <label class="col-sm-2 col-form-label" for="sub">Subscriptions</label>
                <div class="col-sm-10">
                    <c:forEach var="entry" items="${subscriptionList}">
                        <c:forEach var="sub" items="${orgRegistration.subscription}">
                            <c:if test="${fn:contains(sub , entry.key)}">
                                <input type="text" readonly class="form-control-plaintext" id="sub"
                                       value="${entry.value}">
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </div>

                <label class="col-sm-2 col-form-label" for="pay">Payment Type</label>
                <div class="col-sm-10">
                    <c:forEach var="entry" items="${paymentType}">
                        <c:if test="${orgRegistration.payBillOption eq entry.key}">
                            <input type="text" readonly class="form-control-plaintext" id="pay"
                                   value="${entry.value}">
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>

    </body>
</html>
