<%-- 
    Document   : LogIn
    Created on : Mar 9, 2018, 9:57:59 PM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn</title>
    </head>
    <body>
    <c:set var="user" value="${sessionScope.USER}"/>
<!--    <c:if test="${not empty user}">
        <%--<jsp:forward page="ServletController"/>--%> 
    </c:if>-->

    <h1>Please Log In to continue!</h1>
    <form action="ServletController" method="POST">

        Username:<input type="text" name="useId" value="" /><br/>
        Password:<input type="password" name="password" value="" /><br/>

        <c:set var="err" value="${requestScope.SIGNINERROR}" />
        <c:if test="${not empty err}">
            <font color="red">${err.invalidUsernameOrPassword}</font><br/>
        </c:if>

        <input type="submit" value="LogIn" name="btnAction" /><br/>
        Or haven't had account yet? <a href="Register.jsp">Create new account!</a>
    </body>
</html>
