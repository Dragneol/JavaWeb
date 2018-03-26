<%-- 
    Document   : error
    Created on : Dec 11, 2017, 3:28:54 PM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <body>
        <h1>ERROR!</h1>
        <font color="red">
        ${requestScope.ERROR}
        </font>
        <br/>
        <a href="index.jsp">back to Login</a>
    </body>
</html>
