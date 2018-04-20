<%-- 
    Document   : index
    Created on : Apr 17, 2018, 11:01:51 AM
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
        <h1>Login Page</h1>
        <form action="MainController" method="POST">
            Username <input type="text" name="username" value="duong" /><br/>
            Password <input type="password" name="password" value="duong" /><br/>            
            <input type="submit" value="Login" name="btnAction" />
            <input type="reset" value="Reset" name="btnAction" />
        </form>
        <a href="insert.jsp">Sign Up</a>
    </body>
</html>
