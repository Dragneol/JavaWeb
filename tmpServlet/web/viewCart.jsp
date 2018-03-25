<%-- 
    Document   : viewCart
    Created on : Feb 6, 2018, 7:08:54 AM
    Author     : dragneol
--%>

<%@page import="java.util.Map"%>
<%@page import="day10.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <h1>Your cart includes</h1>
        <%
            //1. Den cho lay gio hang
            if (session != null) {
                //2.Lay gio hang
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    //3.lay hang trong gio
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
        %>
        <table border="1">
            <form action="ControllerServlet">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (Map.Entry item : items.entrySet()) {
                    %>
                    <tr>
                        <td><%= ++count%></td>
                        <td><%= item.getKey()%></td>
                        <td><%= item.getValue()%></td>
                        <td>
                            <input type="checkbox" name="chkItem" value="<%=item.getKey()%>"/>
                        </td>
                    </tr>                                        
                    <%
                        }//end for
                    %>
                    <tr>
                        <td colspan="3">
                            <a href="shoppingOnline.html">Add More Book To Your Cart</a>
                        </td>
                        <td>
                            <input type="submit" value="RemoveSelected" name="btnAction" />
                        </td>
                    </tr>
                </tbody>


            </form>
        </table>


        <%
            }
        } else {
        %>
        <h2>Cart not exist</h2>
        <%
                }
            }
        %>
    </body>
</html>
