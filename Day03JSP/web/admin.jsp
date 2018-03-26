<%-- 
    Document   : admin
    Created on : Dec 6, 2017, 12:04:18 PM
    Author     : Dragneol
--%>

<%@page import="dtos.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin!</h1>
        <h2>Search</h2>
        <form action="MainController" method="POST">
            Fullname : <input type="text" name="txtSearch" value="" /><br/>
            <input type="submit" value="Search" name="action"/>
        </form>

        <%
            List<UserDTO> result = (List<UserDTO>) request.getAttribute("INFO");
            if (result != null) {
        %>

        <h2>Search Result</h2>

        <%
            if (result.size() == 0) {
        %>
        No Record found        
        <%
        } //end if == 0
        else {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < result.size(); i++) {
                        UserDTO dto = result.get(i);
                %>
                <tr>
                    <td><%= i + 1%></td>
                    <td><%= dto.getUsername()%></td>
                    <td><%= dto.getFullname()%></td>
                    <td><%= dto.getRole()%></td>
                    <td>
                        <a href="MainController?action=Delete&txtUsername=<%= dto.getUsername()%>&txtSearch=<%= request.getParameter("txtSearch")%>">Delete</a>
                    </td>
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>" />
                            <input type="submit" name="action" value="Edit" />
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            } //end if != 0
        %>
        <%
            } //end if != null
%>
    </body>
</html>
