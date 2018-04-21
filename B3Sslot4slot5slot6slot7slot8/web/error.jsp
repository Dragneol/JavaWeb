<%-- 
    Document   : error
    Created on : Apr 17, 2018, 11:13:18 AM
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
        <%
            String error = (String) request.getAttribute("ERROR");
        %>
        <font color="red"><%= error%></font><br/>
        <a href="index.jsp">Back To Login Page</a>
    </body>
</html>
