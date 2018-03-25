<%-- 
    Document   : Cart
    Created on : March 24, 2018, 2:17:12 PM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Shop</title>
    </head>
    <body>
        <font color="red">Welcome, <s:property value="%{#session.USER.fullname}"/>.</font>
        <a href="logout">Log out</a>
            
        <h1>Your cart</h1>
        <s:if test="%{cart != null}">
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
                    <s:iterator var="item" value="cart">
                        <tr>
                            <s:form action="updateCart" theme="simple">
                                <s:hidden name="mobileID" value="%{#item.mobileID}"/>
                                <td><s:property value="%{#item.mobileName}"/></td>
                                <td><s:property value="%{#item.price}"/></td>
                                <td><s:textfield name="quantity" value="%{#item.quantity}" type="number"/></td>
                                <td><s:property value="%{#item.price * #item.quantity}"/></td>
                                <td><s:property value="%{#item.status}"/></td>
                                <td>
                                    <s:url var="Delete" action="deleteFromCart">
                                        <s:param name="mobileID" value="%{#item.mobileID}"/>
                                    </s:url>
                                    <s:a href="%{Delete}">Remove</s:a>
                                </td>
                                <td>
                                    <input type="submit" value="Update cart" name="btnAction" />
                                </td>
                            </s:form>
                        </tr>
                    </s:iterator>
                    <tr>
                        <td colspan="3">
                        </td>
                        <td colspan="4"><s:property value="total"/></td>
                    </tr>
                </tbody>
            </table>
        </s:if>

        <s:if test="%{cart == null}">
            <h3>Opps, it seems that you haven't chosen any mobiles!</h3>
        </s:if>

        <a href="UserPage.jsp">Continue to go shopping</a>

    </body>
</html>
