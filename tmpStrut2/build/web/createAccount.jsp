<%-- 
    Document   : createAccount
    Created on : Mar 13, 2018, 9:38:43 AM
    Author     : dragneol
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
        <h1>Hello World!</h1>
        <s:form action="createAccount">
            Username <s:textfield name="username" label="Username"/>
            Password <s:password name="password" label="Password"/>
            <s:submit value="Create New Account"/>
            <s:reset>
        </s:form>
    </body>
</html>
