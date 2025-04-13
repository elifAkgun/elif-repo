<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Cambly Form</title>
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
            <h1>Cambly Form</h1>
        </div>
        </br>
        <div class="container">
            <form:form action="saveCambly" modelAttribute="cambly"
                       method="POST">
                <h3>Save Cambly</h3>

                <form:hidden path="id"/>
                <form:hidden path="lessonId"/>

                <div class="form-group">
                    <label for="exampleInputMistake">Mistake</label>
                    <form:input path="mistake" class="form-control"
                                id="exampleInputMistake"></form:input>
                </div>

                <div class="form-group">
                    <label for="exampleInputCorrection">Correction</label>
                    <form:input path="correction" class="form-control"
                                id="exampleInputCorrection"></form:input>
                </div>


                <div class="form-group">
                    <label for="exampleInputDate1">Date</label>
                    <form:input path="date" class="form-control"
                                id="exampleInputDate1" aria-describedby="dateHelp"></form:input>
                </div>

                <button type="submit" value="save" class="btn btn-primary">Submit</button>
                <br>
            </form:form>
            <button type="button" class="btn btn-link"
                    onclick="window.location.href='list';return false;">Return
                to Cambly List
            </button>
        </div>

    </body>
</html>