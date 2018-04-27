<%-- 
    Document   : error
    Created on : Apr 26, 2018, 10:58:02 AM
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
        ${requestScope.ERROR}
        </font>
    </body>
</html>
