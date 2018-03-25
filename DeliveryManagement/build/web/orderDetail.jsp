<%-- 
    Document   : orderDetail
    Created on : Mar 15, 2018, 10:05:42 AM
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
        <c:set var="deliver" value="${param.isDeliver}"/>
        <c:set var="from" value="${param.dateFrom}"/>
        <c:set var="to" value="${param.dateTo}"/>
        <c:set var="total" value="${0}"/>
        <c:set var="list" value="${requestScope.DETAILLIST}"/>
        <c:set var="cust" value="${requestScope.DETAILCUST}"/>

        <h1>Hello ${sessionScope.ACCOUNT.custName}</h1>
        <h2>Order Detail</h2>
        <c:choose>
            <c:when test="${not empty list}">
                <table>
                    <tbody>
                        <tr>
                            <td>OrderID : ${param.orderID}</td>
                            <td>Date : ${param.orderDate}</td>
                        </tr>

                        <tr>
                            <td>Customer : ${cust.custName}</td>
                            <td>Phone : ${cust.phone}</td>
                        </tr>
                        <tr>
                            <td colspan="2">Address : ${cust.address}</td>
                        </tr>
                    </tbody>
                </table>
                <h2>Detail</h2>
                <table border="1">
                    <thead>
                        <tr>
                            <td>No.</td>
                            <td>Product</td>
                            <td>Quantity</td>
                            <td>Price</td>
                            <td>Total</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" varStatus="counter" var="order">
                            <tr>
                                <td>${counter.count}.</td>
                                <td>${order.productID}</td>
                                <td>${order.quantity}</td>
                                <td>${order.unitPrice}</td>
                                <td>${order.total}</td>
                                <c:set var="total" value="${total + order.total}"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p>Total : ${total}</p>
            </c:when>
            <c:otherwise>
                <h2>System have no Information about this order</h2>
            </c:otherwise>
        </c:choose>

        <c:url var="OrderList" value="SearchOrder">
            <c:param name="isDeliver" value="${deliver}"/>
            <c:param name="dateFrom" value="${from}"/>
            <c:param name="dateTo" value="${to}"/>
        </c:url>

        <h6>Back to <a href="${OrderList}">Order List</a> Page</h6>
        <a href="Logout"><h6>Log Out</h6></a>
    </body>
</html>
