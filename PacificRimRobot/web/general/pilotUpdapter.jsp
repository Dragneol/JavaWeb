<%-- 
    Document   : pilotUpdapter
    Created on : May 2, 2018, 2:00:42 AM
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
        <jsp:include page="../header.jsp" />
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <hr>
        <h4><s:property value="%{pilot.username}"/>'s Information</h4>

        <s:form action="pilot-update">
            <img src="img/<s:property value='%{pilot.imgLink}'/>" width="200" height="200"/>
            <s:textfield label="First Name" name="firstName" value="%{pilot.firstName}" />
            <s:textfield label="Last Name" name="lastName" value="%{pilot.lastName}" />
            <s:textfield label="Weight" name="weight" value="%{pilot.weight}" />
            <s:textfield label="Height" name="height" value="%{pilot.height}" />
            <s:textfield label="Citizenship" name="citizenship" value="%{pilot.citizenship}" />
            <s:textfield label="Ranker" name="ranker" value="%{pilot.ranker}" />
            <s:checkboxlist name="skills" list="%{skills}" listKey="id" listValue="name" value="skills.{?#this.checked == true}.{id}" label="Battle Skill"/><br/>
            <s:checkbox name="available" value="%{pilot.available}" fieldValue="true" label="Available"/>
            <s:submit value="Update" align="left"/>
        </s:form>
            
        <%--
        <s:url action="pilot-manipulate" id="back">
            <s:param name="searchField" value="%{searchField}"/>
        </s:url>
        <s:a value="%{back}">Back To Pilot Page</s:a>
        --%>
        <a href="pilot-manipulate?searchField=<s:property value='%{searchField}'/>">Back To Pilot Page</a>
        <jsp:include page="../footer.jsp" />
    </body>
</html>
