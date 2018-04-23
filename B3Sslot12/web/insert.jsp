<%-- 
    Document   : insert
    Created on : Apr 23, 2018, 10:44:03 AM
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
        <h1>register</h1>
        <form action="MainController" method="POST">
            Username <input type="text" name="username" value="${param.username}" />
            <font color="red">${requestScope.INVALID.usernameError}</font>
            <br/>
            Password <input type="password" name="password" value="" />
            <font color="red">${requestScope.INVALID.passwordError}</font>
            <br/>
            Confirm <input type="password" name="confirm" value="" />
            <font color="red">${requestScope.INVALID.confirmError}</font>
            <br/>
            Fullname <input type="text" name="fullname" value="${param.fullname}" />
            <font color="red">${requestScope.INVALID.fullnameError}</font>
            <br/>
            Role <input type="text" name="role" value="${param.role}"/>
            <font color="red">${requestScope.INVALID.roleError}</font>
            <br/>
            <input type="submit" value="Register" name="action" />
        </form>
    </body>
</html>
