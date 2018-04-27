<%-- 
    Document   : generalManageRobot
    Created on : Apr 25, 2018, 10:10:35 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Welcome, General <s:property value="%{#session.AUTHORIZED.firstName}"/> <s:property value="%{#session.AUTHORIZED.miidleName}"/> <s:property value="%{#session.AUTHORIZED.lastName}"/>.</h3>        
        <s:form action="pilot-manipulate">
            <s:textfield label="Pilot Name" name="searchField" value="%{<s:property value='searchField' />}"/>
            <s:submit label="Search"/>
        </s:form>
        <c:out value="${requestScope.LIST}"/>
        <c:out value="${param.searchFiled}"/>
    </body>
</html>
