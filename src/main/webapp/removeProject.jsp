<%-- 
    Document   : removeProject
    Created on : Nov 20, 2019, 6:01:51 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Remove Project</title>
    </head>
    <body>
        <div>
            <h1>Remove a Project</h1>
            <form>
                <label>Password: </label><input type='text' name='password'>
                <br>
                <label>Project Name: </label><input type='text' name='name'>
                <br>
                <br>
                <input class='submit' type='submit' formaction='RemoveProject.do' formmethod='POST'>
                <input class='back' type='submit' value='Back' formaction='index.jsp'>
            </form>
        </div>
    </body>
</html>
