<%-- 
    Document   : StaffPage
    Created on : March 24, 2018, 12:19:19 PM
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

        <h1>Staff page</h1>
        <s:form action="searchIDorName">
            <s:textfield name="searchValue"/>
            <s:submit value="Search"/>
        </s:form>

        <s:if test="%{searchValue != null and searchValue != ''}">
            <s:if test="%{listMobiles != null}">
                <table border="solid 1px">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Year of production</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Not sale</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="mobileItem" value="listMobiles">
                            <tr>
                                <s:form action="updatedelete" theme="simple">
                                    <td>
                                        <s:property value="%{#mobileItem.mobileID}"/>
                                        <s:hidden name="mobileID" value="%{#mobileItem.mobileID}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{#mobileItem.mobileName}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="description" value="%{#mobileItem.description}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{#mobileItem.yearOfProduction}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="quantity" value="%{#mobileItem.quantity}" type="number"/>
                                    </td>
                                    <td>
                                        <s:textfield name="price" value="%{#mobileItem.price}"/>
                                    </td>
                                    <td>
                                        <s:checkbox name="notSale" value="%{#mobileItem.notSale}"/>
                                    </td>
                                    <td><s:submit name="update" value="Update"/></td>
                                    <td><s:submit name="delete" value="Delete"/></td>
                                    <s:hidden name="searchValue" value="%{searchValue}"/>
                                </s:form>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            
            <s:if test="%{listMobiles == null}">
                <h3>No record is matched!!!</h3>
            </s:if>
        </s:if>

        <s:form action="add" method="POST">
            <h2>Insert new mobile</h2>
            <s:textfield name="mobileID" label="ID"/>
            <s:textfield name="name" label="Name"/>
            <s:textfield name="description" label="Description"/>
            <s:textfield name="price" label="Price"/>
            <s:textfield name="yearOfProduction" label="Year of production" type="number"/>
            <s:textfield name="quantity" label="Quantity" type="number"/>
            <s:checkbox name="notSale" label="is not sale"/>
            <s:submit value="Insert"/>
            <s:if test="%{exception.message.contains('duplicate')}">
                <font color="red">
                <s:property value="mobileID"/> is existed!
                </font>
            </s:if>
        </s:form>
    </body>
</html>