<%-- 
    Document   : search
    Created on : Feb 27, 2018, 9:21:47 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search.jsp">
            Search value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}"/><br/>
            <input type="submit" value="Search"/>
        </form><br/>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <sql:setDataSource dataSource="SE1264MVC2" var="con"/>            
            <c:if test="${not empty con}">
                <sql:query var="rs" dataSource="${con}">
                    Select Username as 'Ten nguoi dung', Password as 'mat khau' , Lastname as 'Ten', isAdmin as 'Admin'
                    From Registration
                    Where Username like ?
                    <sql:param value="%${searchValue}%"/>
                </sql:query>
                <c:if test="${rs.rowCount gt 0}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                    <c:forEach var="colName" items="${rs.columnNames}">
                                    <th>${colName}</th>
                                    </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="row" items="${rs.rowsByIndex}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <c:forEach var="col" items="${row}">
                                        <td>${col}</td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </c:if>
        </c:if>

        <h2>Tag File Demo</h2>
        <my:dataGrid
            dataSource="SE1264MVC2" 
            sqlStm=""
            searchValue="%a%"
            />
    </body>
</html>
