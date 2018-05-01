<%-- 
    Document   : generalManageRobot
    Created on : Apr 25, 2018, 10:10:35 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <jsp:include page="../header.jsp" />
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <s:form action="pilot-manipulate">
            <s:textfield label="Pilot Name" name="searchField" value="%{searchField}"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{searchField != null && searchField != '' && message == ''}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Pilot</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Team</th>
                        <th>Available</th>
                        <th>View</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="list" status="counter">
                        <s:form action="pilot-info" theme="simple">
                            <tr>
                                <td><s:property value="%{#counter.count}" /></td>
                                <td><img src="img/<s:property value='%{imgLink}'/>" width="100" height="100"/></td>
                                <td><s:property value="%{firstName}" /></td>
                                <td><s:property value="%{lastName}" /></td>
                                <td><s:property value="%{groupCode}" /></td>
                                <td><s:checkbox name="available" value="%{available}" fieldValue="true"/></td>
                                <td><s:submit value="View"/></td>
                                <s:hidden value="%{searchField}" name="searchField"/>
                                <s:hidden value="%{username}" name="username"/>
                            </s:form>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <s:property value="%{message}"/>
        </s:else>
        <s:a action="main-page">General Page</s:a>
        <jsp:include page="../footer.jsp" />
    </body>
</html>
