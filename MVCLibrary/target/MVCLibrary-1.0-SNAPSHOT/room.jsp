<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Meeting Room Reservation</title>

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
        <nav class="navbar fixed-top navbar-light nav-border bg-white";>
            <a class="navbar-brand">
                <img src="img/dlsu_signature.png" height="40" alt="">
            </a>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-10 offset-1 bg-white align-self-center bordered mt-4 p-4">
                <div class="row">
                    <div class="col offset-1 pt-4">
                        <p class="lead text-header">Meeting Room Reservation</p>
                        <hr>
                        <form>
                            <div class="form-group row">
                                <div class="col-6">
                                    <label for="roomnumber">Select Room</label>
                                    <select class="form-control custom-select mb-2 mr-sm-2 mb-sm-0" id="roomnumber">
                                        <option selected>Meeting Room 1</option>
                                        <option value="1">Meeting Room 2</option>
                                        <option value="2">Meeting Room 3</option>
                                        <option value="3">Meeting Room 4</option>
                                        <option value="3">Meeting Room 5</option>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="roomdate">Date</label>
                                    <input type="date" class="form-control" id="roomdate">
                                </div>
                            </div>
                            <p>Available Time Slots:</p>
                            <div class="form-group row">
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success">7:30 - 9:00</button>
                                </div>
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success">9:15 - 10:45</button>
                                </div>
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success">11:00 - 12:30</button>
                                </div>
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success disabled">12:45 - 2:15</button>
                                </div>
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success">2:30 - 4:00</button>
                                </div>
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success disabled">4:15 - 5:45</button>
                                </div>
                            </div>
                            <!--
<div class="form-group row">
    <div class="col-6">
        <label for="roomdate">Date</label>
        <input type="date" class="form-control" id="roomdate">
    </div>
</div>
<div class="form-group row">
    <div class="col-6">
        <label for="roomstart">Start Time</label>
        <input type="time" class="form-control" id="roomstart">
    </div>
    <div class="col-6">
        <label for="roomend">End Time</label>
        <input type="time" class="form-control" id="roomend">
    </div>
</div>
-->
                            <!--
                            <div class="form-group row">
                                <div class="col-6 offset-3 pt-3">
                                    <button type="submit" class="btn btn-success full-width">Reserve Room</button>
                                </div>
                            </div>
-->
                        </form>
                    </div>
                    <div class="col-1"></div>
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