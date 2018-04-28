<%-- 
    Document   : error
    Created on : Apr 28, 2018, 8:41:48 AM
    Author     : DuongPTHSE62871
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
        <h1>ERROR!</h1>
        <font color="red">
        <s:property value="%{#request.ERROR}"/><br/>
        </font>
        <s:a href="index.jsp">Back</s:a>
    </body>
</html>
