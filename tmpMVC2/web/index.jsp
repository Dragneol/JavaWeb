<%-- 
    Document   : index
    Created on : Feb 6, 2018, 9:38:20 AM
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
        <h1>Hello World!</h1>
        <form action="processLogin.jsp" method="POST">
            Username <input type="text" name="user" value="" /><br/>
            Password <input type="password" name="pass" value="" /><br/>
            <input type="submit" value="LogIn" name="btnAction" />
        </form>
    </body>
</html>
