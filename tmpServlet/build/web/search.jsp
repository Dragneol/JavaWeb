<%-- 
    Document   : search
    Created on : Jan 30, 2018, 7:10:58 AM
    Author     : dragneol
--%>

<%@page import="java.util.List"%>
<%@page import="day07.registration.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <font color="red">
        <%--
        <%
            Cookie[] cookies = request.getCookies();
            String username = "";
            if (cookies == null) {
//                response.sendRedirect("login.html");
            } else {
                username = cookies[cookies.length - 1].getName();
//                if (username.equals("JSESSIONID")) {
//                    response.sendRedirect("login.html");
//                }
            }

        %>
        Welcome, <%= username%>        
        --%>
        Welcome, ${sessionScope.USER}
        </font>
        <div>Search</div>
        <form action="ControllerServlet" method="POST">
            <%
                String searchField = request.getParameter("txtSearch");
                if (searchField == null) {
                    searchField = "";
                }
            %>
            <input type="text" name="txtSearch" value="<%= searchField%>" /></br>
            <input type="reset" value="Reset" name="btnAction" />
            <input type="submit" value="Search" name="btnAction" />
        </form>
        </br>

        <c:set var="searchValue" value="${param.txtSearch}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>LastName</th>
                            <th>Password</th>
                            <th>Is Admin</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="ControllerServlet" method="POST">
                            <tr>
                                <td>
                                    ${counter.count}
                                    <input type="hidden" name="lastSeenValue" value="${searchValue}" />
                                </td>
                                <td>
                                    <input type="hidden" name="txtUsername" value="${dto.username}"/>
                                    ${dto.username}
                                </td>
                                <td>
                                    ${dto.lastname}
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="${dto.password}"/>
                                </td>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON" 
                                           <c:if test="${dto.isAdmin}">
                                               checked="checked "
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="ControllerServlet">
                                        <c:param name="btnAction" value="Delete"/>
                                        <c:param name="pk" value="${dto.username}"/>
                                        <c:param name="lastSeenValue" value="${searchValue}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>                       
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No record match</h2>
        </c:if>
    </c:if>
    <%--
        <%
            String searchValue = request.getParameter("txtSearch");

        if (searchValue != null) {
            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");

            if (result != null) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>Username</th>
                <th>Last name</th>
                <th>Password</th>
                <th>Is Admin</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <%
                int count = 0;
                for (RegistrationDTO dto : result) {
                    String urlRewriting = "ControllerServlet"
                            + "?btnAction=Delete"
                            + "&pk="
                            + dto.getUsername()
                            + "&lastSeenValue="
                            + searchValue;
            %>           
            <tr>
        <form action="ControllerServlet" method="GET">
            <td><%= ++count%></td>

            <!--
            <td><%= dto.getUsername()%></td>
            <td><%= dto.getLastname()%></td>
            <td><%= dto.getPassword()%></td>
            <td><%= dto.isIsAdmin()%></td>
            --!>

            <td>
                <%= dto.getUsername()%>
                <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>"/>
            </td>

            <td><%= dto.getLastname()%></td>
            <td><input type="text" name="txtPassword" value="<%= dto.getPassword()%>"/></td>

            <td>
                <input type="checkbox" name="chkAdmin" value="ON" 
                       <% if (dto.isIsAdmin())%>
                       checked = "checked"/>
            </td>

            <td>
                <a href="<%= urlRewriting%>">Delete</a>
            </td>

            <td>
                <input type="submit" value="Update" name="btnAction" />
                <input type="hidden" value="<%= searchValue%>" name="lastSeenValue" />
            </td>
        </form>
    </tr>
    <%
        } //end for
    %>
</tbody>
</table>

<%
} else {
%>
<h2>No record is matched!</h2>
<%
        }
    } //end if searchValue null
%>
    --%>
</body>
</html>
