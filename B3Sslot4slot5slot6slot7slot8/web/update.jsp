<%-- 
    Document   : update
    Created on : Apr 19, 2018, 9:48:59 AM
    Author     : DuongPTHSE62871
--%>

<%@page import="duongpth.objects.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Information</h1>
        <%
            RegistrationDTO dto = (RegistrationDTO) request.getAttribute("USER");
        %>
        <form action="MainController" method="POST">
            Username : <input type="text" name="username" value="<%=dto.getUsername()%>" readonly/><br/>
            Fullname : <input type="text" name="fullname" value="<%=dto.getFullname()%>"/><br/>
            Password : <input type="text" name="password" value="<%=dto.getPassword()%>"/><br/>
            Role:
            <select name="role">
                <option <% if (dto.getRole().equals("user")) { %>selected="true"<% } %>>user</option>
                <option <% if (dto.getRole().equals("admin")) { %>selected="true"<% }%>>admin</option>
            </select><br/>
            <input type="hidden" name="searchField" value="<%= request.getParameter("searchField")%>" />
            <input type="submit" value="Update" name="btnAction" />
        </form>
    </body>
</html>
