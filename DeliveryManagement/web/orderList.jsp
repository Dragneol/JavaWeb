<%-- 
    Document   : orderList
    Created on : Mar 15, 2018, 8:19:42 AM
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
        <h1>Hello ${sessionScope.ACCOUNT.custName}</h1>
        <c:set var="deliver" value="${param.isDeliver}"/>

        <%--
        <c:choose>
            <c:when test="${not empty param.isDeliver}">
                <c:set var="isDeliver" value="Delivered"/>
            </c:when>
            <c:otherwise>
                <c:set var="isDeliver" value="Undelivered"/>
            </c:otherwise>
        </c:choose>
        --%>

        <c:choose>
            <c:when test="${not empty param.isDeliver}">

                <c:if test="${param.isDeliver ne 'Undelivered'}">
                    <c:set var="isDeliver" value="Delivered"/>
                </c:if>
                <c:if test="${param.isDeliver eq 'Undelivered'}">
                    <c:set var="isDeliver" value="Undelivered"/>
                </c:if>

            </c:when>
            <c:otherwise>
                <c:set var="isDeliver" value="Undelivered"/>
            </c:otherwise>
        </c:choose>
        <!--<p>This is ${isDeliver} site</p>-->
        <c:set var="from" value="${param.dateFrom}"/>
        <c:set var="to" value="${param.dateTo}"/>
        <c:set var="list" value="${requestScope.ORDERLIST}"/>

        <table>
            <thead>
                <tr>Order List</tr>
            </thead>
            <tbody>
                <tr>
                    <td>From    : ${from}</td>
                    <td>To      : ${to}</td>
                </tr>
            </tbody>
        </table>
        <c:if test="${list!=null}">
            <form action="ChangeStatus" method="POST">

                <input type="hidden" name="dateFrom" value="${from}"/>
                <input type="hidden" name="dateTo" value="${to}"/>
                <input type="hidden" name="isDeliver" value="${isDeliver}"/>

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Customer</th>
                            <th>Action</th>
                            <th>Reason</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${list}" varStatus="counter">
                            <tr>
                                <th>${counter.count}</th>
                                <th>${order.orderDate}</th>
                                <th>${order.total}</th>
                                <th>${order.custID}</th>
                                <th>
                                    <input type="checkbox" name="orders" value="${order.orderID}" />
                                </th>
                                <th>${order.reason}</th>
                                <th>
                                    <c:url var="OrderDetail" value="OrderDetail">
                                        <c:param name="orderID" value="${order.orderID}"/> 
                                        <c:param name="custID" value="${order.custID}"/> 
                                        <c:param name="orderDate" value="${order.orderDate}"/> 
                                        <c:param name="isDeliver" value="${isDeliver}"/>
                                        <c:param name="dateFrom" value="${from}"/>
                                        <c:param name="dateTo" value="${to}"/>
                                    </c:url>
                                    <a href="${OrderDetail}">View</a>
                                </th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type="submit" name="btnAction" 
                       <c:choose>
                           <c:when test="${isDeliver eq 'Undelivered'}">
                               value="Delivered"
                           </c:when>
                           <c:otherwise>
                               value="Undelivered"
                           </c:otherwise>
                       </c:choose>
                       />
            </form>
        </c:if>
        <c:if test="${list==null}">
            <h2>No Order in these time</h2>
        </c:if>

        <c:url var="Search" value="search.jsp">
            <c:param name="isDeliver" value="${deliver}"/>
            <c:param name="dateFrom" value="${from}"/>
            <c:param name="dateTo" value="${to}"/>
        </c:url>

        <h6>Back to <a href="${Search}">Search</a> Page</h6>
        <a href="Logout"><h6>Log Out</h6></a>
    </body>
</html>
