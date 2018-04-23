<%-- 
    Document   : error
    Created on : Apr 23, 2018, 9:49:18 AM
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
        <h1>ERROR PAGE</h1>
        <font color="red">
        <h2>${requestScope.ERROR}</h2>
        </font>
        <a href="index.jsp">Back To Login Page</a>
    </body>
</html>
