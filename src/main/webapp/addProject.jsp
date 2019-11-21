<%-- 
    Document   : addProject
    Created on : Nov 20, 2019, 6:01:36 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Add Project</title>
    </head>
    <body>
        <div>
            <h1>Add a Project</h1>
            <form>
                <label>Password: </label><input type='text' name='password'>
                <br>
                <label>Project Name: </label><input type='text' name='name'>
                <br>
                <label>App Link: </label><input type='text' name='appLink'>
                <br>
                <label>Code Link: </label><input type='text' name='codeLink'>
                <br>
                Description:<br>
                <textarea rows="4" cols="50" name='description'></textarea>
                <br>
                <br>
                <input class='submit' type='submit' formaction='AddProject.do' formmethod='POST'>
                <input class='back' type='submit' value='Back' formaction='index.jsp'>
            </form>
        </div>
    </body>
</html>
