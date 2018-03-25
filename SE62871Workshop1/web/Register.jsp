<%-- 
    Document   : Register
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
            <jsp:forward page="MiddleServlet"/> 
        </c:if>
        
        <h1>Register</h1>
        <form action="MiddleServlet" method="POST">
            
            <c:set var="error" value="${requestScope.REGISTERERROR}"/>
            Username:<br/>
            <input type="text" name="txtUsername" value="${param.txtUsername}" /><br/>
            <c:if test="${not empty error.usernameIsEmpty}">
                <font color="red">${error.usernameIsEmpty}</font><br/>
            </c:if>
            <c:if test="${not empty error.usernameExisted}">
                <font color="red">${error.usernameExisted}</font><br/>
            </c:if>
            
            Password:<br/>
            <input type="password" name="txtPassword" value="" /><br/>
            <c:if test="${not empty error.passwordIsEmpty}">
                <font color="red">${error.passwordIsEmpty}</font><br/>
            </c:if>
            <c:if test="${not empty error.passwordMustBeNumber}">
                <font color="red">${error.passwordMustBeNumber}</font><br/>
            </c:if>
            
            Confirm password:<br/>
            <input type="password" name="txtConfirmPassword" value="" /><br/>
            <c:if test="${not empty error.passwordNotMatch}">
                <font color="red">${error.passwordNotMatch}</font><br/>
            </c:if>
            
            Full name:<br/>
            <input type="text" name="txtFullname" value="${param.txtFullname}" /><br/>
            <c:if test="${not empty error.fullnameIsEmpty}">
                <font color="red">${error.fullnameIsEmpty}</font><br/>
            </c:if>
                
            <input type="submit" value="Register" name="btnAction" /><br/>
            Already had an account? <a href="SignInPage.jsp">Sign In</a>
            
        </form>
    </body>
</html>
