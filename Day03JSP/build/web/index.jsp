<%-- 
    Document   : index
    Created on : Dec 6, 2017, 11:25:45 AM
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
        <h1>Login Page!</h1>
    </body>
    <form action="MainController" method="POST">
        Username <input type="text" name="txtUsername" value="" /> <br/>
        Password <input type="password" name="txtPassword" value="" /> <br/>
        <input type="submit" value="Login" name='action'/>
    </form>
    <br/>
    <a href="insert.jsp">Create New Account</a>
</html>
