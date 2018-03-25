<%-- 
    Document   : index
    Created on : Mar 9, 2018, 10:57:01 PM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Shop</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:if test="${not empty user}">
            <c:redirect url="MiddleServlet"/> 
        </c:if>

        <h1>Sign In to access system!</h1>
        <form action="MiddleServlet" method="POST">

            Username:<input type="text" name="txtUsername" value="" /><br/>
            Password:<input type="password" name="txtPassword" value="" /><br/>

            <c:set var="err" value="${requestScope.SIGNINERROR}" />
            <c:if test="${not empty err}">
                <font color="red">
                ${err.loginFailed}
                ${err.passwordMustBeNumber}
                </font><br/>
            </c:if>

            <input type="submit" value="Sign In" name="btnAction" /><br/>
            Or haven't had account yet? <a href="Register.jsp">Registration here</a>

        </form>
    </body>
</html>
