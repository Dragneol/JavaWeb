<%-- 
    Document   : index
    Created on : Apr 28, 2018, 8:19:44 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="login">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>
