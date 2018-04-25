<%-- 
    Document   : generalLogin
    Created on : Apr 22, 2018, 10:04:03 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="header.jsp"/>
<div class="ai-video-wrapper">
    <h3>Sign In As A Pilot</h3>
    <s:form action="pilot-sign-in">
        <s:textfield name="username" label="Username"/>
        <s:password name="password" label="Password"/>
        <s:submit value="Sign In"/>
        <s:reset value="Reset"/>
        <font color="red"><s:property value="message"/></font>
    </s:form>
</div>
<jsp:include page="footer.jsp"/>

