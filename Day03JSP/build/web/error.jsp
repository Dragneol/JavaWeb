<%-- 
    Document   : error
    Created on : Dec 6, 2017, 11:37:16 AM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR PAGE!</h1>
        <%
            String error = (String) request.getAttribute("ERROR");
        %>
        <font>
        <%= error%>
        </font>
        <br/>
        <a href="index.jsp">Back to Login Page</a>
    </body>
</html>
