<%-- 
    Document   : Cart
    Created on : Mar 9, 2018, 8:05:42 PM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Cart</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.ACCOUNT}"/>
        <c:if test="${empty user or user.role ne 0}"> // login not success or this not a user
            <h1>Access Denied!!!</h1>
        </c:if>

        <c:if test="${not empty user and user.role eq 0}">
            <h1>Welcome, ${user.fullName}</h1>
            
        </c:if>
    </body>
</html>
