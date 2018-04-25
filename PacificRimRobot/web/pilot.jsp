<%-- 
    Document   : pilot
    Created on : Apr 22, 2018, 11:45:31 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <body>
        <div class="ai-video-wrapper">
            <h3>Welcome, <s:property value="%{#session.AUTHORIZED.firstName}"/> <s:property value="%{#session.AUTHORIZED.lastName}"/>.</h3>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
