<%-- 
    Document   : index
    Created on : Apr 24, 2018, 8:19:50 AM
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
        <form action="MainController">
            Username <input type="text" name="username" value="${param.username}" /><br/>
            <font color="red">
            <h2>${requestScope.INVALID.username}</h2>
            </font>
            Password <input type="password" name="password" value="" /><br/>
            <font color="red">
            <h2>${requestScope.INVALID.password}</h2>
            </font>            
            <input type="submit" value="Login" name="action"/>
            <input type="reset" value="Reset" name="action" />
        </form>
        <font color="red">
        <h2>${requestScope.ERROR}</h2>
        </font>
        <a href="register.jsp">Create Account</a>
    </body>
</html>
