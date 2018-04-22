<%-- 
    Document   : view
    Created on : Apr 21, 2018, 9:52:22 AM
    Author     : DuongPTHSE62871
--%>

<%@page import="duongpth.dtos.PhoneDTO"%>
<%@page import="duongpth.dtos.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <%
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart != null) {
        %>
        <h1><%= cart.getCustName()%>'s Shopping Cart</h1>
        <form action="MainController" method="POST">        
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Phone Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (PhoneDTO dto : cart.getCart().values()) {
                            count++;
                    %>
                    <tr>
                        <td><%= count%></td>
                        <td><%= dto.getPhoneName()%></td>
                        <td>
                            <input type="hidden" name="phone" value="<%= dto.getPhoneId()%>" />
                            <input type="number" name="quantity" value="<%= dto.getQuantity()%>" />
                        </td>
                        <td><%= dto.getPrice() * dto.getQuantity()%></td>
                        <td><input type="checkbox" name="interactedPhone" value="<%= dto.getPhoneId()%>"/></td>
                    </tr>
                    <% }%>
                    <tr>
                        <td colspan="3">Total</td>
                        <td colspan="5"><%= cart.getTotal()%></td>
                    </tr>
                </tbody>
            </table>                    
            <input type="submit" value="ContinueShopping" name="action"/>
            <input type="submit" value="Remove" name="action"/>
            <input type="submit" value="Update" name="action"/>
        </form>
        <%
        } else {
        %>
        <h2>You haven't shopping yet</h2>
        <%
            }
        %>
    </body>
</html>
