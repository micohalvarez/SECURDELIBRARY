<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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

 <title>Login</title>

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
<script>
    $(document).ready(function() {

        $(".registerlink").click(function() {

            $("#registerform").submit();
        });

    });
</script>

<form id="registerform" action="/reguser" method="post">
 <input type="hidden"/>
</form>

<div class="container-fluid">
 <nav class="navbar fixed-top navbar-light nav-border bg-white">
  <a class="navbar-brand">
   <img src="img/dlsu_signature.png" height="40" alt="">
  </a>
 </nav>
</div>

<div class="container-fluid">
 <div class="row">
  <div class="col-sm-4 offset-sm-4 align-self-center text-center mt-5">
   <p class="lead text-header text-muted">Log In</p>
   <form action = "/login" method="post">
    <div class="form-group pt-3">
     <input type="text" class="form-control" placeholder="Username" name = "username">
    </div>
    <div class="form-group pt-3">
     <input type="password" class="form-control" placeholder="Password" name = "password">
    </div>
    <button type="submit" class="btn btn-success full-width mt-3">Submit</button>
   </form>
   <p id="register" class="text-muted mt-5">Don't have an account? <a href="#" class="text-success registerlink" >Sign Up</a></p>


  </div>
 </div>
</div>



<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>