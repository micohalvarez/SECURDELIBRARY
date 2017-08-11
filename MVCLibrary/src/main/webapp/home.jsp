<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Home</title>

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
        
        .scrollmenu {
            overflow: auto;
            white-space: nowrap;
        }
        
        .scrollitem {
            display: inline-block;
            text-align: center;
            padding: 14px;
        }
    </style>
    <script>
        $(document).ready(function() {

            $(".add").click(function() {
                $("#addform").submit();
            });

        });
    </script>
</head>

<body class="bg-faded">
    <div class="container-fluid">
        <nav class="navbar fixed-top navbar-light nav-border bg-white">
            <c:if test="${user.userType == 5}">
            <form:form action="/creuser" method = "post" id="addform">
                <input type="hidden" name="admin" value="${user.userType}">
            <button type="submit" class="navbar-toggler navbar-toggler-right add"  aria-controls="navbarNav">
            </button>
            </form:form>
            </c:if>
            <c:if test="${user.userType == 4 || user.userType == 3}">
                <form:form action="/bookdet" method = "post" id="addform">
                    <input type="hidden" name="userid" value="${user.userID}">
                    <button type="submit" class="navbar-toggler navbar-toggler-right add"  aria-controls="navbarNav">
                    </button>
                </form:form>
            </c:if>
            <a class="navbar-brand">
                <img src="img/dlsu_signature.png" height="40" alt="">
            </a>
            <%--<div class="collapse navbar-collapse" id=""navbarNav>--%>
                <%--<ul class="navbar-nav">--%>
                    <%--<li class="nav-item active">--%>
                        <%--<a class="nav-link" href="#">Home</a>--%>
                    <%--</li>--%>
                    <%--<li class="nav-item active">--%>
                        <%--<a class="nav-link" href="#">Rooms</a>--%>
                    <%--</li>--%>
                    <%--<li class="nav-item active">--%>
                        <%--<a class="nav-link" href="#">Sign Out></a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-10 offset-sm-1 bg-white align-self-center bordered p-4">
                <p class="lead text-header pt-3 pl-3">Senior High School Library System</p>
                <hr>

                <div class="row">
                    <div class="col-sm-6 m-3">
                        <p class="lead pl-4">Search for books, articles, magazines, and more</p>

                        <form:form action="/search" method="post" modelAttribute="user">
                            <input type="hidden" value = "${user.userID}" name= "id">
                            <div class="form-group row no-gutters ml-4">
                                <div class="col-10">
                                    <input type="text" class="form-control" name="keyword"/>
                                </div>}
                                <div class="col-2">
                                    <button type="submit" class="btn btn-success full-width">Search</button>
                                </div>
                            </div>
                            <div class="form-check form-check-inline ml-4">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Keyword
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> Title
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> Author
                                </label>
                            </div>
                        </form:form>
                    </div>

                    <div class="col-sm-3 offset-2 mt-3">
                        <p class="lead">Need a meeting room?</p>
                        <button type="submit" class="btn btn-outline-success">Reserve Room</button>
                    </div>

                </div>

            </div>
        </div>
    </div>


    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>

</html>