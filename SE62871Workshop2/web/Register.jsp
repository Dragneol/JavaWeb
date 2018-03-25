<%-- 
    Document   : Register
    Created on : March 24, 2018, 12:32:11 PM
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
        <h1>Register</h1>
        <s:form action="register" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="Confirm password"/>
            <s:textfield name="fullname" label="Full name"/>
            <s:submit value="Register"/>
            <s:if test="%{exception.message.contains('duplicate')}">
                <font color="red">
                <s:property value="username"/> is existed!
                </font>
            </s:if>
        </s:form>
        Already had an account? <a href="SignInPage.jsp">Sign In</a>
    </body>
</html>
