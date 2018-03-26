<%-- 
    Document   : error
    Created on : Dec 8, 2017, 12:00:58 PM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>ERROR PAGE!</h1>
        <%
            String error = (String) request.getAttribute("ERROR");
        %>
        <font>
        <%= error%>
        </font>
    </body>
</html>
