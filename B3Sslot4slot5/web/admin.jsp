<%-- 
    Document   : admin
    Created on : Apr 17, 2018, 11:37:25 AM
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
        <h1>Hello Admin!</h1>
        <h2>Search User</h2>
        <form action="MainController" method="POST">
            FullName : <input type="text" name="searchField" value="" />
            <input type="submit" value="Search" name="btnAction" />
        </form>
    </body>
</html>
