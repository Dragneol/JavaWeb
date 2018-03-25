<%-- 
    Document   : staffPage
    Created on : Mar 9, 2018, 10:37:56 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Page</title>
    </head>
    <body>
        <c:set var="staff" value="${sessionScope.ACCOUNT}"/>
        <c:if test="${empty staff or staff.role ne 2}">
            <h1>Access Denied!!!</h1>
        </c:if>
        <c:if test="${not empty staff and staff.role eq 2}">
            <h1>Hello ${staff.fullName}!</h1>
            <h1>Welcome to staff Page!</h1><br/>
            <form action="Search.id">
                mobileId <input type="text" name="mobileId" value="" /><br/>
                <input type="submit" value="SearchId" name="btnAction" />
            </form>
            <form action="Search.name">
                mobileName <input type="text" name="mobileId" value="" /><br/>
                <input type="submit" value="SearchName" name="btnAction" />
            </form>
        </c:if>
        <a href="Try">Return to Login Page</a>
    </body>
</html>
