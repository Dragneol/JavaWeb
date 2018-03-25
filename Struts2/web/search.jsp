<%-- 
    Document   : search
    Created on : 13-Mar-2018, 08:01:36
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
        <h3>Welcome, <s:property value="username"/><br>
            EL, Welcome ${sessionScope.USERNAME}<br/>
            Struts Welcome, <s:property value="%{#session.USERNAME}"/>
        </h3>
        <s:form action="searchLastName">
            <s:textfield name="searchValue" label="Seach Value"/>
            <s:submit value="Search"/>
        </s:form>

        <s:if test="%{!searchValue.isEmpty()}">

            <s:if test="%{listAccount != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="listAccount" status="counter">
                            <s:form action="updateRecord" theme="simple">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                    <!-- counter nam trong contextmap-->
                                </td>
                                <td>
                                    <s:property value="username"/>
                                    <s:hidden name="username" value="%{username}"/>
                                </td>
                                <td>
                                    <%--<s:property value="password"/>--%>
                                    <s:textfield name="password" value="%{password}"/>
                                </td>
                                <td>
                                    <s:property value="lastname"/>
                                </td>
                                <td>
                                    <%--<s:property value="role"/>--%>
                                    <s:checkbox name="role" value="%{role}"/>
                                </td>
                                <td>
                                    <s:url id="deleteLink" action="deleteRecord">
                                        <s:param name="pk" value="username"/>
                                        <s:param name="lastSearchValue" value="%{searchValue}"/>
                                    </s:url>
                                    <s:a href="%{deleteLink}">Delete</s:a>
                                </td>
                                <td>
                                    <s:submit value="Update"/>
                                    <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                </td>
                            </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                No record is matched!!!
            </s:else>
        </s:if>

    </body>
</html>
