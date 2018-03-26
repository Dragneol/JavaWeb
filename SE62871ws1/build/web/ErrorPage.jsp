<%-- 
    Document   : ErrorPage
    Created on : Mar 6, 2018, 11:38:03 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Errors Page</title>
    </head>
    <body>
        <font color="red">
        <c:set var="mess" value="${requestScope.ERRORS}"/>
        <c:if test="${empty mess}">
            <h1>There're something wrong happen</h1>
        </c:if>
        <c:if test="${not empty mess}">
            <h1>${mess}</h1>
        </c:if>
        </font><br/>
    </body>
</html>
