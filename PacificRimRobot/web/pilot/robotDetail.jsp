<%-- 
    Document   : robotDetail
    Created on : Apr 30, 2018, 11:49:57 AM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page errorPage="/error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Robot <input type="text" name="name" value="<s:property value="%{jeager.name}"/>" readonly/><br/>
        Origin <input type="text" name="origin" value="<s:property value="%{jeager.origin}"/>" /><br/>
        Classified <input type="text" name="classified" value="<s:property value="%{jeager.classified}"/>" /><br/>
        Lauched Date <input type="date" name="date"  value="<s:date format="yyyy-MM-dd" name="%{jeager.dateLauched}"/>" /><br/>
        Kaiju Killed <input type="number" name="kaijuKilled" value="<s:property value="%{jeager.kaijuKilled}"/>"/><br/>
        Is Available <input type="checkbox" name="available" value="true" 
    <s:if test="%{jeager.available}">
        checked="checked"
    </s:if>
    /><br/>
</body>
</html>
