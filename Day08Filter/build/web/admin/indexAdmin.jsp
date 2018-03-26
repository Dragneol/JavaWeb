<%-- 
    Document   : indexAdmin
    Created on : Dec 13, 2017, 10:41:20 AM
    Author     : Dragneol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE ne 'admin'}">
            <jsp:forward page="/login.jsp"/>
        </c:if>
        <h1>Hello ${sessionScope.USERLOGIN}!</h1>
        <a href="DeleteController?txtUsername=admin">Delete</a>
    </body>
</html>
