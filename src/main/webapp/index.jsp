<%-- 
    Document   : index
    Created on : Nov 20, 2019, 5:13:18 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="prj" uri="/WEB-INF/tlds/projectlist_tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Project List</title>
    </head>
    <body>
        <div>
            <h1>Current List of Projects:</h1>
            <prj:projects/>
            <form>
                <input class='button' value='Add Project' type='submit' formaction='addProject.jsp'>
                <br>
                <input class='button' value='Remove Project' type='submit' formaction='removeProject.jsp'>
            </form>
        </div>
    </body>
</html>
