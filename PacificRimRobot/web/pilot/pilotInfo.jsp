<%-- 
    Document   : pilotInfo
    Created on : May 1, 2018, 4:35:00 PM
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
        <h3>Welcome, <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <hr>
        <h4><s:property value="%{pilot.username}"/>'s Information</h4>

        <s:form action="pilot-update">
            <img src="img/<s:property value='%{pilot.imgLink}'/>" width="200" height="200"/>
            <s:textfield readonly="true" label="First Name" name="firstName" value="%{pilot.firstName}" />
            <s:textfield readonly="true" label="Last Name" name="lastName" value="%{pilot.lastName}" />
            <s:textfield readonly="true" label="Weight" name="weight" value="%{pilot.weight}" />
            <s:textfield readonly="true" label="Height" name="height" value="%{pilot.height}" />
            <s:textfield readonly="true" label="Citizenship" name="citizenship" value="%{pilot.citizenship}" />
            <s:textfield readonly="true" label="Ranker" name="ranker" value="%{pilot.ranker}" />
            <s:checkboxlist name="skills" list="%{skills}" listKey="id" listValue="name" value="skills.{?#this.checked == true}.{id}" label="Battle Skill" disabled="true"/><br/>
        </s:form>

        <a href="pilot-view">Back to Index</a>
    </body>
</html>
