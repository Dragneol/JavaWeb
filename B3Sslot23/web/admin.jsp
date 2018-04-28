<%-- 
    Document   : admin
    Created on : Apr 28, 2018, 8:41:28 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin <s:property value="%{#session.AUTHORIZED}"/> !</h1>
        <h2>Search</h2>
        <s:form action="search" method="POST">
            <s:textfield label="Fullname" name="searchFiled"/>
            <s:submit value="Search"/>
        </s:form>

        <s:if test="%{list != null}">
            <h2>Result</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="list" status="counter">
                        <tr>
                            <td><s:property value="%{#counter.count}"/></td>
                            <td><s:property value="username"/></td>
                            <td><s:property value="fullname"/></td>
                            <td><s:property value="role"/></td>
                            <td>
                                <s:url action="delete" id="deleteLink">
                                    <s:param name="searchField" value="%{searchField}"/>
                                    <s:param name="id" value="%{username}"/>
                                </s:url>
                                <s:a href="%{deleteLink}">Delete</s:a>
                            </td>
                            <td>
                            <s:form action="edit" method="POST">
                                <s:hidden value="%{username}" name="id"/>
                                <s:hidden value="%{searhField}" name="searchFiled"/>
                                <s:submit value="Edit"/>
                            </s:form>                               
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
    </body>
</html>
