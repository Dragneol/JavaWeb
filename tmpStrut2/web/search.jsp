<%-- 
    Document   : search
    Created on : Mar 13, 2018, 8:03:36 AM
    Author     : dragneol
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
        <h1>Hello ${sessionScope.USERNAME}!</h1>
        <h1>Hello <s:property value=""/></h1>
        <h1>Strut welcome <s:property value="%{session.USERNAME}"/></h1>
        <h2>This is a search page</h2>
        <s:form action="searchLastName">
            <s:textfield name="searchValue" label="Search Value"/>
            <s:submit value="Search"/>
        </s:form>

        ${searchValue}

        <s:if test="%{!searchValue.isEmpty()}">
            <s:if test="listResult!=null">
                <table border="1">
                    <thead>
                        <tr>
                            <td>No.</td>
                            <td>username</td>
                            <td>password</td>
                            <td>lastname</td>
                            <td>role</td>                            
                            <td>Update</td>                            
                            <td>Delete</td>                            
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listResult" status="counter">
                            <s:form action="updateRecord" method="POST" theme="simple">
                                <tr>
                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td>
                                        <s:property value="username"/>
                                        <s:hidden name="username" value="%{username}"/>
                                    </td>
                                    <td>
                                        <%--<s:property value="password"/>--%>
                                        <s:textfield name="password" value="%{password}"/>
                                    </td>
                                    <td><s:property value="lastname"/><s:hidden name="lastname" value="%{lastname}"/></td>
                                    <td><s:property value="role"/><s:checkbox name="admin" value="%{role}"/></td>
                                    <td>
                                        <s:url id="deleteLink" action="deleteRecord">
                                            <s:param name="pk" value="username"/>
                                            <s:param name="lastSearchValue" value="searchValue"/>
                                        </s:url>
                                        <s:a href="%{deleteLink}">Delete</s:a>
                                        </td>
                                        <td>
                                        <s:submit value="Update"/>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                <h3>No record match</h3>
            </s:else>
        </s:if>
    </body>
</html>
