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
    </head>
    <body>
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <s:form action="pilot-manipulate">
            <s:textfield label="Pilot Name" name="searchField" value="%{request.searchField}"/>
            <s:submit label="Search"/>
        </s:form>
</body>
</html>
