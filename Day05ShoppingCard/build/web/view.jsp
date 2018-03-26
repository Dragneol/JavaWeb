<%-- 
    Document   : view
    Created on : Dec 8, 2017, 11:28:35 AM
    Author     : Dragneol
--%>

<%@page import="dtos.BookDTO"%>
<%@page import="dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CartDTO shoppingCart = (CartDTO) session.getAttribute("cart");
        %>
        <h1><%= shoppingCart.getCustomerName()%>'s shopping cart</h1>
        <form action="MainController" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>BookName</th>
                        <th>BookPrice</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (BookDTO dto : shoppingCart.getCart().values()) {
                            count++;
                    %>
                    <tr>
                        <td><%= count%></td>
                        <td><%= dto.getBookName()%></td>
                        <td><%= dto.getPrice()%></td>
                        <td><input type="text" name="txtQuantity" value="<%= dto.getQuantity()%>"></td>
                        <!--<input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>">-->
                        <td><input type="checkbox" name="txtBookID" value="<%= dto.getBookID()%>"></td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td>Total : </td>
                        <td><%= shoppingCart.total()%></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="action" value="Remove">
            <input type="submit" name="action" value="Update">
        </form>
    </body>
</html>
