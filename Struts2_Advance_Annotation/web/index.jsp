<%-- 
    Document   : index
    Created on : Apr 28, 2018, 9:44:27 AM
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
        <h1>Register!</h1>
        <s:form action="registration">
            <s:textfield label="Username" name="username"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="Confirm Password"/>
            <s:textfield label="Fullname" name="fullname"/>
            <s:textfield label="Email" name="email"/>
            <s:textfield label="Phone" name="phone"/>       
            <s:submit value="Create"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <font color="red"><s:property value="username"/>is existed!</font>
        </s:if>
    </body>
</html>
