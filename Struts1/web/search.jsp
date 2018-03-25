<%-- 
    Document   : search
    Created on : Mar 6, 2018, 9:40:19 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Welcome , ${sessionScope.LoginStrutsActionForm.username}</h1>
        <form action="searchLastName.do" method="POST">
            Search Value <input type="text" name="searchValue" value="" /><br/>
            <input type="submit" value="Search" />
        </form>
    </body>
    <br/>
    <c:set var="searchValue" value="${param.searchValue}"/>
    <c:if test="${not empty searchValue}">
        <c:set var="result" value="${requestScope.SearchLastNameStrutsActionForm.listAccount}"/>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>LastName</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${result}" varStatus="counter">
                    <tr>
                        <td>${dto.getUsername}</td>
                        <td>${dto.getPassword}</td>
                        <td>${dto.getLastName}</td>
                        <td>
                            <c:url var="deletePk" value="deleteRecord.do">
                                <c:param name="pk" value="${dto.username}"/>
                                <c:param name="searchValue" value="searchValue"/>
                            </c:url>
                            <a href="${deletePk}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
</html>
