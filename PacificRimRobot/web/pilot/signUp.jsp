<%-- 
    Document   : pilotSignUp
    Created on : Apr 23, 2018, 6:23:01 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FBI International Defend</title>
    </head>
    <body>
        <%--<jsp:include page="header.jsp"/>--%>
        <div class="ai-video-wrapper">
            <h3>Sign Up for Battle Against Kaiju</h3>
            <s:form action="pilot-sign-up">
                <s:textfield label="username" name="username"/>
                <s:password label="password" name="password"/>
                <s:password label="Confirm password" name="confirm"/>
                <s:textfield label="Firstname" name="firstname"/>
            </s:form>
            <%--<jsp:include page="footer.jsp"/>--%>
    </body>
</html>
