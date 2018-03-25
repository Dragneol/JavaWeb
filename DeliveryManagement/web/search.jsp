<%-- 
    Document   : search
    Created on : Mar 11, 2018, 3:05:31 PM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delivery Management</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.ACCOUNT.custName}!</h1>
        <h2>Search Order</h2>
        <form action="SearchOrder" method="POST">
            From Date <input type="date" name="dateFrom" required  value="${param.dateFrom}"/>
            <br/>
            To Date <input type="date" name="dateTo" required value="${param.dateTo}"/>
            <br/>
            <input type="checkbox" name="isDeliver" >Delivered<br/>
            <input type="submit" value="Search" name="btnAction"/>
            <input type="reset" value="Reset" name="btnAction"/>
        </form>
        <a href="Logout"><h6>Log Out</h6></a>
    </body>
</html>
