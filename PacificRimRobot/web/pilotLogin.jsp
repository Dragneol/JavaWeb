<%-- 
    Document   : pilotLogin
    Created on : Apr 22, 2018, 10:03:52 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FBI International Defend</title>
    </head>
    <body>
        <h1>Sign In As Pilot</h1>
        <s:form action="pilot-sign-in">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Sign In"/>
            <s:reset value="Reset"/>
            <font color="red"><s:property value="message"/></font>
        </s:form>
    </body>
</html>
