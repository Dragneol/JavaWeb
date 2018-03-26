<%-- 
    Document   : UserPage
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
            
            <h1>User page</h1>
            
            <form action="MiddleServlet">
                <c:set var="error" value="${requestScope.SEARCHERROR}"/>
                Price from <input type="text" name="txtSearchMinPrice" value="${param.txtSearchMinPrice}" min="0"/>
                to <input type="text" name="txtSearchMaxPrice" value="${param.txtSearchMaxPrice}" min="0"/>
                <c:if test="${not empty error.invalidMinPrice}">
                    <font color="red">${error.invalidMinPrice}</font><br/>
                </c:if>
                <c:if test="${not empty error.invalidMaxPrice}">
                    <font color="red">${error.invalidMaxPrice}</font><br/>
                </c:if>
                <input type="hidden" name="txtSearchType" value="PriceInRange" />
                <input type="submit" value="Search" name="btnAction" />
            </form><br/>
            
            <c:url var="urlRewriting" value="MiddleServlet">
                <c:param name="btnAction" value="View cart"/>
            </c:url>
            <a href="${urlRewriting}">View your cart</a>
            
            <c:set var="mobiles" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty mobiles}">
                <table border="solid 1px">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Year of production</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mobileItem" items="${mobiles}">
                            <tr>
                            <form action="MiddleServlet">
                                <input type="hidden" name="txtMobileID" value="${mobileItem.mobileID}" />
                                <td>${mobileItem.mobileName}</td>
                                <td>${mobileItem.description}</td>
                                <td>${mobileItem.yearOfProduction}</td>
                                <td>${mobileItem.price}</td>
                                
                                <c:if test="${mobileItem.notSale}">
                                    <td colspan="2">Not Available</td>
                                </c:if>
                                <c:if test="${not mobileItem.notSale}">
                                    <td>
                                        <input type="number" name="txtMobileQuantity" value="" />
                                    </td>
                                    <td><input type="submit" value="Add to cart" name="btnAction" /></td>
                                </c:if>
                                
                                <input type="hidden" value="${param.txtSearchMinPrice}" name="txtLastMinPrice" />
                                <input type="hidden" value="${param.txtSearchMaxPrice}" name="txtLastMaxPrice" />
                            </form>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <c:set var="error" value="${requestScope.ADDCARTERROR}"/>
                <c:if test="${not empty error.invalidQuantity}">
                    <font color="red">${error.invalidQuantity}</font><br/>
                </c:if>

            </c:if>
            <c:if test="${empty mobiles && not empty param.txtSearchType}">
                <h3>No record is matched!</h3>
            </c:if>
        </c:if>
    </body>
</html>
