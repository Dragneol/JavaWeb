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
        <jsp:include page="../header.jsp" />
        <h3>Welcome, 
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <h4>This is your jeager info</h4>

        <s:if test="%{userImageFileName != null && userImageFileName != ''}">
            <img src="img/${requestScope.userImageFileName}" width="200" height="200" /><br/>
            <input type="hidden" name="imgLink" value="${requestScope.userImageFileName}" /> 
        </s:if>
        <s:else>
            <img src="img/${requestScope.jeager.imgLink}" width="200" height="200" /><br/>
            <input type="hidden" name="imgLink" value="${requestScope.jeager.imgLink}" />
        </s:else>
        Robot <input type="text" name="name" value="<s:property value="%{jeager.name}"/>" readonly/><br/>
        Origin <input type="text" name="origin" value="<s:property value="%{jeager.origin}"/>" readonly/><br/>
        Classified <input type="text" name="classified" value="<s:property value="%{jeager.classified}"/>" readonly/><br/>
        Lauched Date <input type="date" name="date"  value="<s:date format="yyyy-MM-dd" name="%{jeager.dateLauched}"/>" readonly/><br/>
        Kaiju Killed <input type="number" name="kaijuKilled" value="<s:property value="%{jeager.kaijuKilled}"/>" readonly/><br/>
        <s:checkboxlist name="skills" list="%{skills}" listKey="id" listValue="name" value="skills.{?#this.checked == true}.{id}" label="Battle Skill" disabled="true"/><br/>
        <a href="pilot-view">Back to Index</a>
        <jsp:include page="../footer.jsp" />
    </body>
</html>
