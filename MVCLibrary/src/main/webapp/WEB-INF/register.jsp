<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js"></script>
<script type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Register</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <style>
        body {
            padding-top: 80px;
        }

        .bg-white {
            background: #ffffff !important;
        }

        .rounded-edge {
            border-radius: 4px;
        }

        .text-header {
            font-size: xx-large;
        }

        .full-width {
            width: 100%;
        }

        .bordered {
            border: 2px;
            border-style: solid;
            border-color: #E6E6E6;
        }

        .nav-border {
            box-shadow: 5px 5px 5px #EEEEEE;
        }
    </style>
</head>
<body class="bg-faded">
    <div class="container-fluid">
        <nav class="navbar fixed-top navbar-light nav-border bg-white">
            <a class="navbar-brand">
                <img src="../img/dlsu_signature.png" height="40" alt="">
            </a>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-4 offset-4 bg-white align-self-center bordered mt-5 p-4">
                <p class="lead text-header text-center">Sign Up</p>
                <form:form action="/signUp"  method = "post" modelAttribute="user" >
                    <div class="row">
                        <div class="col-9 form-group">
                            <form:input type="text" cssClass="form-control" placeholder="First Name" path ="firstname"/>
                        </div>
                        <div class="col-3 form-group">
                                <form:input type="text" cssClass="form-control" placeholder="M.I." path ="initial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:input type="text" cssClass="form-control" placeholder="Last Name" path ="lastname"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" cssClass="form-control" placeholder="ID Number" path ="idNumber"/>
                        <small class="form-text text-muted">Student Number or Employee Number</small>
                    </div>
                    <div class="form-group">
                        <form:input type="text" cssClass="form-control" placeholder="Username" path ="username"/>
                    </div>
                    <div class="form-group row">
                        <div class="col-7">
                            <form:input type="text" cssClass="form-control" placeholder="Email" path ="email"/>
                        </div>
                        <div class="col-5">
                            <p class="text-muted">@ dlsu.edu.ph</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:input type="password" cssClass="form-control" placeholder="Password" path ="password"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" cssClass="form-control" placeholder="yyyy/dd/mm" path ="birthday"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" path="secretquestion" placeholder="What is your favorite Color?" cssClass="form-control" />
                    </div>

                    <div class="form-group">
                        <form:input type="text" cssClass="form-control mt-2" placeholder="Answer" path ="secAns"/>
                    </div>

                    <c:if test="${usertype < 2}">
                        <div class="form-group">
                            <input type="hidden" value="1" name="userType"/>
                        </div>
                    </c:if>
                    <c:if test="${usertype > 1}">
                    <div class="form-group">
                        <form:input type="text" cssClass="form-control mt-2" placeholder="1,2,3" path ="userType"/>
                    </div>
                    </c:if>

                    <div>
                        <button type="submit" class="btn btn-success full-width mt-3">Submit</button>
                    </div>

                </form:form>

            </div>
        </div>
        <div class="row">
            <div class="col-4 offset-4 mt-5">
                <p class="text-muted text-center mt-3">Already have an account? <a class="text-success" href="login.html">Log In</a></p>
            </div>
        </div>
    </div>



    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>