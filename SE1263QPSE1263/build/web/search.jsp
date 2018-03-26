<%-- 
    Document   : search.jsp
    Created on : Mar 20, 2018, 7:27:34 AM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <%--<h1>Hello <s:property value="%{#session.ACCOUNT"/>!</h1>--%>
        <h1>Hello ${sessionScope.ACCOUNT}!</h1>
        <a href="logout">Logout</a>
        <s:form action="search">
            <s:textfield name="searchValue" value=""/>
            <s:submit value="Search"/>
            <s:reset value="Reset"/>
        </s:form>
        
        <table border="1">
            <thead>
                <tr>
                    <th>BookId</th>
                    <th>BookTitle</th>
                    <th>Description</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator var="%{LISTSEARCH}">
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

    </body>
</html>
