<%-- 
    Document   : index
    Created on : Apr 16, 2018, 11:37:36 AM
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
        <h1>Hello World!</h1>
        <form action="LoginServlet" method="POST">
            Username <input type="text" name="username" value="" /><br>
            Password <input type="password" name="password" value="" /><br>
            <input type="submit" value="Login" name="btnAction" />
            <input type="reset" value="Reset" name="btnAction" />
        </form>
    </body>
</html>
