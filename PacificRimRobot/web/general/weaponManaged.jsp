<%-- 
    Document   : generalManageRobot
    Created on : Apr 25, 2018, 10:10:35 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page errorPage="/error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.miidleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>.
        </h3>        
        <s:form action="weapon-manipulate" method="POST">
            <s:textfield label="Weapon Name" name="searchField" value="%{searchField}"/>
            <s:submit label="Search"/>
        </s:form>
        <s:if test="%{searchField != null && searchField != '' && message == ''}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Weapon Name</th>
                        <th>View</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{list}" status="counter">
                        <s:form action="weapon-info" theme="simple">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td>
                                    <s:property value="%{weaponName}"/>
                                    <s:hidden name="id" value="%{weaponCode}" />
                                    <s:hidden name="searchField" value="%{searchField}" />
                                </td>
                                <td><s:submit value="View"/></td>
                            </tr>
                        </s:form>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:else>
            <font color="red">
            <s:property value="%{message}"/>
            </font>
        </s:else>
    </body>
</html>
