<%-- 
    Document   : register
    Created on : Apr 24, 2018, 5:30:05 PM
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
        <h1>Register</h1>
        <form action="MainController">
            <font color="red">${requestScope.INVALID.username}</font><br/>
            Username <input type="text" name="username" value="${param.username}" /><br/>
            <font color="red">${requestScope.INVALID.password}</font><br/>
            Password <input type="password" name="password" value="" /><br/>
            <font color="red">${requestScope.INVALID.confirm}</font><br/>
            Confirm Password <input type="password" name="confirm" value="" /><br/>
            <font color="red">${requestScope.INVALID.fullname}</font><br/>
            Fullname <input type="text" name="fullname" value="${param.fullname}" /><br/>
            <font color="red">${requestScope.INVALID.role}</font><br/>
            Role <input type="text" name="role" value="${param.role}" /><br/>
            <input type="submit" value="Register" name="action" />
        </form>
    </body>
</html>
