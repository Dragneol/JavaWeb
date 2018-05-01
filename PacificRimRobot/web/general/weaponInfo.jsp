<%-- 
    Document   : weaponInfo
    Created on : Apr 30, 2018, 4:48:04 PM
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
    </head>
    <body>
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.miidleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>.
        </h3>
        <s:form action="weapon-update">
            <s:hidden name="weaponCode" value="%{id}"/>
            <s:textfield label="Weapon Name" value="%{weapon.weaponName}" name="weaponName"/>
            <s:select label="Equied By" headerKey="-1" headerValue="None" list="robot" name="robotEquired" value="%{robotEquired}"/>
            <s:checkbox label="Available" name="available"/>
            <s:submit value="Update" align="center"/>
        </s:form>
        
        <%--
        <s:url action="weapon-manipulate" id="back">
            <s:param name="searchField" value="%{searchField}"/>
        </s:url>
        <s:a value="%{back}">Back To Weapon Page</s:a>
        --%>
        
        <a href="weapon-manipulate?searchField=<s:property value='%{searchField}'/>">Back To Weapon Page</a>
    </body>
</html>
