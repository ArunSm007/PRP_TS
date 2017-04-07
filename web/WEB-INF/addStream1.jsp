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
        </style>
        <script type="text/javascript">
            
            function addModule(x) {
                x = document.getElementById(x);
                var len = document.getElementsByName('module').length;
                x = x.cloneNode(true);
                x.id = x.id+len;
                var ch = x.getElementsByTagName('input');
                for(var i = 0;i < ch.length;i++)
                    ch[i].value = '';
                ch = x.getElementsByTagName('div');
                var subMod;
                for(var i = 0;i < ch.length;i++){
                    if(ch[i].getAttribute('name') === 'subModule')
                        subMod = ch[i];
                    else if(ch[i].getAttribute('name') === 'moduleActivity')
                        ch[i].innerHTML = '';
                }
                subMod.innerHTML = "<div class=\"row\" name = \"subModuleDetails\" style=\"border: 1px solid rgb(20, 184, 206);padding: 10px;margin-bottom: 10px;\"><div><div class=\"form-group col-xs-6\"><label for=\"subModuleName\" class=\"control-label col-xs-6\">Submodule Name</label><div class=\"col-xs-4\"><input type=\"text\" name=\"subModuleName\" class=\"form-control\"></div></div><div class=\"form-group col-xs-6\"><label for=\"subModuleDuration\" class=\"control-label col-xs-6\">Submodule Duration</label><div class=\"col-xs-4\"><input type=\"text\" name=\"subModuleDuration\" class=\"form-control\"></div></div></div><div class=\"row\" name=\"subModuleActivity\"></div><div class=\"row\"><button type=\"button\" onclick=\"addActivity(this.parentElement.parentElement,'subModuleActivity')\" class=\"btn btn-primary\">Add Activity</button></div></div>";
                document.getElementById('ModuleForm').appendChild(x);
            }
            function addSubModule(x){
                var module = document.getElementById(x);
                var divs = module.getElementsByTagName('div');
                var subModule;
                for(var i = 0;i < divs.length;i++){
                    if(divs[i].getAttribute('name') === 'subModule')
                        subModule = divs[i];
                }
                var subMod = subModule.getElementsByTagName('div')[0].cloneNode(true);
                var inp = subMod.getElementsByTagName('input');
                for(var i = 0;i < inp.length;i++){
                    inp[i].value = '';
                }
                for(var i = 0;i < subMod.getElementsByTagName('div').length;i++)
                    if(subMod.getElementsByTagName('div')[i].getAttribute('name') === 'subModuleActivity')
                        subMod.getElementsByTagName('div')[i].innerHTML = '';
                subModule.appendChild(subMod);
            }
            
            function addActivity(t,identifier){
                var mod = t;
                var ch = mod.getElementsByTagName('div');
                var x;
                for(var i = 0;i < ch.length;i++){
                    if(ch[i].getAttribute('name') === identifier){
                        x = ch[i];
                        break;
                    }
                }
                if(x.getElementsByTagName('select').length == 0){
                    var innerString = "<div class=\"col-xs-4 col-xs-offset-4\" style=\"padding-bottom: 5px;\"><table class=\"table table-bordered\" style=\"margin: 0;\"><thead><tr><th>Activity Name</th><th>Duration</th></tr></thead><tbody><tr><td><select name=\"subModAct\" class=\"form-control\"><option value=\"MP\">MiniProject</option><option value=\"PC\">Practice</option></select></td><td><input type=\"text\" name=\"subModActDuration\" class=\"form-control\"></td></tr></tbody></table></div>"
                    x.innerHTML = innerString;
                }
                else{
                    var tab = x.getElementsByTagName('table')[0].getElementsByTagName('tbody')[0];
                    var cnode = tab.getElementsByTagName('tr')[0].cloneNode(true);
                    cnode.getElementsByTagName('input')[0].value = '';
                    tab.appendChild(cnode);
                }
        	}

            function addModuleActivity(t,identifier){
                var mod = t;
                var ch = mod.getElementsByTagName('div');
                var x;
                for(var i = 0;i < ch.length;i++){
                    if(ch[i].getAttribute('name') === identifier){
                        x = ch[i];
                        break;
                    }
                }
                if(x.getElementsByTagName('select').length == 0){
                    var innerString = "<div class=\"col-xs-4 col-xs-offset-4\" style=\"padding-bottom: 5px;\"><table class=\"table table-bordered\" style=\"margin: 0;\"><thead><tr><th>Activity Name</th><th>Duration</th></tr></thead><tbody><tr><td><select name=\"modAct\" class=\"form-control\"><option value=\"AS\">Assessment</option><option value=\"LB\">Logical Building</option></select></td><td><input type=\"text\" name=\"modActDuration\" class=\"form-control\"></td></tr></tbody></table></div>";
                    x.innerHTML = innerString;
                }
                else{
                    var tab = x.getElementsByTagName('table')[0].getElementsByTagName('tbody')[0];
                    var cnode = tab.getElementsByTagName('tr')[0].cloneNode(true);
                    cnode.getElementsByTagName('input')[0].value = '';
                    tab.appendChild(cnode);
                }
            }
            function jsonParse(){
                var jsonString = { "modules" : [{}] };
                var modules = document.getElementsByName('module');
                var subMod;
                var allDiv;
                for(var i = 0;i < modules.length;i++){
                    jsonString.modules[i] = {};
                    jsonString.modules[i].subModules = [];
                    allDiv = modules[i].getElementsByTagName('div');
                    for(var j = 0;j < allDiv.length;j++){
                        if(allDiv[j].getAttribute('name') === 'moduleDetails'){
                            var subDivs = allDiv[j].getElementsByTagName('input');
                            for(var k = 0;k < subDivs.length;k++){
                                if(subDivs[k].getAttribute('name') === 'moduleName')
                                    jsonString.modules[i].name = subDivs[k].value;
                                else if(subDivs[k].getAttribute('name') === 'moduleDuration')
                                    jsonString.modules[i].duration = subDivs[k].value;
                            }
                        }
                        else if(allDiv[j].getAttribute('name') === 'subModule'){
                            var divlength;
                            var divs = allDiv[j].getElementsByTagName('div');
                            jsonString.modules[i].subModules = [];
                            for(var l = 0;l < divs.length;l++){
                                if(divs[l].getAttribute('name') === 'subModuleDetails'){
                                    var rowInp = allDiv[j].getElementsByTagName('input');
                                    var rowSelect = allDiv[j].getElementsByTagName('select');
                                    divlength = jsonString.modules[i].subModules.length;
                                    jsonString.modules[i].subModules[divlength] = {};
                                    jsonString.modules[i].subModules[divlength].name = rowInp[0].value;
                                    jsonString.modules[i].subModules[divlength].duration = rowInp[1].value;
                                    jsonString.modules[i].subModules[divlength].activities = [];
                                    for(var k = 2;k < rowInp.length;k++){
                                        jsonString.modules[i].subModules[divlength].activities[k-2] = {};
                                        jsonString.modules[i].subModules[divlength].activities[k-2].activityType = rowSelect[k-2].value;
                                        jsonString.modules[i].subModules[divlength].activities[k-2].activityDuration = rowInp[k].value;
                                    }
                                }
                            }
                        }
                        else if(allDiv[j].getAttribute('name') === 'moduleActivity'){
                            jsonString.modules[i].activities = [];
                            var rowInp = allDiv[j].getElementsByTagName('input');
                            var rowSelect = allDiv[j].getElementsByTagName('select');
                            for(var k = 0;k < rowInp.length;k++){
                                jsonString.modules[i].activities[k] = {};
                                jsonString.modules[i].activities[k].activityType = rowSelect[k].value;
                                jsonString.modules[i].activities[k].activityDuration = rowInp[k].value;
                            }
                        }
                    } 
                }
                var inp = document.createElement('input');
                inp.setAttribute('type','hidden');
                inp.setAttribute('name','jsonString');
                inp.setAttribute('value',JSON.stringify(jsonString));
                document.getElementById('mainForm').appendChild(inp);
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
        <div class="container-fluid bg-primary" style="padding-top: 70px;padding-bottom: 70px;overflow-y: hidden,scroll;height: auto;min-height: 100%;" id="main-content">
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
                    <div id="module" name="module" class="row" style="border: 1px solid black;padding: 20px;margin-top: 20px;">
                        <div name = "moduleDetails">
                            <div class="form-group col-xs-6">
                                <label for="moduleName" class="control-label col-xs-6">Module Name</label>
                                <div class="col-xs-4">
                                    <input type="text" name="moduleName" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group col-xs-6">
                                <label for="moduleDuration" class="control-label col-xs-6">Module Duration</label>
                                <div class="col-xs-4">
                                    <input type="text" name="moduleDuration" class="form-control" required>
                                </div>
                            </div>
                        </div>
                        <div name="subModule" class="row col-xs-10 col-xs-offset-1" >
                            <div class="row" name = "subModuleDetails" style="border: 1px solid rgb(20, 184, 206);padding: 10px;margin-bottom: 10px;">
                                <div>
                                    <div class="form-group col-xs-6">
                                        <label for="subModuleName" class="control-label col-xs-6">Submodule Name</label>
                                        <div class="col-xs-4">
                                            <input type="text" name="subModuleName" class="form-control" required>
                                        </div>
                                    </div>
                                    <div class="form-group col-xs-6">
                                        <label for="subModuleDuration" class="control-label col-xs-6">Submodule Duration</label>
                                        <div class="col-xs-4">
                                            <input type="text" name="subModuleDuration" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" name="subModuleActivity">
                                    
                                </div>
                                <div class="row">
                                    <button type="button" onclick="addActivity(this.parentElement.parentElement,'subModuleActivity')" class="btn btn-primary">Add Activity</button>
                                </div>
                            </div>
                        </div>
                        <div name="moduleActivity" class="row">
                            
                        </div>
                        <div class="row">
                            <button type="button" onclick="addSubModule(this.parentElement.parentElement.id);" class="btn btn-primary">Add Submodule</button>
                            <button type="button" onclick="addModuleActivity(this.parentElement.parentElement,'moduleActivity');"  class="btn btn-primary">Add Activity</button>
                        </div>
                    </div>
                    </div>
                    <div class="row text-center">
                        <button type="button" class="btn btn-info" style="margin-top: 10px;margin-bottom: 70px;" onclick="addModule('module')">
                            <span class="glyphicon glyphicon-plus" style="font-size: 20px;"></span>
                        </button>
                    </div>
                    <div class="row">
                        <input type="hidden" class="btn btn-success" value="addStream" name="action">
                        <input type="submit" class="btn btn-success" onclick="jsonParse();">
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