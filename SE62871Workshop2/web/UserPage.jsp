<%-- 
    Document   : UserPage
    Created on : March 24, 2018, 12:18:54 PM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Shop</title>
        <s:head/>
    </head>
    <body>
        <font color="red">Welcome, <s:property value="%{#session.USER.fullname}"/>.</font>
        <a href="logout">Log out</a>
            
        <h1>User page</h1>
        <s:form action="searchPrice">
            <s:textfield name="minPrice" label="Price from"/>
            <s:textfield name="maxPrice" label="To"/>
            <s:submit value="Search"/>
        </s:form>

        <a href="cart">View your cart</a>

        <s:if test="%{listMobiles != null}">
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
                    <s:iterator var="mobileItem" value="listMobiles">
                        <tr>
                        <s:form action="addToCart" theme="simple">
                            <s:hidden name="mobileID" value="%{#mobileItem.mobileID}"/>
                            <td><s:property value="%{#mobileItem.mobileName}"/></td>
                            <td><s:property value="%{#mobileItem.description}"/></td>
                            <td><s:property value="%{#mobileItem.yearOfProduction}"/></td>
                            <td><s:property value="%{#mobileItem.price}"/></td>
                            <s:if test="%{#mobileItem.notSale}">
                                <td colspan="2">Not Available</td>
                            </s:if>
                            <s:if test="%{#mobileItem.notSale != true}">
                                <td>
                                    <s:textfield name="quantity" value="1" type="number"/>
                                </td>
                                <td><s:submit value="Add to cart"/></td>
                            </s:if>
                            <s:hidden name="minPrice" value="%{minPrice}"/>
                            <s:hidden name="maxPrice" value="%{maxPrice}"/>
                        </s:form>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
    </body>
</html>
