<%-- 
    Document   : index
    Created on : Dec 11, 2017, 3:18:31 PM
    Author     : Dragneol
--%>
<%@taglib prefix="duongpth" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="MainController" method="POST">
            Username <input type="text" name="txtUsername" value="" /><br/>
            <duongpth:if test = "${not empty requestScope.INVALID}">
                <font>
                ${requestScope.INVALID.usernameError}
                </font>
            </duongpth:if>
            Password <input type="password" name="" value="" /><br/>
            <duongpth:if test = "${not empty requestScope.INVALID}">
                <font>
                ${requestScope.INVALID.passwordError}
                </font>
            </duongpth:if>
            <input type="submit" value="Login" name="action"/>
        </form>
    </body>
</html>
