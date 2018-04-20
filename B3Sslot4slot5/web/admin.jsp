<%-- 
    Document   : admin
    Created on : Apr 17, 2018, 11:37:25 AM
    Author     : DuongPTHSE62871
--%>

<%@page import="duongpth.objects.RegistrationDTO"%>
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
        <h2>Search User</h2>
        <form action="MainController" method="POST">
            FullName : <input type="text" name="searchField" 
                              <% if (request.getParameter("searchField") != null) { %> 
                              value="<%= request.getParameter("searchField") %>" 
                              <% } %> />
            <input type="submit" value="Search" name="btnAction" />
        </form>

        <%
            List<RegistrationDTO> result = (List<RegistrationDTO>) (request.getAttribute("SEARCH_RESULT"));
            if (result == null) {
            } else if (result.size() == 0) {
        %>
        <h2>No record match</h2>
        <%
        } else {
        %>
        <h2>Result</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < result.size(); i++) {
                        RegistrationDTO dto = result.get(i);
                %>
                <tr>
                    <td><%= i + 1%></td>
                    <td><%= dto.getUsername()%></td>
                    <td><%= dto.getFullname()%></td>
                    <td><%= dto.getRole()%></td>
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="pk" value="<%= dto.getUsername()%>" />
                            <input type="hidden" name="searchField" value="<%= request.getParameter("searchField")%>" />
                            <input type="submit" value="View" name="btnAction" />
                        </form>
                    </td>
                    <td>
                        <a href="MainController?btnAction=Delete&username=<%= dto.getUsername()%>&searchField=<%= request.getParameter("searchField")%>">Delete</a>
                    </td>
                </tr>
                <%                    }
                %>
            </tbody>
        </table>
        <% }
        %>

        <%--
        <c:set var="grid" value="${requestScope.SEARCH_RESULT}"/>
        <c:choose>
            <c:when test="${not empty grid}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${grid}" varStatus="counter">
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </c:when>
        </c:choose>
        --%>
    </body>
</html>
