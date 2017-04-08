<%@page import="java.util.List"%>
<%@page import="org.synergy.prp_ts.beans.CategoryDetails"%>
<%@page import="org.synergy.prp_ts.DAO.CategoryDao"%>
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
            .table > tbody > tr > td{
                border-top: none;
                vertical-align: inherit;
            }
           ::-webkit-scrollbar { 
                display: none; 
            }
            #submit {
                position: fixed;
                top: 70px;
                right: 30px;
            }
            .close{
                top: 7px !important;
                right: -5px !important;
                color: black !important;
            }
            a:hover{
                cursor: pointer;
                text-decoration: none;
            }
        </style>
        <script type="text/javascript">
            
            function addModule() {
                x = document.getElementById('moduleTable');
                var tableBody = x.getElementsByTagName('tbody')[0];
                var tableRow = document.createElement('tr');
                tableRow.className = "alert alert-dismissible";
                tableRow.setAttribute('role','alert');
                tableRow.innerHTML = "<td class=\"col-xs-1\" > <span class=\"badge\" style=\"background: black;\">"+(tableBody.rows.length+1)+"</span> </td> <td> <div name=\"module\" class=\"panel panel-info\" style=\"border: 1px solid black;margin: 0;color: black;\"> <div name = \"moduleDetails\" class=\"panel-heading\" style=\"padding: 0;\" data-toggle = \"collapse\" href = \"#"+(tableBody.rows.length+1)+"\"> <div class=\"row\" style=\"padding: 0;margin: 0;\"> <div class=\"col-xs-3\"></div> <div class=\"form-group col-xs-6 text-left\" style=\"padding: 2px;margin: 0;\"> <label for=\"moduleName\" class=\"control-label col-xs-3\" style=\"padding: 4px;\">Module Name</label> <div class=\"col-xs-9\"> <input type=\"text\" name=\"moduleName\" class=\"form-control\" required> </div> </div> <div class=\"col-xs-3\"> <button type=\"button\" onclick=\"setSno(this.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement);\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button> </div> </div> </div> <div class=\"collapse\" id=\""+(tableBody.rows.length+1)+"\"> <div class=\"panel-body\" style=\"border-top: 1px solid black;\"> <table class=\"table table-condensed table-bordered\"> <thead> <tr> <th>SNo</th> <th class=\"text-center\">Submodule Name</th> <th class=\"text-center\">Assessment Details</th> <th style=\"border: 1px solid white;\"></th> </tr> </thead> <tbody> <tr class=\"alert alert-dismissible\" role=\"alert\"> <td><span class=\"badge\">1</span></td> <td> <input type=\"text\" name=\"subModuleName\" class=\"form-control\" required> </td> <td> <div class=\"input-group\"> <span class=\"input-group-addon\"><input type=\"checkbox\" onchange=\"updateCheck(this);\" style=\"margin: 4px;\"></span> <input type=\"text\" name=\"subModuleAssessmentName\" disabled placeholder=\"Assessment Name\" class=\"form-control\"> </div> </td> <td style=\"border: 1px solid white;\"> <a type=\"button\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\"onclick=\"setSno(this.parentElement.parentElement.parentElement);\">&times;</span></a> </td> </tr> </tbody> </table> <div class=\"text-center\"> <button class=\"btn-info\" onclick=\"addSubModule(this.parentElement.previousElementSibling);return false;\">Add Submodule</button> </div> </div> <div class=\"panel-footer\" style=\"padding: 4px;border-top:1px solid black; \"> <div class=\"input-group col-xs-6 col-xs-offset-3\"> <span class=\"input-group-addon\"><input type=\"checkbox\" onchange=\"updateCheck(this);\" style=\"margin: 4px;\"></span> <input type=\"text\" name=\"assessmentName\" disabled placeholder=\"Assessment Name\" class=\"form-control\"> </div> </div> </div> </div> </td>";
                tableBody.appendChild(tableRow);    
            }

            function addSubModule(subModule){
                var tableBody = subModule.getElementsByTagName('tbody')[0];
                var tableRow = document.createElement('tr');
                tableRow.className = "alert alert-dismissible";
                tableRow.setAttribute('role','alert');
                tableRow.innerHTML = "<td><span class=\"badge\">"+(tableBody.rows.length+1)+"</span></td> <td> <input type=\"text\" name=\"subModuleName\" class=\"form-control\" required> </td> <td> <div class=\"input-group\"> <span class=\"input-group-addon\"><input type=\"checkbox\" onchange=\"updateCheck(this);\" style=\"margin: 4px;\"></span> <input type=\"text\" name=\"subModuleAssessmentName\" disabled placeholder=\"Assessment Name\" class=\"form-control\"> </div> </td> <td style=\"border: 1px solid white;\"> <a type=\"button\" data-dismiss=\"alert\" aria-label=\"Close\"><span onclick=\"setSno(this.parentElement.parentElement.parentElement);\" aria-hidden=\"true\">&times;</span></a> </td>";
                tableBody.appendChild(tableRow);
            }

            function jsonParse(){
                var jsonString = { "modules" : [] };
                var modules = document.getElementById('moduleTable').rows;
                var subMod;
                var allDivs;
                var allInp;
                var subModules;
                for(var i = 0;i < modules.length;i++){
                    jsonString.modules[i] = {};
                    allDivs = modules[i].cells[1].getElementsByTagName('div');
                    for(var j = 0;j < allDivs.length;j++){
                       if(allDivs[j].className === 'panel-heading'){
                            jsonString.modules[i].name = allDivs[j].getElementsByTagName('input')[0].value;    
                       }
                       else if(allDivs[j].className === 'panel-body'){
                            subModules = allDivs[j].getElementsByTagName('tbody')[0].rows;
                            jsonString.modules[i].subModules = [];
                            for(var k = 0;k < subModules.length;k++){
                                jsonString.modules[i].subModules[k] = {};
                                allInp = subModules[k].getElementsByTagName('input');
                                jsonString.modules[i].subModules[k].name = allInp[0].value;
                                if(allInp[1].checked){
                                    jsonString.modules[i].subModules[k].assessmentName = allInp[2].value;
                                }
                            }
                       }
                       else if(allDivs[j].className === 'panel-footer'){
                            allInp = allDivs[j].getElementsByTagName('input');
                            if(allInp[0].checked)
                                jsonString.modules[i].assessmentName = allInp[1].value;
                       }
                    }
                }
                var inp = document.createElement('input');
                inp.setAttribute('type','hidden');
                inp.setAttribute('name','jsonString');
                inp.setAttribute('value',JSON.stringify(jsonString));
                document.getElementById('mainForm').appendChild(inp);
            }

            function updateCheck(x){
                if(x.checked){
                    x.parentElement.nextElementSibling.setAttribute('required',"required");
                    x.parentElement.nextElementSibling.removeAttribute('disabled');
                }
                else{
                    x.parentElement.nextElementSibling.removeAttribute('required');
                    x.parentElement.nextElementSibling.disabled = 'disabled';
                }
            }

            function setSno(tableRow){
                var num = tableRow.getElementsByTagName('td')[0].getElementsByTagName('span')[0].innerHTML;
                while(tableRow.nextElementSibling != null){
                    tableRow.nextElementSibling.getElementsByTagName('td')[0].getElementsByTagName('span')[0].innerHTML = (num);
                    tableRow = tableRow.nextElementSibling;
                    num++;
                }
            }
        </script>
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
                                <li class="active">
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
                                <li>
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
        <div class="container-fluid bg-primary" id="mainPage" style="padding-top: 70px;padding-bottom: 70px;overflow-y: hidden,scroll;height: auto;min-height: 100%;" id="main-content">
            <div class="row col-xs-12 text-center" style="height: 100%;padding: 0;margin: 0;">
                <form class="col-xs-10 col-xs-offset-1 form-horizaontal" action="MainServlet" id="mainForm" method="post">
                    <div id="ModuleForm">
                    <div class="row">
                        <div class="form-group col-xs-6">
                            <label for="streamName" class="control-label col-xs-6">Stream Name</label>
                            <div class="col-xs-4">
                                <input type="text" name="streamName" class="form-control" required>
                            </div>
                        </div>
                        <div class="form-group col-xs-6">
                            <label for="categoryName" class="control-label col-xs-6">Category Name</label>
                            <div class="col-xs-4">
                                <select type="text" name="categoryName" class="form-control" required>
                                    <option selected disabled></option>
                                    <%
                                        List<CategoryDetails> categoryDetailses = CategoryDao.getAllCategoryDetails();
                                        for(CategoryDetails categoryDetails : categoryDetailses){
                                    %>
                                    <option value="<%=categoryDetails.getCategoryId() %>"><%=categoryDetails.getCategoryName()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <table class="table table-responsive" id="moduleTable">
                        <tbody>
                            <tr class="alert alert-dismissible" role="alert">
                                <td class="col-xs-1" >
                                    <span class="badge" style="background: black;">1</span>
                                </td>
                                <td>
                                    <div name="module" class="panel panel-info" style="border: 1px solid black;margin: 0;color: black;">
                                        <div name = "moduleDetails" class="panel-heading" style="padding: 0;" data-toggle = "collapse" href = '#1'>
                                            <div class="row" style="padding: 0;margin: 0;">
                                                <div class="col-xs-3"></div>
                                                <div class="form-group col-xs-6 text-left" style="padding: 2px;margin: 0;">
                                                <label for="moduleName" class="control-label col-xs-3" style="padding: 4px;">Module Name</label>
                                                <div class="col-xs-9">
                                                    <input type="text" name="moduleName" class="form-control" required>
                                                </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="setSno(this.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement);"><span aria-hidden="true">&times;</span></button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="collapse" id = '1'>
                                        <div class="panel-body" style="border-top: 1px solid black;">
                                            <table class="table table-condensed table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>SNo</th>
                                                        <th class="text-center">Submodule Name</th>
                                                        <th class="text-center">Assessment Details</th>
                                                        <th style="border: 1px solid white;"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="alert alert-dismissible" role="alert">
                                                        <td><span class="badge">1</span></td>
                                                        <td>
                                                            <input type="text" name="subModuleName" class="form-control" required>
                                                        </td>
                                                        <td>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><input type="checkbox" onchange="updateCheck(this);" style="margin: 4px;"></span>
                                                                <input type="text" name="subModuleAssessmentName" disabled placeholder="Assessment Name" class="form-control">
                                                            </div>
                                                        </td>
                                                        <td style="border: 1px solid white;">
                                                            <a type="button" data-dismiss="alert" aria-label="Close"><span aria-hidden="true" onclick="setSno(this.parentElement.parentElement.parentElement);">&times;</span></a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <div class="text-center">
                                                <button class="btn-info" onclick="addSubModule(this.parentElement.previousElementSibling);return false;">Add Submodule</button>
                                            </div>
                                        </div>
                                        <div class="panel-footer" style="padding: 4px;border-top:1px solid black; ">
                                            <div class="input-group col-xs-6 col-xs-offset-3">
                                                <span class="input-group-addon"><input type="checkbox" onchange="updateCheck(this);" style="margin: 4px;"></span>
                                                <input type="text" name="assessmentName" disabled placeholder="Assessment Name" class="form-control">
                                            </div>
                                        </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                    </div>
                    <div class="row text-center">
                        <button type="button" class="btn btn-info" style="margin-top: 10px;margin-bottom: 70px;" onclick="addModule()">
                            <span class="glyphicon glyphicon-plus" style="font-size: 20px;"></span>
                        </button>
                    </div>
                    <div class="row">
                        <input type="hidden" class="btn btn-success" value="addStream" name="action">
                        <input type="submit" id="submit" class="btn btn-success" onclick="jsonParse();" value="Save">
                    </div>
                </form>
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