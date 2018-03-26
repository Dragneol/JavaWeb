<%-- 
    Document   : Cart
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
        <c:if test="${empty user or user.role ne 0}">
            <h1>Access Denied!!!</h1>
        </c:if>
            
        <c:if test="${not empty user and user.role eq 0}">
            
            <font color="red">Welcome, ${user.fullname}.</font>
            <c:url var="logoutUrlRewriting" value="MiddleServlet">
                <c:param name="btnAction" value="Log out"/>
            </c:url>
            <a href="${logoutUrlRewriting}">Log out</a>
            
            <h1>Your cart</h1>
            <c:set var="cartLists" value="${requestScope.CART}"/>
            <c:if test="${not empty cartLists}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="total" value="${0}"/>
                        <c:forEach var="item" items="${cartLists}">
                            <tr>
                                <form action="MiddleServlet">
                                    <input type="hidden" name="txtMobileID" value="${item.mobileID}" />
                                    <td>${item.mobileName}</td>
                                    <td>${item.price}</td>
                                    <td><input type="number" name="txtQuantity" value="${item.quantity}" /></td>
                                    <td>${item.price * item.quantity}</td>
                                    <td>${item.status}</td>
                                    <td>
                                        <c:url var="Delete" value="MiddleServlet">
                                            <c:param name="btnAction" value="DeleteFromCart"/>
                                            <c:param name="mobileID" value="${item.mobileID}"/>
                                        </c:url>
                                        <a href="${Delete}">Remove</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update cart" name="btnAction" />
                                    </td>
                                </form>
                            </tr>
                            <c:set var="total" value="${total + item.price * item.quantity}"/>
                        </c:forEach>
                        <tr>
                            <td colspan="3">
                                <c:set var="error" value="${requestScope.UPDATECARTERROR}"/>
                                <c:if test="${not empty error.invalidQuantity}">
                                    <font color="red">${error.invalidQuantity}</font>
                                </c:if>
                            </td>
                            <td colspan="4">${total}</td>
                        </tr>
                    </tbody>
                </table>

            </c:if>
            
            <c:if test="${empty cartLists}">
                <h3>Opps, it seems that you haven't chosen any mobiles!</h3>
            </c:if>
            
            <a href="UserPage.jsp">Continue to go shopping</a>
            
        </c:if>
    </body>
</html>
