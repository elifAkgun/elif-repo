<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Person Form</title>
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
            <h1>Organization Registration Form</h1>
        </div>
        </br>
        <div class="container">
            <form:form action="result" modelAttribute="orgRegistration"
                       method="POST" acceptCharset="UTF-8">

            <label for="companyName">Company Name</label>
            <form:input id="companyName" path="organization.companyName"
                        class="form-control"></form:input>

            <label for="employeeCount">Employee Count</label>
            <div class="form-check border" id="employeeCount">
                <form:radiobuttons path="organization.employeeCount"
                                   items="${organizationEmployeeResources}"
                                   class="form-check-input" value="1" delimiter="</br>"/>
                </br>

            </div>

            <label for="benefit">Benefits</label>
            <div class="form-check border" id="benefit">
                <form:checkboxes path="organization.benefits"
                                 items="${organizationBenefitResources}"
                                 class="form-check-input" delimiter="</br>"/>
            </div>

            <label for="postalCode">Postal Code</label>
            <form:input id="postalCode" path="organization.postalCode"
                        class="form-control"></form:input>

            <label for="slogan">Slogan</label>
            <form:input id="slogan" path="organization.slogan" class="form-control"></form:input>

            <label for="yearOfIncorporation">Year Of Incorporation</label>
            <form:input id="yearOfIncorporation" path="organization.yearOfIncorporation"
                        class="form-control"></form:input>
            <label for="city">City</label>
            <form:select path="organization.city" id="city" cssClass="form-select form-control">
                <form:option value="Other">Other</form:option>
                <form:option value="Istanbul">Istanbul</form:option>
                <form:option value="Ankara">Ankara</form:option>
                <form:option value="İzmir">İzmir</form:option>
            </form:select>

            <label for="managerCount">Manager Count</label>
            <form:select path="organization.managerCount" id="managerCount"
                         cssClass="form-select form-control">
                <form:options items="${organizationResources}"></form:options>
            </form:select>
            </br>


            <div class="form-group row">
                <div class="col-sm-2">
                    <label for="like">Do you like our website?</label>
                </div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <form:checkbox id="like" path="likeOurWebSite"
                                       items="${yesNoResources}"
                                       class="form-check-input"/>
                    </div>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-2"><label for="visit">Do you want to visit again?</label></div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <form:checkbox id="visit" path="visitAgain"
                                       class="form-check-input"
                                       value="Yes"/>
                    </div>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-2"><label for="sub">Subscriptions</label></div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <form:checkbox id="sub" path="subscription"
                                       value="emailServices"/> ${subscriptionList.get('emailServices')}
                        <form:checkbox id="sub" path="subscription"
                                       value="letterService"/> ${subscriptionList.get('letterService')}
                        <form:checkbox
                                id="sub" path="subscription"
                                value="promotionalService"/> ${subscriptionList.get('promotionalService')}
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-2"><label for="payment">Payment Options</label></div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <form:radiobutton id="payment" path="payBillOption"
                                          value="creditCard"/> ${paymentType.get('creditCard')}
                        <form:radiobutton id="payment" path="payBillOption"
                                          value="moneyTransfer"/> ${paymentType.get('moneyTransfer')}
                        <form:radiobutton
                                id="payment" path="payBillOption"
                                value="onlinePayment"/> ${paymentType.get('onlinePayment')}
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <button type="submit" value="save" class="btn btn-primary">Submit</button>
            </div>
        </div>

        </form:form>
        </div>
    </body>
</html>
