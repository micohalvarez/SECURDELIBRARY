<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js"></script>
<script type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Name</title>

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
		
		$(".borrow_resource").click(function() {
			$("#borrowform").submit();
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
            <div class="col-10 offset-1 bg-white align-self-center bordered mt-4 p-4">
                <div class="row">
                    <div class="col-2 text-center pt-5">
                        <img src="img/book.png">
                        <br>
                        <small>
                            [Book]
                        </small>
                    </div>
                    <div class="col-10 pt-4">
                        <p class="lead text-header">${resource.title}</p>
                        <hr>
                        <table class="full-width">
                            <tr>
                                <td width="20%">Location:</td>
                                <td width="80%">${resource.location}</td>
                            </tr>
                            <tr>
                                <td width="20%">Author:</td>
                                <td width="80%">${author.lastname}, ${author.firstname}</td>
                            </tr>
                            <tr>
                                <td width="20%">Publisher:</td>
                                <td width="80%">${publisher.name}</td>
                            </tr>
                       
                            <tr>
                                <td width="20%">Tags:</td>
                                <td width="80%">${resource.tags}</td>
                            </tr>
                        </table>
                        <div class="row">
                            <div class="col mt-5">
                                <p class="lead text-header">Borrow Resource</p>

                                <div class="row mb-3">
                                    <div class="col-2">
                                        <p>Status:</p>
                                    </div>
                                   <form id="borrowform" action="ReserveResourceServlet" method="post"> 
                                   <div class="col-2 text-success">
                                        AVAILABLE
                                        <button type="submit" class="btn btn-success full-width mt-3 borrow_resource">Borrow</button>
                                        <input type="hidden" name="resourceID" id="rname" />
										 <input type="hidden" name="userid" value="${userid}" />
                                    </div>
                                    </form>
                                </div>

                                <%--<div class="row mb-3">--%>
                                    <%--<div class="col-2">--%>
                                        <%--<p>Status:</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-2 text-danger">--%>
                                        <%--BORROWED--%>
                                        <%--<br>--%>
                                        <%--<small class="text-muted">[until July 22, 2017]</small>--%>
                                        <%--<button type="submit" class="btn btn-success full-width mt-3">Reserve</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="row mb-3">--%>
                                    <%--<div class="col-2">--%>
                                        <%--<p>Status:</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-2 text-muted">--%>
                                        <%--Library use only.--%>
                                        <%--<button type="submit" class="btn btn-success disabled full-width mt-3">Borrow</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
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
</body>
</html>