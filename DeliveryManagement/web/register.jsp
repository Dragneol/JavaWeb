<%-- 
    Document   : Register
    Created on : Mar 11, 2018, 12:31:10 PM
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
        <h1>Register Site</h1>
        <form action="Register" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Field</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td>Username</td><td><input type="text" name="custID" value="${param.custID}" maxlength="10" required /></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" value="" maxlength="30" required/></td></tr>
                    <tr><td>Confirm Password</td><td><input type="password" name="passwordConfrimed" value="" maxlength="30" required/></td></tr>
                    <tr><td>Customer Name</td><td><input type="text" name="custName" value="${param.custName}" maxlength="15" required/></td></tr>
                    <tr><td>Last Name</td><td><input type="text" name="lastName" value="${param.lastName}" maxlength="15"/></td></tr>
                    <tr><td>Middle Name</td><td><input type="text" name="middleName" value="${param.middleName}" maxlength="15"/></td></tr>
                    <tr><td>Address</td><td><input type="text" name="address" value="${param.address}" maxlength="250"/></td></tr>
                    <tr><td>Phone</td><td><input type="text" name="phone" value="${param.phone}" maxlength="11"/></td></tr>
                </tbody>
            </table>
            <c:if test="${not empty requestScope.ERROR}">
                <font color="red">
                ${requestScope.ERROR}
                </font><br/>
            </c:if>
            <input type="submit" value="Register" name="btnAction"/>
        </form>
        <p>Click <a href="/DeliveryManagement">here</a> to Login!!!</p>
    </body>
</html>
