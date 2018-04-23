<%-- 
    Document   : pilot
    Created on : Apr 22, 2018, 11:45:31 PM
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
        <s:label>Welcome<s:property value="%{#session.AUTHORIZED.Firstname}" /></s:label>
    </body>
</html>
