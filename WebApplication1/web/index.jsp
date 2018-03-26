<%-- 
    Document   : index
    Created on : Mar 19, 2018, 11:45:49 PM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username <input type="text" name="username" value="" /><br/>
            Password <input type="password" name="password" value="" /><br/>
            <input type="submit" value="Login" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
