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
		
		$(".book_title").click(function() {
			var name = $(this).text();
			$("#rname").val(name);
			$("#borrowform").submit();
		});
		$(".search_button").click(function() {
			var name = $("#search_tag").val();
			$("#sname").val(name);
			$("#searchForm").submit();
		});
	
	});
	</script>
    </head>
<<body class="bg-faded">
    <div class="container-fluid">
        <nav class="navbar fixed-top navbar-light nav-border bg-white">
            <a class="navbar-brand">
                <img src="img/dlsu_signature.png" height="40" alt="">
            </a>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row p-3">
            <div class="col-2 bg-white pl-4 pr-4 pt-3 pb-3">
                Filter Resources:
                <div class="form-check mt-3">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value=""> Book
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value=""> Magazine
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value=""> Thesis
                    </label>
                </div>
            </div>
            <div class="col-9 bg-white ml-3 pl-4 pr-4 pt-3 pb-3 text-center">
                <form id="searchForm" action = "SearchPageServlet" method = post>
                    <div class="form-group row no-gutters m-4">
                        <div class="col-6">
                            <input type="text" id="search_tag" class="form-control" placeholder="Search">
                        </div>
                        <input type="hidden" name="searchtag" id="sname" />
                        <input type="hidden" name="userid" value="${userid}" />
                        <div class="col-2 search_button">
                            <button type="submit" class="btn btn-success full-width">Search</button>
                        </div>
                    </div>
                    
                </form>
			
                <p>Resources</p>
                <div class = "row mt-5 text-center">
               <c:forEach var="r" items="${resourcelist}">
               
                    <div class="col-3 mt-5">
                        <img src="img/book.png"><br>
                        <a href ="#" class ="book_title">${r.title}</a>
                    </div>
                    </c:forEach>
                    </div>
            </div>
            <form id="borrowform" action="BookReservationServlet" method="post">
			 <input type="hidden" name="resourceID" id="rname" />
			 <input type="hidden" name="userid" value="${userid}" />
	         	</form>
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