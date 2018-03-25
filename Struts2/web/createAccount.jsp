<%-- 
    Document   : createAccount
    Created on : 13-Mar-2018, 09:39:40
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <s:head/>
    </head>
    <body>
        <h1>Create new account</h1>
        <s:form action="register">
            <s:textfield name="username" label="Username *"/>
            <s:label value="6-30 char"/>
            <s:password name="password" label="Password *"/>
            <s:label value="6-30 char"/>
            <s:password name="confirm" label="Confirm Password *"/>
            <s:label value="6-30 char"/>
            <s:textfield name="lastname" label="Last name *"/>
            <s:label value="6-30 char"/>
            <s:submit value="Create"/>
        </s:form>
        <s:if test="%{exception.message.contain('duplicate')">
            <s:property value="username"/> is existed!
        </s:if>
    </body>
</html>
