<%-- 
    Document   : index
    Created on : 11 Mar, 2017, 9:00:25 PM
    Author     : Arun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>PRP_TS</title>
        <link rel="shortcut icon" href="logo.png" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <!-- Div for Brand Name -->
                <div class="navbar-header">
                    <a href="/PRP_TS/" class="navbar-brand">
                        <span class="glyphicon glyphicon-home">
                            <!-- <img src="logo.png" alt="" class="img-circle" /> -->
                        </span>
                        &nbsp;Training Scheduler
                    </a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav1">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                
                <div class="collapse navbar-collapse" id="nav1">
                    <form action="MainServlet" method="post" class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" id="username" name="" class="form-control" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <input type="password" id="username" name="" class="form-control" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </form>                    
                </div>
            </div>
        </nav>



        <!-- Footer Navbar -->
        <nav class="navbar navbar-default navbar-inverse navbar-fixed-bottom">
            <div class="container-fluid">
                <div class="navbar-header navbar-right">
                    <a href="http://www.ksrce.ac.in" class="navbar-brand">
                        Powered By
                    </a>
                </div>
                
                <ul class="nav navbar-nav">
                    <li>
                        <a href="aboutUs.html" title="" class="btn">About us</a>
                    </li>
                    <li>
                        <a href="contactUs.html" title="" class="btn">Contact us</a>
                    </li>
                </ul>              
            </div>
        </nav>       
    </body>
</html>
