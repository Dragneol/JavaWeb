<%-- 
    Document   : userPage
    Created on : Mar 9, 2018, 10:38:14 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER.fullName}!</h1>
        <h1>Welcome to user Page!</h1><br/>
        <a href="Try">Return to Login Page</a>
    </body>
</html>
