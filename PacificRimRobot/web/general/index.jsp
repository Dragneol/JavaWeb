<%-- 
    Document   : general
    Created on : Apr 25, 2018, 10:18:02 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="../header.jsp"/>
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <a href="generalFunc1">Jeager Manipulate</a><br/>
        <a href="generalFunc2">Weapon Manipulate</a><br/>
        <a href="generalFunc3">Pilot Manipulate</a><br/>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>

