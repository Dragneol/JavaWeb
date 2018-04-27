<%-- 
    Document   : index
    Created on : Apr 26, 2018, 8:38:02 AM
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
        <s:form action="test" method="POST">
            <s:textfield name="test" label="text"/>
            <s:submit value="sub"/>
        </s:form>
    </body>
</html>
