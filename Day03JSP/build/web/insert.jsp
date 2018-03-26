<%-- 
    Document   : insert
    Created on : Dec 7, 2017, 10:43:29 AM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <h1>Insert Page</h1>
        <form action="MainController" method="POST">
            Username <input type="text" name="txtUsername" value="" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            Fullname <input type="text" name="txtFullname" value="" /><br/>
            Role <input type="text" name="txtRole" value="" /><br/>
            <input type="submit" value="Insert" name="action" />
        </form>
    </body>
</html>
