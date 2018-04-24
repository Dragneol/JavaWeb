<%-- 
    Document   : admin
    Created on : Apr 24, 2018, 9:09:52 AM
    Author     : DuongPTHSE62871
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin ${sessionScope.AUTHORIZED}!</h1>
        <form action="MainController">
            FullName <input type="text" name="searchField" value="${param.searchField}" />
            <input type="submit" value="Search" name="action" />
        </form>   
        <c:set value="${requestScope.INFO}" var="list"/>
        <c:if test="${pageScope.list != null}">
            <c:if test="${not empty pageScope.list}"  var="existedRecords">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>FullName</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${pageScope.list}" varStatus="counter">
                            <tr>
                                <td>${pageScope.counter.count}</td>
                                <td>${pageScope.dto.username}</td>
                                <td>${pageScope.dto.fullname}</td>
                                <td>${pageScope.dto.role}</td>
                                <td>
                                    <c:url var="delThis" value="MainController">
                                        <c:param name="action" value="Delete"/>
                                        <c:param name="pk" value="${pageScope.dto.username}"/>
                                        <c:param name="searchField" value="${param.searchField}"/>
                                    </c:url>
                                    <a href="${pageScope.delThis}">Delete</a>
                                </td>
                                <td>
                                    <c:url var="viewThis" value="MainController">
                                        <c:param name="action" value="View"/>
                                        <c:param name="pk" value="${pageScope.dto.username}"/>
                                        <c:param name="searchField" value="${param.searchField}"/>
                                    </c:url>
                                    <a href="${pageScope.viewThis}">View</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${not pageScope.existedRecords}" >
                <h2>No records found</h2>
            </c:if>
        </c:if>
    </body>
</html>
