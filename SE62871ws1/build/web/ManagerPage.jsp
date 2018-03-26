<%-- 
    Document   : managerPage
    Created on : Mar 9, 2018, 10:56:05 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER.fullName}!</h1>
        <h1>Welcome to Manager Page!</h1>
        <font color="red">
        Sorry, this role currently not supported!
        </font><br/>
        <a href="Try">Return to Login Page</a>
    </body>
</html>
