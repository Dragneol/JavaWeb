<%-- 
    Document   : index
    Created on : Apr 23, 2018, 10:33:11 AM
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
        <h1>Login Form</h1>
        <form action="MainController" method="POST">
            Username <input type="text" name="username" value="" />${requestScope.INVALID.usernameError}<br/>
            Password <input type="password" name="password" value="" />${requestScope.INVALID.passwordError}<br/>
            ${sessionScope.ERROR}
            <input type="submit" value="SignIn" name="action" />
        </form>
            <a href="insert.jsp">Registration</a>
    </body>
</html>
