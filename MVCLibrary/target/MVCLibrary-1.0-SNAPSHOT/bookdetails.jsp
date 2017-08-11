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
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Browse Resources</title>

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

            $(".add_book").click(function() {

                $("#addform").submit();
            });
            $(".book_title").click(function() {
                var name = $(this).text();
                $("#rname").val(name);
                $("#editform").submit();
            });
        });
    </script>
</head>

<body class="bg-faded">
<div class="container-fluid">
    <nav class="navbar fixed-top navbar-light nav-border bg-white">
        <a class="navbar-brand">
            <img src="img/dlsu_signature.png" height="40" alt="">
        </a>
    </nav>
</div>

<div class="container-fluid">
    <div class="row">
        k<div class="col-sm-10 offset-sm-1 bg-white align-self-center bordered p-4">
        <!--
<p class="lead text-header pt-3 pl-3">Senior High School Library System</p>
<hr>-->

        <div class="row">
            <div class="col-sm-6 m-3">
                <!--                        <p class="lead pl-4">Results for %search/category%</p>-->

                    <div class="form-group row no-gutters ml-4">
                        <form:form action="/addbook" method = "post" id="addform">
                        <div class="col">
                            <button type="submit" class="btn btn-success full-width add_book">Add Book</button>
                        </div>
                            <input type="hidden" name="userid" value = "${userid}" />
                        </form:form>
                    </div>

            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-11 m-3">
                <ul class="list-group">
                    <p class="lead pl-4">All <Resources></Resources></p>

                    <c:forEach var="resource" items="${resources}" varStatus="status">
                        <li class="list-group-item pl-3 ">
                            <img src="img/book.png">
                            <a href="#" class="book_title">
                                    ${resource.title}
                            </a>
                        </li>
                    </c:forEach>

                    <form:form id="editform" action="/editbook" method="post">
                        <input type="hidden" name="title" id="rname" />
                        <input type="hidden" name="userid" value = "${userid}" />
                    </form:form>

                </ul>
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