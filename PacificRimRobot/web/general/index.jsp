<%-- 
    Document   : general
    Created on : Apr 25, 2018, 10:18:02 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <%--<jsp:include page="header.jsp"/>--%>
    <body>
        <div class="ai-video-wrapper">
            <h3>Welcome, General <s:property value="%{#session.AUTHORIZED.firstName}"/> <s:property value="%{#session.AUTHORIZED.miidleName}"/> <s:property value="%{#session.AUTHORIZED.lastName}"/>.</h3>
            <a href="generalFunc1">Jeager Manipulate</a><br/>
            <a href="generalFunc2">Weapon Manipulate</a><br/>
            <a href="generalFunc3">Pilot Manipulate</a><br/>
        </div>
    </body>
    <%--<jsp:include page="footer.jsp"/>--%>
</html>

