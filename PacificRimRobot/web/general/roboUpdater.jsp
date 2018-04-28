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
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        
        
        <form action="robot-update" method="POST">
            <input type="text" name="name" value="<s:property value="%{jeager.name}"/>" />
            <input type="text" name="origin" value="<s:property value="%{jeager.origin}"/>" />
            <input type="text" name="classified" value="<s:property value="%{jeager.classified}"/>" />
            <input type="date" name="dateLauched"  value="<s:date format="yyyy-MM-dd" name="%{jeager.dateLauched}"/>" />
            <input type="number" name="" value="<s:property value="%{jeager.kaijuKilled}"/>" />
            <input type="checkbox" name="available" value="true" 
                   <s:if test="%{jeager.available}">
                       checked="checked"
                   </s:if>
                   />
            <s:submit value="Update" align="center"/>
        </form>
        <s:url action="robot-manipulate" id="back">
            <s:param name="searchField" value="%{searchField}"/>
        </s:url>
        <s:a href="%{back}">Back To Jeager Page</s:a>
    </body>
</html>
