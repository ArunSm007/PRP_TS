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
        <title>Welcome PMO</title>
        <link rel="shortcut icon" href="logo.png" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <style type="text/css">
            html,body,#main-content{
                height: 100%;
            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <!-- Div for Brand Name -->
                <div class="navbar-header">
                    <a href="/PRP_TS/" class="navbar-brand hidden-sm">
                        <span class="glyphicon glyphicon-home"></span>
                        &nbsp;Training Scheduler
                    </a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav1">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                
                <div class="collapse navbar-collapse" id="nav1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a title="" class="dropdown-toggle btn" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user"></span>
                                &nbsp;
                                Profile
                                &nbsp;
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a title="" disabled="true">
                                        <span class="glyphicon glyphicon-info-sign"></span>
                                    &nbsp;Signed in as PMO
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-wrench"></span>
                                        &nbsp;Change password
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-log-out"></span>
                                        &nbsp;Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a title="" class="dropdown-toggle btn" data-toggle="dropdown">
                                <span>
                                    <img src="lecturer.png" alt="trainer" style="height: 20px;">
                                </span>
                                &nbsp;
                                Trainer
                                &nbsp;
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                        &nbsp;Add Trainer
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-retweet"></span>
                                        &nbsp;Update Trainer
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-trash"></span>
                                        &nbsp;Remove Trainer
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>   
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a title="" class="dropdown-toggle btn" data-toggle="dropdown">
                                <span>
                                    <img src="training.png" alt="Training" style="height: 20px;">
                                </span>
                                &nbsp;
                                Training
                                &nbsp;
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                        &nbsp;Add Training
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-retweet"></span>
                                        &nbsp;Update Training
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-trash"></span>
                                        &nbsp;Remove Training
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>   
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a title="" class="dropdown-toggle btn" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-education"></span>
                                &nbsp;
                                Stream
                                &nbsp;
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                        &nbsp;Add Stream
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-retweet"></span>
                                        &nbsp;Update Stream
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-trash"></span>
                                        &nbsp;Remove Stream
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>   
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a title="" class="dropdown-toggle btn" data-toggle="dropdown">
                                <span>
                                    <img src="category.png" alt="category" style="height: 20px;">
                                </span>
                                &nbsp;
                                Category
                                &nbsp;
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                        &nbsp;Add Category
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-wrench"></span>
                                        &nbsp;Update Category
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-trash"></span>
                                        &nbsp;Remove Category
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>   
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a title="" class="dropdown-toggle btn" data-toggle="dropdown">
                                <span>
                                    <img src="venue.png" alt="venue" style="height: 20px;">
                                </span>
                                &nbsp;
                                Venue
                                &nbsp;
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="addVenue.jsp" title="">
                                        <span class="glyphicon glyphicon-plus"></span>
                                        &nbsp;Add Venue
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-wrench"></span>
                                        &nbsp;Update Venue
                                    </a>
                                </li>
                                <li>
                                    <a href="" title="">
                                        <span class="glyphicon glyphicon-trash"></span>
                                        &nbsp;Remove Venue
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>            
                </div>
            </div>
        </nav>
        
        <!-- Main Content -->
        <div class="container-fluid bg-primary" style="padding-top: 70px;padding-bottom: 70px;" id="main-content">
            <div class="row" style="height: 100%;">
                <form action="MainServlet" method="post" class="col-xs-6 col-xs-offset-3 form-horizontal text-center">
                    <div class="form-group">
                        <label for="currentVenueName" class="control-label col-xs-3">Current Venue Name</label>
                        <div class="col-xs-9">
                            <input type="text" id="currentVenueName" name="currentVenueName" class="form-control" required>
                        </div> 
                    </div>
                    <div class="form-group">
                        <label for="newVenueName" class="control-label col-xs-3">New Venue Name</label>
                        <div class="col-xs-9">
                            <input type="text" id="newVenueName" name="newVenueName" class="form-control" required>
                        </div> 
                    </div>
                    <input type="hidden" name="action" value="updateVenue">
                    <input type="submit" class="btn btn-default btn-primary" value="Add">
                </form>
                ${currentVenueName}
                ${newVenueName}
                ${venueStatus}
            </div>
        </div>
        

        <!-- Footer Navbar -->
        <nav class="navbar navbar-default navbar-inverse navbar-fixed-bottom">
            <div class="container-fluid">
                <div class="navbar-header navbar-right">
                    <span class="navbar-text">Powered By</span>
                    <a href="http://www.wipro.com/india/" class="navbar-brand" style="padding: 0;">
                        
                        <span>
                            <img src="wipro.png" alt="category" style="height: 50px;">
                        </span>
                    </a>
                    <a href="http://www.ksrce.ac.in" class="navbar-brand" style="padding: 0;margin-left: 5px;padding-top: 5px;">
            
                        <span>
                            <img src="ksrce.png" alt="category" style="height: 40px;">
                        </span>
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
