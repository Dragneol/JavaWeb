<%-- 
    Document   : index
    Created on : March 24, 2018, 10:46:51 AM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Shop</title>
        <s:head/>
    </head>
    <body>
        <h1>Please Sign In to continue!</h1>
        <s:form action="signin" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Sign in"/>
            <font color="red"><s:property value="message"/></font><br/>
        </s:form>
            Or haven't had account yet? <a href="signupPage">Create new account!</a>
    </body>
</html>
