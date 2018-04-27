<%-- 
    Document   : roboUpdater
    Created on : Apr 26, 2018, 9:54:23 PM
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
        <h3>Hello, General <s:property value="%{#session.AUTHORIZED.firstName}"/> <s:property value="%{#session.AUTHORIZED.miidleName}"/> <s:property value="%{#session.AUTHORIZED.lastName}"/>.</h3>
        <s:form action="robot-update" method="POST">
            <s:textfield label="Jeager" value="%{dto.name}"/>
            <s:submit value="Update" align="center"/>
        </s:form>
        <s:url value="robot-manipulate" method="POST" var="back">
            <s:param name="searchField" value=""/>
        </s:url>
        <a href="%{#back}">Back To Jeager Page</a>
    </body>
</html>
