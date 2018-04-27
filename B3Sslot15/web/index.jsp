<%-- 
    Document   : index
    Created on : Apr 26, 2018, 8:50:53 AM
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
        <h1>LoginPage</h1>
        <form action="LoginController" method="POST">
            Username <input type="text" name="username" value="" /><br/>
            Password <input type="password" name="password" value="" /><br/>
            <input type="submit" value="Login" name="action" />
        </form>
    </body>
</html>
