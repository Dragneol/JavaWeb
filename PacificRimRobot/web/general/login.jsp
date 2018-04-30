<%-- 
    Document   : generalLogin
    Created on : Apr 22, 2018, 10:04:03 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
    <head>
        <s:head/>
    </head>
    <body>
        <h3>Sign In As A General</h3>
        <s:form action="general-sign-in" method="POST">
            <s:textfield name="username" label="Username" value="duongpth"/>
            <s:password name="password" label="Password" value="duongpth"/>
            <s:submit value="Sign In"/>
            <s:reset value="Reset"/>
            <font color="red">
            <s:property value="message"/>
            </font>
        </s:form>
    </body>
</html>

