<%-- 
    Document   : pilotLogin
    Created on : Apr 22, 2018, 10:03:52 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
    <head>
        <s:head/>
    </head>
    <body>
        <h3>Sign In As A Pilot</h3>
        <s:form action="pilot-sign-in" method="POST">
            <s:textfield name="username" label="Username" value="jake"/>
            <s:password name="password" label="Password" value="jake"/>
            <s:submit value="Sign In"/>
            <s:reset value="Reset"/>
            <font color="red">
            <s:property value="message"/>
            </font>
        </s:form>
    </body>
</html>