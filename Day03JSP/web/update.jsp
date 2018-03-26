<%-- 
    Document   : update
    Created on : Dec 7, 2017, 11:04:11 AM
    Author     : Dragneol
--%>

<%@page import="dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <%
            UserDTO dto = (UserDTO) request.getAttribute("dto");
        %>
        <form action="MainController" method="POST">
            Username <input type="text" name="txtUsername" value="<%= dto.getUsername()%>" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            Fullname <input type="text" name="txtFullname" value="<%= dto.getFullname()%>" /><br/>
            Role <input type="text" name="txtRole" value="<%= dto.getRole()%>" /><br/>
            <input type="submit" value="Update" name="action" />
        </form>
    </body>

</html>
