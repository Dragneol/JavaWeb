<%-- 
    Document   : index
    Created on : Apr 21, 2018, 9:14:15 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Phone Shop</h1>
        <form action="MainController">
            Please chooose your phone:
            <select name="phone">
                <option value="I7-Iphone7-500">Iphone 7</option>
                <option value="I8-Iphone8-600">Iphone 8</option>
                <option value="I9-Iphone9-700">Iphone 9</option>
                <option value="IX-IphoneX-800">Iphone X</option>
                <option value="S7-Samsung S7-200">Samsung Galaxy S7</option>
                <option value="S8-Samsung S8-300">Samsung Galaxy S8</option>
                <option value="S9-Samsung S9-400">Samsung Galaxy S9</option>
            </select>
            <input type="submit" value="AddToCart" name="action" />
        </form>
        <a href="view.jsp">View Cart</a>
    </body>
</html>
