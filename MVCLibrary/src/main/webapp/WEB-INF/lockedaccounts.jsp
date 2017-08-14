<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js"></script>
    <script type="text/javascript"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Locked Accounts</title>

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
    <script>
        $(document).ready(function() {

            $(".user_title").click(function(){
                var name = $(this).text();
                $("#rname").val(name);
                $("#borrowform").submit();
            });
        });
    </script>
</head>

<body class="bg-faded">
    <div class="container-fluid">
        <nav class="navbar fixed-top navbar-light nav-border bg-white">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand">
                <img src="../img/dlsu_signature.png" height="40" alt="">
            </a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="#">Home</a>
                    <!--                    <a class="nav-item nav-link" href="#">Browse</a>-->
                    <a class="nav-item nav-link" href="room.html">Rooms</a>
                </div>
            </div>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-10 offset-1 bg-white align-self-center bordered p-4">
                <div class="row">
                    <div class="col p-4">
                        <p class="lead text-header">Locked Accounts</p>
                        <hr>
                        <div>
                            <c:forEach var="user" items="${userlist}" varStatus="status">
                            <c:if test="${user.locked == 1}">
                                <div class="row ml-3">
                                <div class="col-11">
                                    <a href="#" class="user_title">${user.username}</a>
                                    <hr>
                                </div>
                            </div>
                            </c:if>
                            </c:forEach>
                            <form id="borrowform" action="/freeaccount" method="post">
                                <input type="hidden" name="usertype" value="${usertype}"/>
                                <input type="hidden" name="username" id="rname" />
                                <input type="hidden" name="userid" value = "${userid}" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>


    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

    <script src="js/resource.js"></script>
</body>

</html>