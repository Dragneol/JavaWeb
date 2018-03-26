<%-- 
    Document   : login
    Created on : Dec 1, 2017, 3:39:41 PM
    Author     : ngocnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="/sds_fa/loginSerlet" method="POST">
            <input type="text" name="user" value="" />
            <input type="password" name="pass" value="" />
            <input type="submit" value="Login" name="submitButton" />
        </form>
    </body>
</html>
