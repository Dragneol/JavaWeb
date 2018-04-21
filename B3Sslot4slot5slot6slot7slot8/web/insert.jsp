<%-- 
    Document   : insert
    Created on : Apr 19, 2018, 9:25:26 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration</h1>
        <form action="MainController" method="POST">
            Username : <input type="text" name="username" value="" /><br/>
            Password : <input type="password" name="password" value="" /><br/>
            Fullname : <input type="text" name="fullname" value="" /><br/>
            <input type="submit" value="Register" name="btnAction" />
        </form>
    </body>
</html>
