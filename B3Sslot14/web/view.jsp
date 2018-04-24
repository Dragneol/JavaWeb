<%-- 
Document   : view
Created on : Apr 24, 2018, 10:39:05 AM
Author     : DuongPTHSE62871
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
        <h1>Info Page</h1>
        <form action="MainController">
            <input type="hidden" name="searchField" value="${param.searchField}" />
            Username <input type="text" name="username" value="${requestScope.ACCOUNT.username}" readonly/><br/>
            Password <input type="password" name="password" value="" required/><br/>
            FullName <input type="text" name="fullname" value="${requestScope.ACCOUNT.fullname}" /><br/>
            Role <input type="text" name="role" value="${requestScope.ACCOUNT.role}" /><br/>
            <input type="submit" value="Update" name="action" />            
        </form>
        <c:url var="back" value="MainController">
            <c:param name="action" value="Search"/>
            <c:param name="searchField" value="${param.searchField}"/>
        </c:url>
        <a href="${pageScope.back}">Back To Search Page</a>
    </body>
</html>
