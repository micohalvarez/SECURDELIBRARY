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

        $("#add_resource").click(function () {
            $("addform").submit();
        });
        $("#edit_resource").click(function () {
            $("editform").submit();
        });
        $("#delete_resource").click(function () {
            $("deleteform").submit();
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
            <div class="col-10 offset-1 bg-white align-self-center bordered mt-4 p-4">
                <div class="row">
                    <div class="col-2 text-center pt-5">
                        <img src="../img/book.png">
                        <br>
                        <small>
                            [Book]
                        </small>
                    </div>
                    <div class="col-10 pt-4">
                        <p class="lead text-header">${book.title}</p>
                        <hr>
                        <table class="full-width">
                            <tr>
                                <td width="20%">Location:</td>
                                <td width="80%">${book.location}</td>
                            </tr>
                            <tr>
                                <td width="20%">Author:</td>
                                <td width="80%">${book.author}</td>
                            </tr>
                            <tr>
                                <td width="20%">Publisher:</td>
                                <td width="80%">${book.publisher}</td>
                            </tr>
                       
                            <tr>
                                <td width="20%">Tags:</td>
                                <td width="80%">${book.tags}</td>
                            </tr>
                        </table>
                        <c:if test="${usertype > 2}">
                        <div class="row">
                            <div class="col-2">
                                <form action="/addbook" method = "post" id="addform">
                                    <button type="submit" class="btn btn-outline-success full-width mt-3 add-resource" id="add_resource">Add</button>
                                    <input type="hidden" name="userid" value = "${userid}" />
                                </form>
                            </div>
                            <div class="col-2">
                                <form id="editform" action="/editbook" method="post">
                                    <button type="submit" class="btn btn-outline-success full-width mt-3 edit-resource" id="edit_resource">Edit</button>
                                <input type="hidden" name="title" value="${book.title}" />
                                <input type="hidden" name="userid" value = "${userid}" />
                                </form>
                            </div>
                            <div class="col-2">
                                <form action="/deletebook" method="post" id="deleteform">
                                    <button type="submit" class="btn btn-outline-success full-width mt-3 delete-resource" id="delete_resource">Delete</button>
                                    <input type="hidden" name="bookid" value = "${book.resourceID}" />
                                    <input type="hidden" name="userid" value = "${userid}" />
                                </form>
                            </div>
                        </div>
                        </c:if>
                        <div class="row">
                            <div class="col mt-5">
                                <p class="lead text-header">Borrow Resource</p>

                                <div class="row mb-3">
                                    <div class="col-2">
                                        <p>Status:</p>
                                    </div>
                                    <form action="/borrowBook" id="borrowForm" method = "post">
                                        <input type="hidden" value="${book.resourceID}" name="bookid">
                                        <input type="hidden" value="${userid}" name="userid">
                                        <input type="hidden" value="${usertype}" name ="usertype">
                                       <c:if test="${book.status == 0}">
                                        <div class="col text-success">
                                        <button type="submit" class="btn btn-success full-width mt-3 borrow_resource">Borrow</button>
                                        </div>
                                       </c:if>
                                           <c:if test="${book.status == 1}">
                                            <div class="col text-success">
                                           <button type="button" class="btn btn-success disabled full-width mt-3" disabled>Borrow</button>
                                            </div>
                                           </c:if>
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

                        <div class="row">
                            <div class="col">
                                <p class="lead text-header mt-5">Reviews</p>

                                <div class="row">
                                    <div class="col-9">
                                        <form action="/addcomment" method = "post">
                                            <input type="hidden" value="${book.resourceID}" name="bookid">
                                            <input type="hidden" value="${userid}" name="userid">
                                            <input type="hidden" value="${usertype}" name ="usertype">
                                            <div class="form-group row">
                                                <div class="col">
                                                    <c:if test="${review == 1}">
                                                    <textarea class="form-control" rows="5" placeholder="Write a review" name="review"></textarea>
                                                    </c:if>
                                                    <c:if test="${review == 0}">
                                                        <textarea class="form-control" rows="5" placeholder="Write a review" disabled></textarea>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-2">
                                                    <c:if test="${review == 1}">
                                                    <button type="submit" class="btn btn-success full-width" >Submit</button>
                                                    </c:if>
                                                    <c:if test="${review == 0}">
                                                        <button type="submit" class="btn btn-success full-width" disabled>Submit</button>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                                <div>
                                    <p class="mt-3 lead">All reviews</p>
                                    <hr>
                                    <c:forEach var="comment" items="${comments}" varStatus="status">
                                    <div class="row ml-3">
                                        <div class="col-11">
                                            <p>${comment.comment}</p>
                                            <c:forEach var="users" items="${userlist}" varStatus="status">
                                            <c:if test="${comment.userID == users.userID}">
                                            <p class="small">${users.username}</p>
                                            </c:if>
                                            </c:forEach>

                                            <hr>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
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